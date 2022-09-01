package com.agnaldodd.domain.project.controller

import com.agnaldodd.common.application.dispatcher.register.ApplicationDispatcherInterface
import com.agnaldodd.domain.project.controller.dto.ProjectQuery
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