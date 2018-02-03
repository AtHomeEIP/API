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
    fun getModuleById(id: String): ModuleData {
        val res = ModuleData("","","","","","")
        transaction {
            Module.find { Modules.id eq id.toInt()}.forEach {
                res.id = it.id.toString()
                res.mac = it.mac
                res.name = it.name
                res.location = it.environement_id.toString()
                res.type = it.type
                res.vendor = it.vendor
            }
        }
        return res
    }

    fun setNewModule(moduleInput: ModuleInput): ModuleData{
        //Todo : verifier si le module existe deja
        var moduleId = ""
        transaction {
                val module = Module.new {
                    box_id = moduleInput.boxId.toInt()
                    mac = moduleInput.mac
                    name = moduleInput.name
                    environement_id = moduleInput.location.toInt()
                    type = moduleInput.type
                    vendor = moduleInput.vendor
                    firmware = moduleInput.firmware
                    created_at = ""
                    updated_at= ""
            }
            moduleId = module.id.toString()
        }
        return getModuleById(moduleId)
    }

    fun updateModule(id: String, name:String?, location: String?, firmware: String?): ModuleData{
        transaction {
            Module.find { Modules.id eq id.toInt() }.forEach {
                if(name != null)
                    it.name = name
                if(location != null)
                    it.environement_id = location.toInt()
                if(firmware != null)
                    it.firmware = firmware
            }
        }
        return (getModuleById(id))
    }
}


/*
    fun getModuleById(id: String) = data.firstOrNull { module -> module.id == id }
*/