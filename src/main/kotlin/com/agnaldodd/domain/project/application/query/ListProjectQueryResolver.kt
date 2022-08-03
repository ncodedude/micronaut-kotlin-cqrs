package com.agnaldodd.domain.project.application.query

import com.agnaldodd.common.application.query.AbstractQueryResolver
import com.agnaldodd.common.application.query.ApplicationQuery
import com.agnaldodd.domain.project.core.Project
import com.agnaldodd.domain.project.core.ProjectDTO
import com.agnaldodd.domain.project.infrastructure.persistence.ProjectSQLRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListProjectQueryResolver : AbstractQueryResolver<Project>() {

    @Inject
    lateinit var repository: ProjectSQLRepository

    override fun resolveQuery(query: ApplicationQuery<Project>?): Any {
        var projects = this.repository.findAll().map { ProjectDTO(it) }
        return  projects
    }
}