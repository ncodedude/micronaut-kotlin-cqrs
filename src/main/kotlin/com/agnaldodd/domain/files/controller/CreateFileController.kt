package com.agnaldodd.domain.files.controller

import com.agnaldodd.common.application.ApplicationDispatcherInterface
import com.agnaldodd.domain.files.controller.dto.CreateFileRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/files")
class CreateFileController(
        private val applicationDispatcher: ApplicationDispatcherInterface
) {
    @Post
    fun create(@Body createFileRequest: CreateFileRequest): HttpResponse<Any> {
        val command = createFileRequest.toCommand()
        this.applicationDispatcher.execute(command)
        return HttpResponse.ok()
    }
}