package com.agnaldodd.domain.redirect.controller

import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import java.net.URI


@Controller("/")
class RedirectController {
    @Get("/{hash}")
    fun redirect(@PathVariable hash: String): MutableHttpResponse<Any>? {
        val location:URI = URI.create("https://www.google.com.br")
        return HttpResponse.redirect<Any>(location)
    }
}