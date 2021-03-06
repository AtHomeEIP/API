package io.woodbox.boxapi

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class Query(private val moduleDao: ModuleDao, private val sampleDao: SampleDao) : GraphQLQueryResolver {
    fun allModules() = moduleDao.getAllModules()
    fun getModuleById(id: String) = moduleDao.getModuleById(id)
}
