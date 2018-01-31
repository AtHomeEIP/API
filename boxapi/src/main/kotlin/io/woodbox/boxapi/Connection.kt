package io.woodbox.boxapi

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.dao.*



object Connection{
    var db = Database.connect(
            "jdbc:postgresql://woodbox.io:5432/",
            driver = "org.h2.Driver",
            user = "boxapi",
            password = "cheeki42breeki"
    )
}
