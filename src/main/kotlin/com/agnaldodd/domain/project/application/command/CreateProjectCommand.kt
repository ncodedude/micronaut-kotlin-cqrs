package com.agnaldodd.domain.project.application.command

import com.agnaldodd.common.application.command.ApplicationCommand
import com.agnaldodd.domain.project.core.Project

class CreateProjectCommand(private val name: String, private val credit: String): ApplicationCommand<Project> {
    fun getProject(): Project {
        return Project(name = name, credit = credit)
    }
}