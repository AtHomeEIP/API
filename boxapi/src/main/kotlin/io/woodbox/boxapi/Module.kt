package io.woodbox.boxapi

import com.sun.org.apache.xpath.internal.operations.Mod
import org.jetbrains.exposed.dao.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.SchemaUtils.drop
import org.springframework.stereotype.Component

@Component
object Modules : IntIdTable(){
    //val id = integer("id").autoIncrement().primaryKey()
    val box_id = integer("box_id")
    val name = text("name")
    val type = text("type")
    val vendor = text("vendor")
    val firmware = text("firmware_version")
    val environment_id = integer("environment_id")
    val created_at = datetime("created_at")
    val updated_at = datetime("updated_at")
    val deleted_at = datetime("deleted_at")
    val mac = text("mac_address")
}

class Module(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<Module>(Modules)
    var box_id by Modules.box_id
    var name by Modules.name
    var type by Modules.type
    var vendor by Modules.vendor
    var firmware by Modules.firmware
    var environement_id by Modules.environment_id
    var created_at by Modules.created_at
    var updated_at by Modules.updated_at
    var deleted_at by Modules.deleted_at
    val mac by Modules.mac
}

data class ModuleData(
        var id: String,
        var mac: String,
        var name: String,
        var location: String,
        var type: String,
        var vendor: String
)
