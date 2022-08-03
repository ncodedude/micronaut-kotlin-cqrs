package com.agnaldodd.common.exceptions

class DomainException : RuntimeException {
    val type: String

    constructor(message: String?) : super(message) {
        type = "unknown"
    }

    constructor(message: String?, type: String) : super(message) {
        this.type = type
    }

    constructor(message: String?, cause: Throwable?) : super(message, cause) {
        type = "unknown"
    }

    constructor(cause: Throwable?) : super(cause) {
        type = "unknown"
    }
}