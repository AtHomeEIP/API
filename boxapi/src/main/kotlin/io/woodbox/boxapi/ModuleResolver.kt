package io.woodbox.boxapi

import com.coxautodev.graphql.tools.GraphQLResolver
import org.springframework.stereotype.Component

@Component
class ModuleResolver(private val sampleDao: SampleDao, private val thresholdDao: ThresholdDao) : GraphQLResolver<ModuleData> {
    fun samples(module: ModuleData) = sampleDao.getSamples(module.id.toInt())
    fun thresholds(module: ModuleData) = thresholdDao.getThresholds(module.id.toInt())
}
