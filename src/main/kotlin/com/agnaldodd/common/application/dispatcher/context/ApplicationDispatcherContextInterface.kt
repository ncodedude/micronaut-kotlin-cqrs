package com.agnaldodd.common.application.dispatcher.context

import com.agnaldodd.common.application.command.ApplicationCommand
import com.agnaldodd.common.application.event.ApplicationEvent
import com.agnaldodd.common.application.query.ApplicationQuery

interface ApplicationDispatcherContextInterface {
    fun <R> execute(command: ApplicationCommand<R>?): Boolean
    fun <R> execute(query: ApplicationQuery<R>?): Any
    fun <R> execute(event: ApplicationEvent<R>?): Boolean
}