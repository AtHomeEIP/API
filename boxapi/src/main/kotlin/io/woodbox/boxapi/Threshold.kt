package io.woodbox.boxapi

import org.springframework.stereotype.Component
import org.jetbrains.exposed.dao.*

@Component
object Thresholds: IntIdTable(){
    val module_id = integer("module_id")
    val name = text("name")
    val default= integer("default")
    val min = integer("min")
    val max = integer("max")
    val current = integer("current")
}

class Threshold(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<Sample>(Samples)
    var moduleId by Thresholds.module_id
    var name by Thresholds.name
    var default by Thresholds.default
    var min by Thresholds.min
    var max by Thresholds.max
    var current by Thresholds.current
}

data class ThresholdData(
        var moduleId: Int,
        var name: String,
        var default: Int,
        var min: Int,
        var max: Int,
        var current: Int
)

data class ThresholdInput(
        var moduleId: Int,
        var name: String,
        var default: Int,
        var min: Int,
        var max: Int,
        var current: Int
)


