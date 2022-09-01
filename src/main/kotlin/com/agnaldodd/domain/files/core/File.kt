package com.agnaldodd.domain.files.core

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "file")
data class File (
    @Id
    @GeneratedValue
    val id: Long = 0,
    @Column(name = "name")
    val name: String = ""
)