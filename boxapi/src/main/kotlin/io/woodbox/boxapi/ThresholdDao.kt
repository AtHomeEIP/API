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
}


