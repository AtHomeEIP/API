package io.woodbox.boxapi

import com.coxautodev.graphql.tools.GraphQLResolver
import org.springframework.stereotype.Component

@Component
class ModuleResolver(private val sampleDao: SampleDao) : GraphQLResolver<ModuleData> {
    fun samples(module: ModuleData) = sampleDao.getSamples(module.id.toInt())
}
