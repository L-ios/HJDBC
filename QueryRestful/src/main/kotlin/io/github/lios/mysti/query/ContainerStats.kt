package io.github.lios.mysti.query

import jakarta.persistence.*
import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable
import java.time.Instant

@Entity
@Table(name = "container_stats")
data class ContainerStats(
    @EmbeddedId
    val id: ContainerStatsId,

    @Column(name = "container_name", nullable = false, length = 255)
    val containerName: String,

    // 修复精度问题：使用 columnDefinition 替代 precision/scale
    @Column(name = "cpu_percent", nullable = false, columnDefinition = "DECIMAL(5,2)")
    val cpuPercent: Double,

    @Column(name = "memory_usage", nullable = false)
    val memoryUsage: Long,

    @Column(name = "memory_limit", nullable = false)
    val memoryLimit: Long,

    // 修复精度问题：使用 columnDefinition 替代 precision/scale
    @Column(name = "memory_percent", nullable = false, columnDefinition = "DECIMAL(5,2)")
    val memoryPercent: Double,

    @Column(name = "network_rx", nullable = false)
    val networkRx: Long,

    @Column(name = "network_tx", nullable = false)
    val networkTx: Long,

    @Column(name = "block_read", nullable = false)
    val blockRead: Long,

    @Column(name = "block_write", nullable = false)
    val blockWrite: Long,

    @Column(name = "pids", nullable = false)
    val pids: Int
)
{
    // 必须添加无参构造函数
    constructor() : this(
        id = ContainerStatsId(),
        containerName = "",
        cpuPercent = 0.0,
        memoryUsage = 0L,
        memoryLimit = 0L,
        memoryPercent = 0.0,
        networkRx = 0L,
        networkTx = 0L,
        blockRead = 0L,
        blockWrite = 0L,
        pids = 0
    )

    // 辅助构造函数
    constructor(
        time: Instant,
        containerId: String,
        containerName: String,
        cpuPercent: Double,
        memoryUsage: Long,
        memoryLimit: Long,
        memoryPercent: Double,
        networkRx: Long,
        networkTx: Long,
        blockRead: Long,
        blockWrite: Long,
        pids: Int
    ) : this(
        id = ContainerStatsId(time, containerId),
        containerName = containerName,
        cpuPercent = cpuPercent,
        memoryUsage = memoryUsage,
        memoryLimit = memoryLimit,
        memoryPercent = memoryPercent,
        networkRx = networkRx,
        networkTx = networkTx,
        blockRead = blockRead,
        blockWrite = blockWrite,
        pids = pids
    )

    // 获取时间便捷方法
    fun getTime(): Instant = id.time

    // 获取容器ID便捷方法
    fun getContainerId(): String = id.containerId
}


@Embeddable
data class ContainerStatsId(
    @Column(name = "__time", nullable = false)
    val time: Instant,

    @Column(name = "container_id", nullable = false, length = 64)
    val containerId: String
) : Serializable {
    // 必须添加无参构造函数
    constructor() : this(Instant.now(), "")

    // 实现 equals 和 hashCode
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ContainerStatsId) return false

        return time == other.time &&
                containerId == other.containerId
    }

    override fun hashCode(): Int {
        var result = time.hashCode()
        result = 31 * result + containerId.hashCode()
        return result
    }
}