package io.woodbox.boxapi

import com.sun.org.apache.xpath.internal.operations.Mod
import org.springframework.stereotype.Component
import java.util.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.dao.*

@Component
class ModuleDao{

    fun getAllModules():List<ModuleData> =
        transaction {
             Module.all().map {

                 ModuleData(
                    it.id.toString(),
                    it.mac,
                    it.name,
                    it.environement_id.toString(),
                    it.type,
                    it.vendor)
            }
        }
}

/*
    fun getModuleById(id: String) = data.firstOrNull { module -> module.id == id }
*/