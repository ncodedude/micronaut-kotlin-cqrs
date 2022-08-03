package com.agnaldodd.domain.project.core

data class ProjectDTO(var name: String, var credit: String){
    constructor(project: Project) : this(
        name = project.name,
        credit = project.credit
    )
}
