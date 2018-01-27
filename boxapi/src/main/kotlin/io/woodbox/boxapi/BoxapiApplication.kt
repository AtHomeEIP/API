package io.woodbox.boxapi

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.SchemaUtils.drop

@SpringBootApplication
class BoxapiApplication

object Users : Table() {
    val id = varchar("id", 10).primaryKey() // Column<String>
    val name = varchar("name", length = 50) // Column<String>
    val cityId = (integer("city_id") references Cities.id).nullable() // Column<Int?>
}

object Cities : Table() {
    val id = integer("id").autoIncrement().primaryKey() // Column<Int>
    val name = varchar("name", 50) // Column<String>
}

fun main(args: Array<String>) {
    var db = Database.connect(
        "jdbc:postgresql://woodbox.io:5432/"
        , driver = "org.h2.Driver"
        , user = "boxapi"
        , password = "cheeki42breeki"
    )

    transaction {
        create(Cities, Users)

        val saintPetersburgId = Cities.insert {
            it[name] = "St. Petersburg"
        } get Cities.id

        val munichId = Cities.insert {
            it[name] = "Munich"
        } get Cities.id

        Cities.insert {
            it[name] = "Prague"
        }

        Users.insert {
            it[id] = "andrey"
            it[name] = "Andrey"
            it[cityId] = saintPetersburgId
        }

        Users.insert {
            it[id] = "sergey"
            it[name] = "Sergey"
            it[cityId] = munichId
        }

        Users.insert {
            it[id] = "eugene"
            it[name] = "Eugene"
            it[cityId] = munichId
        }

        Users.insert {
            it[id] = "alex"
            it[name] = "Alex"
            it[cityId] = null
        }

        Users.insert {
            it[id] = "smth"
            it[name] = "Something"
            it[cityId] = null
        }
    }

        SpringApplication.run(BoxapiApplication::class.java, *args)
}
