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

    fun newSample(sampleInput: SampleInput): SampleData {
        var sampleId = ""
        transaction {
            val sample = Sample.new {
                // TODO real date & formatting
                sampledAt   = sampleInput.date
                payload     = sampleInput.payload
                moduleId    = sampleInput.moduleId
            }
            sampleId = sample.id.toString()
        }
        // TODO getSampleByID
        return SampleData(sampleId.toInt(), "", "")
    }
}