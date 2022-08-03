package com.agnaldodd.common.application.command

interface ApplicationCommand<T> {
    fun getCommandName(): String {
        return this.javaClass.simpleName
    }
}
