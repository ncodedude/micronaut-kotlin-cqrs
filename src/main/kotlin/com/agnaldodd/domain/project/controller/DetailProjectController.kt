package com.agnaldodd.domain.project.controller

import com.agnaldodd.common.application.ApplicationDispatcherInterface
import com.agnaldodd.domain.project.application.query.DetailProjectQuery
import io.micronaut.core.annotation.Introspected
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable

@Controller("/projects")
class DetailProjectController (private val applicationDispatcher: ApplicationDispatcherInterface
) {

    @Get("/{projectId}")
    fun detail(@PathVariable projectId: Long): HttpResponse<Any> {
        val query = ProjectQuery(projectId).toQuery()
        var result = this.applicationDispatcher.execute(query)
        return HttpResponse.ok(result)
    }
}


@Introspected
data class ProjectQuery(
    var id: Long
){
    fun toQuery(): DetailProjectQuery {
        return DetailProjectQuery(id);
    }
}