package com.agnaldodd.common.application.query

interface ApplicationQuery<T> {
    fun getQueryName(): String {
        return this.javaClass.simpleName
    }
}
