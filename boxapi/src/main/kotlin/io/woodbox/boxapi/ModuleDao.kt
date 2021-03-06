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
    fun whichRoom(environmentId: Int):String{
        when(environmentId){
            1 -> return "Salon"
            2 -> return "Chambre"
            3 -> return "Cuisine"
            else -> return "Undefined room"
        }
    }

    fun getAllModules():List<ModuleData> =
        transaction {
             Module.all().map {

                 ModuleData(
                    it.id.toString(),
                    it.mac,
                    it.name,
                    whichRoom(it.environement_id),
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
                res.location = whichRoom(it.environement_id)
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

     fun updateModule(id: String, name:String?, location: String?, firmware: String?, thresholds: List<ThresholdInput>?): ModuleData{
        transaction {
            Module.find { Modules.id eq id.toInt() }.forEach {
                if(name != null)
                    it.name = name
                if(location != null)
                    it.environement_id = location.toInt()
                if(firmware != null)
                    it.firmware = firmware
                if(thresholds != null && thresholds.any()){
                    updateThreshold(id.toInt(),thresholds)
                }
            }
        }
        return (getModuleById(id))
    }

    fun updateThreshold(moduleId: Int, thresholds: List<ThresholdInput>){
        transaction {
            Threshold.find { Thresholds.module_id eq moduleId }.forEach {
                it.delete()
            }

            thresholds.forEach { threshold ->
                Threshold.new {
                    this.moduleId = threshold.moduleId
                    this.name = threshold.name
                    this.default = threshold.default
                    this.min = threshold.min
                    this.max = threshold.max
                    this.current = threshold.current
                }
            }
        }
    }

    fun deleteModule(id: String):String {
        transaction {
            Module.find { Modules.id eq id.toInt() }.forEach {
                it.delete()
            }
        }
        return ("Your module are delete !")
    }
}

/*
    fun getModuleById(id: String) = data.firstOrNull { module -> module.id == id }
*/