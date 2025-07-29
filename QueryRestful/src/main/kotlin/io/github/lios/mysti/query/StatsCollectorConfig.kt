package io.github.lios.mysti.query

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "docker.stats")
class StatsCollectorConfig {
    var intervalMillis: Long = 1000
    var dockerHost: String = "unix:///var/run/docker.sock"
}