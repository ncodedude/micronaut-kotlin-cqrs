package com.agnaldodd.configuration

import com.agnaldodd.common.application.dispatcher.register.ApplicationDispatcher
import com.agnaldodd.domain.files.application.command.CreateFileCommand
import com.agnaldodd.domain.files.application.command.CreateFileCommandHandler
import com.agnaldodd.domain.project.application.command.CreateProjectCommand
import com.agnaldodd.domain.project.application.command.CreateProjectCommandHandler
import com.agnaldodd.domain.project.application.command.UpdateProjectCommand
import com.agnaldodd.domain.project.application.command.UpdateProjectCommandHandler
import com.agnaldodd.domain.project.application.query.DetailProjectQuery
import com.agnaldodd.domain.project.application.query.DetailProjectQueryResolver
import com.agnaldodd.domain.project.application.query.ListProjectQuery
import com.agnaldodd.domain.project.application.query.ListProjectQueryResolver
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory

@Factory
class ApplicationDispatcherFactory(private val createProjectCommandHandler: CreateProjectCommandHandler,
                                   private val resolver: DetailProjectQueryResolver,
                                   private val listResolver: ListProjectQueryResolver,
                                   private val updateProjectCommandHandler: UpdateProjectCommandHandler,
                                   private val createFileCommandHandler: CreateFileCommandHandler
) {

    @Bean
    fun  init() : ApplicationDispatcher {
        val dispatcher =  ApplicationDispatcher()
        dispatcher.registerHandlerCommand(CreateProjectCommand::class.simpleName as String, createProjectCommandHandler)
        dispatcher.registerQueryResolver(DetailProjectQuery::class.simpleName as String, resolver)
        dispatcher.registerQueryResolver(ListProjectQuery::class.simpleName as String, listResolver)
        dispatcher.registerHandlerCommand(UpdateProjectCommand::class.simpleName as String,updateProjectCommandHandler)
        dispatcher.registerHandlerCommand(CreateFileCommand::class.simpleName as String, createFileCommandHandler)

        return dispatcher
    }
}