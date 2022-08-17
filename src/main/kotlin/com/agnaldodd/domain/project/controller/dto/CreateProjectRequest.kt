package com.agnaldodd.domain.project.controller.dto

import com.agnaldodd.domain.project.application.command.CreateProjectCommand
import io.micronaut.core.annotation.Introspected

@Introspected
data class CreateProjectRequest(
    val name: String,
    val credit: String
){
    fun toCommand(): CreateProjectCommand {
        return CreateProjectCommand(name, credit);
    }
}