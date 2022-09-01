package com.agnaldodd.common.application.dispatcher.context

import com.agnaldodd.common.application.command.AbstractCommandHandler
import com.agnaldodd.common.application.command.ApplicationCommand
import com.agnaldodd.common.application.command.ApplicationCommandHandler
import com.agnaldodd.common.application.event.ApplicationEvent
import com.agnaldodd.common.application.query.AbstractQueryResolver
import com.agnaldodd.common.application.query.ApplicationQuery
import com.agnaldodd.common.application.query.ApplicationQueryResolver
import io.micronaut.context.ApplicationContext
import io.micronaut.inject.qualifiers.Qualifiers
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ApplicationDispatcherContext(private val context: ApplicationContext): ApplicationDispatcherContextInterface {
    private val LOG: Logger = LoggerFactory.getLogger(ApplicationDispatcherContext::class.java)

    override fun <R> execute(command: ApplicationCommand<R>?): Boolean {
        LOG.debug("handle command: " + command!!.getCommandName())
        val handler = this.context.getBean(AbstractCommandHandler::class.java, Qualifiers.byName(command!!.getCommandName().plus("Handler"))) as ApplicationCommandHandler<ApplicationCommand<R>, R>
        return handler.handleCommand(command) as Boolean
    }

    override fun <R> execute(query: ApplicationQuery<R>?): Any {
        LOG.debug("handle query: " + query!!.getQueryName())
        val resolver = this.context.getBean(AbstractQueryResolver::class.java, Qualifiers.byName(query!!.getQueryName().plus("Resolver"))) as ApplicationQueryResolver<ApplicationQuery<R>, R>
        return resolver.resolveQuery(query) as Any
    }

    override fun <R> execute(event: ApplicationEvent<R>?): Boolean {
        TODO("Not yet implemented")
    }
}