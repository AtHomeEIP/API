package io.woodbox.boxapi

import org.springframework.stereotype.Component
import org.jetbrains.exposed.dao.*

@Component
object Samples: IntIdTable(){
    val module_id = integer("module_id")
    val payload = text("payload")
    val sampled_at = datetime("sampled_at")
}

class Sample(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<Sample>(Samples)
    var moduleId by Samples.module_id
    var payload by Samples.payload
    var sampledAt by Samples.sampled_at
}

data class SampleData(
    val moduleId: Int,
    val payload: String,
    val date: String
)


