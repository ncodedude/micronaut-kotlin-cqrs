package com.agnaldodd.common.application.query

interface ApplicationQueryResolver<C : ApplicationQuery<R>, R> {
    fun resolveQuery(query: ApplicationQuery<R>?): Any?
}