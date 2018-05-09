package io.woodbox.boxapi

import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Component


@Component
class SampleDao{
    fun getSamples(moduleId : Int, limit: Int, offset: Int) =
            transaction {

                Sample.find { Samples.module_id eq moduleId }.limit(limit, offset).map { SampleData(
                        it.moduleId,
                        it.payload,
                        it.sampledAt
                ) }
            }

    fun newSample(sampleInput: SampleInput): SampleData {
        transaction {
            Sample.new {
                // TODO real date & formatting
                sampledAt   = sampleInput.date
                payload     = sampleInput.payload
                moduleId    = sampleInput.moduleId
            }
        }
        return SampleData (
            sampleInput.moduleId,
            sampleInput.payload,
            sampleInput.date
        )
    }
}