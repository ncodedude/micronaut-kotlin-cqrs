package com.agnaldodd.domain.project.controller

import com.agnaldodd.common.application.dispatcher.register.ApplicationDispatcherInterface
import com.agnaldodd.domain.project.controller.dto.UpdateProjectRequest
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Put

@Controller("/projects")
class UpdateProjectController(private val applicationDispatcher: ApplicationDispatcherInterface) {

    @Put("/{id}")
    fun update(@PathVariable id:Long,
               request:UpdateProjectRequest
    ){
        applicationDispatcher.execute(request.toCommand(id))
    }
}