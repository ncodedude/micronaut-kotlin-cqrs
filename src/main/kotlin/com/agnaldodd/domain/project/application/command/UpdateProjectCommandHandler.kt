package com.agnaldodd.domain.project.application.command

import com.agnaldodd.common.application.command.AbstractCommandHandler
import com.agnaldodd.common.application.command.ApplicationCommand
import com.agnaldodd.domain.project.core.Project
import com.agnaldodd.domain.project.infrastructure.persistence.ProjectSQLRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UpdateProjectCommandHandler:AbstractCommandHandler<Project>() {
    @Inject
    lateinit var repository: ProjectSQLRepository

    override fun handleCommand(command: ApplicationCommand<Project>?): Boolean {
        val receivedCommand = command as UpdateProjectCommand
        repository.update(receivedCommand.project )
        return true
    }
}