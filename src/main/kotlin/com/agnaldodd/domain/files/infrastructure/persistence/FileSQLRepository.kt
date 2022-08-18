package com.agnaldodd.domain.files.infrastructure.persistence

import com.agnaldodd.domain.files.core.File
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface FileSQLRepository: CrudRepository<File, Long> {}