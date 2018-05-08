package io.woodbox.boxapi

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class Mutation (private val moduleDao: ModuleDao, private val sampleDao: SampleDao): GraphQLMutationResolver
{
    fun newModule(moduleInput: ModuleInput) = moduleDao.setNewModule(moduleInput)
    fun newSample(sampleInput: SampleInput) = sampleDao.newSample(sampleInput)
    fun updateModule(id: String, name: String?, location: String?, firmware: String?, thresholds: List<ThresholdInput>?) = moduleDao.updateModule(id, name, location, firmware, thresholds)
    fun deleteModule(id: String) = moduleDao.deleteModule(id)
}