package io.woodbox.boxapi

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class Mutation (private val moduleDao: ModuleDao): GraphQLMutationResolver
{
    fun newModule(moduleInput: ModuleInput) = moduleDao.setNewModule(moduleInput)
    fun updateModule(id: String, name: String?, location: String?, firmware: String?) = moduleDao.updateModule(id, name, location, firmware)
}