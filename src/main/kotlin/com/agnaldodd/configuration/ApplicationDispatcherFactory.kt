package com.agnaldodd.configuration

import com.agnaldodd.common.application.ApplicationDispatcher
import com.agnaldodd.domain.project.application.command.CreateProjectCommand
import com.agnaldodd.domain.project.application.command.CreateProjectCommandHandler
import com.agnaldodd.domain.project.application.query.DetailProjectQuery
import com.agnaldodd.domain.project.application.query.DetailProjectQueryResolver
import com.agnaldodd.domain.project.application.query.ListProjectQuery
import com.agnaldodd.domain.project.application.query.ListProjectQueryResolver
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory

@Factory
class ApplicationDispatcherFactory(private val handler: CreateProjectCommandHandler,
                                   private val resolver: DetailProjectQueryResolver,
                                   private val listResolver: ListProjectQueryResolver
) {

    @Bean
    fun  init() : ApplicationDispatcher {
        val dispatcher =  ApplicationDispatcher();
        dispatcher.registerHandlerCommand(CreateProjectCommand::class.simpleName as String, handler)
        dispatcher.registerQueryResolver(DetailProjectQuery::class.simpleName as String, resolver)
        dispatcher.registerQueryResolver(ListProjectQuery::class.simpleName as String, listResolver)

        return dispatcher;
    }
}