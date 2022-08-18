package com.agnaldodd.domain.project.application.command

import com.agnaldodd.common.application.command.ApplicationCommand
import com.agnaldodd.domain.project.controller.dto.UpdateProjectRequest
import com.agnaldodd.domain.project.core.Project

class UpdateProjectCommand(val id:Long,val project:Project): ApplicationCommand<Project> {

}