package com.agnaldodd.common.application.dispatcher.register

import com.agnaldodd.common.application.command.ApplicationCommand
import com.agnaldodd.common.application.command.ApplicationCommandHandler
import com.agnaldodd.common.application.event.ApplicationEvent
import com.agnaldodd.common.application.query.ApplicationQuery
import com.agnaldodd.common.application.query.ApplicationQueryResolver

interface ApplicationDispatcherInterface {
    fun <R> registerQueryResolver(queryName: String, resolver: ApplicationQueryResolver<ApplicationQuery<R>, R>)
    fun <R> registerHandlerCommand(commandName: String, handler: ApplicationCommandHandler<ApplicationCommand<R>, R>)
    fun <R> execute(command: ApplicationCommand<R>?): Boolean
    fun <R> execute(query: ApplicationQuery<R>?): Any
    fun <R> execute(event: ApplicationEvent<R>?): Boolean
}