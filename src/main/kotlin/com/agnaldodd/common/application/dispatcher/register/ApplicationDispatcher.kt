@file:Suppress("UNCHECKED_CAST")

package com.agnaldodd.common.application.dispatcher.register

import com.agnaldodd.common.application.command.ApplicationCommand
import com.agnaldodd.common.application.command.ApplicationCommandHandler
import com.agnaldodd.common.application.event.ApplicationEvent
import com.agnaldodd.common.application.query.ApplicationQuery
import com.agnaldodd.common.application.query.ApplicationQueryResolver
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ApplicationDispatcher() : ApplicationDispatcherInterface {

     private val LOG: Logger = LoggerFactory.getLogger(ApplicationDispatcher::class.java)
     private val handlers: HashMap<String, ApplicationCommandHandler<*, *>> = HashMap()
     private val resolvers: HashMap<String, ApplicationQueryResolver<*, *>> = HashMap()

    override fun <R> execute(command: ApplicationCommand<R>?): Boolean {

        LOG.debug("handle command: " + command!!.getCommandName())
        val handler: ApplicationCommandHandler<ApplicationCommand<R>, R> =
            handlers[command.getCommandName()] as ApplicationCommandHandler<ApplicationCommand<R>, R>
        return handler.handleCommand(command) as Boolean
    }

    override fun <R> execute(query: ApplicationQuery<R>?): Any {
        LOG.debug("handle query: " + query!!.getQueryName())
        val resolver: ApplicationQueryResolver<ApplicationQuery<R>, R> =
            resolvers[query.getQueryName()] as ApplicationQueryResolver<ApplicationQuery<R>, R>
        return resolver.resolveQuery(query) as Any
    }

    override fun <R> execute(event: ApplicationEvent<R>?): Boolean {
        TODO("Not yet implemented")
    }

    override fun <R> registerQueryResolver(queryName: String, resolver: ApplicationQueryResolver<ApplicationQuery<R>, R> ) {
        resolvers[queryName] = resolver
    }

    override fun <R> registerHandlerCommand(commandName: String, handler: ApplicationCommandHandler<ApplicationCommand<R>, R>) {
        handlers[commandName] = handler
    }
}