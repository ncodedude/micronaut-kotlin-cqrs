package com.agnaldodd.common.application.command

interface ApplicationCommandHandler<C : ApplicationCommand<R>, R> {
    fun handleCommand(command: ApplicationCommand<R>?): Boolean?
}