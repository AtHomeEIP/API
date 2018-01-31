package io.woodbox.boxapi

import com.sun.org.apache.xpath.internal.operations.Mod
import org.springframework.stereotype.Component
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.SchemaUtils.drop

@Component
class ModuleDao{

    fun getAllModules():List<ModuleData> =
        transaction {
             Module.all().map { ModuleData(
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
@Component
class ModuleDao{
    private val data = mutableListOf(
        Module("1", "a2Eae3aea12a3", "Humidity", "Salon", "H", "WoodBox"),
        Module("2", "ef3faa2ffffff", "Luxmeter", "Chambre", "Lux", "WoodBox"),
        Module("3", "bbcdef123456a", "Sonometer", "Chambre", "dB","WoodBox" ),
        Module("4", "ccdeafç987654", "Gazometer", "Cuisine", "G", "WoodBox"),
        Module("5", "987654321abcd", "Pousierometer", "Salon", "P", "WoodBox")
    )
    fun getModuleById(id: String) = data.firstOrNull { module -> module.id == id }
    fun getAllModules() = data
}
*/