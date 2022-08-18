package com.agnaldodd.domain.files.application.command

import com.agnaldodd.common.application.command.AbstractCommandHandler
import com.agnaldodd.common.application.command.ApplicationCommand
import com.agnaldodd.domain.files.core.File
import com.agnaldodd.domain.files.infrastructure.persistence.FileSQLRepository
import com.agnaldodd.domain.project.core.Project
import javax.inject.Inject

class CreateFileCommandHandler: AbstractCommandHandler<File>() {

    @Inject
    lateinit var repository: FileSQLRepository

    override fun handleCommand(command: ApplicationCommand<File>?): Boolean {
        val file: File = (command as CreateFileCommand).getFile()
        this.repository.apply { save(file) }
        return true
    }
}