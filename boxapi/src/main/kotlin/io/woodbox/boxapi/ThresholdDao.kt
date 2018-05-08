package io.woodbox.boxapi

import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Component

@Component
class ThresholdDao {
    fun getThresholds(moduleId : Int) =
            transaction {
                Threshold.find { Thresholds.module_id eq moduleId }.map { ThresholdData(
                    it.moduleId,
                    it.name,
                    it.default,
                    it.min,
                    it.max,
                    it.current
                )
                }
            }

    fun newThresholds(thresholds: List<ThresholdInput> ) : List<ThresholdData> {
        transaction {
            Threshold.find { Thresholds.module_id eq thresholds[0].moduleId }.forEach {
              it.delete()
             }
            thresholds.forEach { threshold ->
                Threshold.new {
                    this.moduleId = threshold.moduleId
                    this.name = threshold.name
                    this.default = threshold.default
                    this.min = threshold.min
                    this.max = threshold.max
                    this.current = threshold.current
                }
            }
        }
        return getThresholds(thresholds[0].moduleId)
    }
}


