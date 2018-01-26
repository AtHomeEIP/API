package io.woodbox.boxapi

import org.springframework.stereotype.Component
import java.util.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.dao.*

//object Modules : Table(){
//}


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