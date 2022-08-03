package com.agnaldodd.domain.project.infrastructure.persistence

import com.agnaldodd.domain.project.core.Project
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface ProjectSQLRepository : CrudRepository<Project, Long> {
}