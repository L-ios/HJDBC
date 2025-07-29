package io.github.lios.mysti.query

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.dockerjava.api.DockerClient
import com.github.dockerjava.api.async.ResultCallback
import com.github.dockerjava.api.model.Container
import com.github.dockerjava.api.model.Statistics
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.Instant
import kotlin.math.pow
import kotlin.math.roundToInt

@Service
class ContainerStatsService(
    private val dockerClient: DockerClient,
    private val statsRepository: ContainerStatsRepository,
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    open fun listContainers(): List<Container> {
        return dockerClient.listContainersCmd().exec().filterNotNull().toList()
    }

    fun getContainerStats(container: Container) {
        try {
            val stats = dockerClient.statsCmd(container.id).withNoStream(true)
            stats.exec(object : ResultCallback.Adapter<Statistics>() {
                override fun onNext(item: Statistics) {
                    val result = parseStats(container, item)
                    statsRepository.save(result!!)
                    logger.debug("Saved stats for container: ${container.names[0]}")
                }
            })
        } catch (ex: Exception) {
            logger.error("Error fetching stats for container ${container.id}: ${ex.message}")
        }
    }

    private fun parseStats(container: Container, stats: Statistics): ContainerStats {
     // 解析 CPU 使用率
        val cpuDelta = stats.cpuStats.cpuUsage?.totalUsage!! - stats.preCpuStats.cpuUsage?.totalUsage!!

        val systemDelta = stats.cpuStats.systemCpuUsage!! - stats.preCpuStats.systemCpuUsage!!

        val cpuPercent = if (systemDelta > 0) {
            (cpuDelta.toDouble() / systemDelta * 100 * stats.cpuStats.onlineCpus!!)
                .roundTo(2)
        } else 0.0

        // 解析内存使用
        val memoryUsage = stats.memoryStats?.usage!!
        val memoryLimit = stats.memoryStats?.limit!!
        val memoryPercent = (memoryUsage.toDouble() / memoryLimit * 100).roundTo(2)

        // 解析网络 I/O
        var networkRx = 0L
        var networkTx = 0L
        stats.networks?.forEach { (_, network) ->
            networkRx += network.rxBytes!!
            networkTx += network.txBytes!!
        }

        // 解析块设备 I/O
        var blockRead = 0L
        var blockWrite = 0L
        stats.blkioStats?.ioServiceBytesRecursive?.forEach { io ->
            when (io.op) {
                "Read" -> blockRead += io.value!!
                "Write" -> blockWrite += io.value!!
            }
        }

        // 解析 PIDs
        val pids = stats.pidsStats?.current!!

        var containerName = container.names[0]
        containerName = containerName.split("_")[2]
        return ContainerStats(
            id = ContainerStatsId(
                time = Instant.parse(stats.preread!!),
                containerId = container.id,
            ),
            containerName = containerName,
            cpuPercent = cpuPercent,
            memoryUsage = memoryUsage,
            memoryLimit = memoryLimit,
            memoryPercent = memoryPercent,
            networkRx = networkRx,
            networkTx = networkTx,
            blockRead = blockRead,
            blockWrite = blockWrite,
            pids = pids.toInt()
        )

    }

    private fun Double.roundTo(decimals: Int): Double {
        val factor = (10.0).pow(decimals)
        return (this * factor).roundToInt() / factor
    }
}