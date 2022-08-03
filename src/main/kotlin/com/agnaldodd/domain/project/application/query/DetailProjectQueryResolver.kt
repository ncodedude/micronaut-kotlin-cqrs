package com.agnaldodd.domain.project.application.query

import com.agnaldodd.common.application.query.AbstractQueryResolver
import com.agnaldodd.common.application.query.ApplicationQuery
import com.agnaldodd.domain.project.application.command.CreateProjectCommand
import com.agnaldodd.domain.project.core.Project
import com.agnaldodd.domain.project.infrastructure.persistence.ProjectSQLRepository
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailProjectQueryResolver: AbstractQueryResolver<Project>() {

    @Inject
    lateinit var repository: ProjectSQLRepository

    override fun resolveQuery(query: ApplicationQuery<Project>?): Any {
        val query = (query as DetailProjectQuery)
        val project = this.repository.findById(query.getId())
        return project.get().also { null }
    }
}
