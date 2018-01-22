package io.woodbox.boxapi

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class Query(private val moduleDao: ModuleDao ) : GraphQLQueryResolver {
    fun allModules() = moduleDao.getAllModules()
}
