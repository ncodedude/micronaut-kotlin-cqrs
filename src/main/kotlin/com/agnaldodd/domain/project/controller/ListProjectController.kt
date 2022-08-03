package com.agnaldodd.domain.project.controller

import com.agnaldodd.common.application.ApplicationDispatcherInterface
import com.agnaldodd.domain.project.application.query.ListProjectQuery
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/projects")
class ListProjectController(private val applicationDispatcher: ApplicationDispatcherInterface) {

    @Get("/")
    fun list(): HttpResponse<Any>{
        var query = ListProjectQuery()
        var result = this.applicationDispatcher.execute(query);
        return HttpResponse.ok(result)
    }
}