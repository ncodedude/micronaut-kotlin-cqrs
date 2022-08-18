package com.agnaldodd.domain.files.controller.dto

import com.agnaldodd.domain.files.application.command.CreateFileCommand
import io.micronaut.core.annotation.Introspected

@Introspected
data class CreateFileRequest(val name: String) {
    fun toCommand(): CreateFileCommand {
        return CreateFileCommand(name)
    }
}
