package com.agnaldodd.domain.project.application.query

import com.agnaldodd.common.application.query.ApplicationQuery
import com.agnaldodd.domain.project.core.Project

class DetailProjectQuery(private val projectId: Long) : ApplicationQuery<Project> {
    fun getId(): Long {
        return projectId
    }
}