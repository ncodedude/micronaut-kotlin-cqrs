package com.agnaldodd.domain.project.infrastructure.configuration

import com.agnaldodd.common.application.ApplicationDispatcherInterface
import com.agnaldodd.domain.project.application.command.CreateProjectCommand
import com.agnaldodd.domain.project.application.command.CreateProjectCommandHandler
import com.agnaldodd.domain.project.application.query.DetailProjectQuery
import com.agnaldodd.domain.project.application.query.DetailProjectQueryResolver
import com.agnaldodd.domain.project.application.query.ListProjectQuery
import com.agnaldodd.domain.project.application.query.ListProjectQueryResolver

import javax.inject.Singleton

@Singleton
class ApplicationDispatcherProjectInjection(private val applicationDispatcher: ApplicationDispatcherInterface,
                                            private val handler: CreateProjectCommandHandler,
                                            private val resolver: DetailProjectQueryResolver,
                                            private val listResolver: ListProjectQueryResolver
) {


    fun registerHandlers() {
        this.applicationDispatcher.registerHandlerCommand(CreateProjectCommand::class.simpleName as String, handler)
    }

    fun registerResolvers() {
        this.applicationDispatcher.registerQueryResolver(DetailProjectQuery::class.simpleName as String, resolver)
        this.applicationDispatcher.registerQueryResolver(ListProjectQuery::class.simpleName as String, listResolver)
    }
}