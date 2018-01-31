package io.woodbox.boxapi

import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.*
import org.springframework.stereotype.Component


@Component
class SampleDao{
    fun getSamples() =
            transaction {
                Sample.all().map { SampleData(
                        it.moduleId,
                        it.payload,
                        it.sampledAt.toString()
                )}
            }
//    fun getSamplesByModuleId(moduleId: Int) = data.filter{sample -> sample.moduleId == moduleId }
}