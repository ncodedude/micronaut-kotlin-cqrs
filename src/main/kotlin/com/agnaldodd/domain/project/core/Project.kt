package com.agnaldodd.domain.project.core

import javax.persistence.*

@Entity
@Table(name = "project")
data class Project(
    @Id
    @GeneratedValue
    val id: Long = 0,
    @Column(name = "name")
    val name: String = "",
    @Column(name = "credit")
    val credit: String = "",
)