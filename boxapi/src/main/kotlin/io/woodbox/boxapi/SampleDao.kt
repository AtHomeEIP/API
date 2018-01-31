package io.woodbox.boxapi

import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.*
import org.springframework.stereotype.Component


@Component
class SampleDao{
    fun getSamples(moduleId : Int) =
            transaction {
                Sample.find { Samples.module_id eq moduleId }.map { SampleData(
                        it.moduleId,
                        it.payload,
                        it.sampledAt
                )}
            }
}