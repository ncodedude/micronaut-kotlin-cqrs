package com.agnaldodd.domain.project.controller


import com.agnaldodd.common.application.ApplicationDispatcherInterface
import com.agnaldodd.domain.project.application.command.CreateProjectCommand
import com.agnaldodd.domain.project.application.command.CreateProjectCommandHandler
import com.agnaldodd.domain.project.infrastructure.configuration.ApplicationDispatcherProjectInjection
import io.micronaut.core.annotation.Introspected
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post


@Controller("/projects")
class CreateProjectController(
    private val applicationDispatcher: ApplicationDispatcherInterface,
    private val injection: ApplicationDispatcherProjectInjection
) {

    init {
        this.injection.registerHandlers()
    }

    @Post
    fun create(@Body project: Project): HttpResponse<Project> {
        val command = project.toCommand()
        this.applicationDispatcher.execute(command)
        return HttpResponse.ok()
    }
}

@Introspected
data class Project(
 val name: String,
 val credit: String
){
    fun toCommand(): CreateProjectCommand {
        return CreateProjectCommand(name, credit);
    }
}
