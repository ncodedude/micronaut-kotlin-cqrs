package com.agnaldodd.domain.files.application.command

import com.agnaldodd.common.application.command.ApplicationCommand
import com.agnaldodd.domain.files.core.File

class CreateFileCommand(private val name: String): ApplicationCommand<File> {
    fun getFile(): File {
        return File(name = name)
    }
}