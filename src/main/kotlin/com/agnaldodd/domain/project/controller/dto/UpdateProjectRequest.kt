package com.agnaldodd.domain.project.controller.dto

import com.agnaldodd.domain.project.application.command.UpdateProjectCommand
import com.agnaldodd.domain.project.core.Project

data class UpdateProjectRequest(
        private val name: String,
        private val credit: String
){
    fun toCommand(id:Long): UpdateProjectCommand {
        val project = Project(id = id ,name = this.name, credit = this.credit)
        return UpdateProjectCommand(id,project)
    }
}