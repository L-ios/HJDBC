package io.github.lios.mysti.query

import org.springframework.data.jpa.repository.JpaRepository

open interface ContainerStatsRepository : JpaRepository<ContainerStats, ContainerStatsId> {

    //fun findTop10ByContainerIdOrderByTimeDesc(containerId: String): List<ContainerStats>
}