package io.github.lios.mysti.query


import kotlinx.coroutines.*
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service
import java.time.Duration
import java.time.Instant

@Service
class StatsCollectorService(
    private val dockerStatsService: ContainerStatsService,
    private val statsRepository: ContainerStatsRepository,
    private val config: StatsCollectorConfig
) {
    private val logger = LoggerFactory.getLogger(javaClass)
    private val scope = CoroutineScope(Dispatchers.IO)

    @EventListener(ApplicationReadyEvent::class)
    fun startMonitoring() {
        dockerStatsService.listContainers()
            .forEach { container ->
            scope.launch {
                while (isActive) {
                    try {
                        val startTime = Instant.now()
                        dockerStatsService.getContainerStats(container)

                        val elapsed = Duration.between(startTime, Instant.now()).toMillis()
                        val sleepTime = config.intervalMillis - elapsed

                        if (sleepTime > 0) {
                            delay(sleepTime)
                        } else {
                            logger.warn("Stats collection for ${container.id} took longer than interval: ${-sleepTime}ms over")
                        }
                    } catch (ex: Exception) {
                        logger.error("Error in stats collection for ${container.id}: ${ex.message}")
                        delay(config.intervalMillis) // 防止错误循环
                    }
                }
            }
        }
    }
}