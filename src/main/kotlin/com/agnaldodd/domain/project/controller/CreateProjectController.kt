package com.agnaldodd.domain.project.controller


import com.agnaldodd.common.application.dispatcher.register.ApplicationDispatcherInterface
import com.agnaldodd.domain.project.controller.dto.CreateProjectRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post


@Controller("/projects")
class CreateProjectController(
    private val applicationDispatcher: ApplicationDispatcherInterface
) {

    @Post
    fun create(@Body createProjectRequest: CreateProjectRequest): HttpResponse<CreateProjectRequest> {
        val command = createProjectRequest.toCommand()
        this.applicationDispatcher.execute(command)
        return HttpResponse.ok()
    }
}


