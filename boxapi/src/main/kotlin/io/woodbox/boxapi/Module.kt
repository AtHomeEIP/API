package io.woodbox.boxapi

import org.jetbrains.exposed.sql.*

data class Module(
        val id: String,
        val mac: String,
        val name: String,
        val location: String,
        val type: String,
        val vendor: String
)
