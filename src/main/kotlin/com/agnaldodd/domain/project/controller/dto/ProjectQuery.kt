package com.agnaldodd.domain.project.controller.dto

import com.agnaldodd.domain.project.application.query.DetailProjectQuery
import io.micronaut.core.annotation.Introspected

@Introspected
data class ProjectQuery(
    var id: Long
){
    fun toQuery(): DetailProjectQuery {
        return DetailProjectQuery(id);
    }
}