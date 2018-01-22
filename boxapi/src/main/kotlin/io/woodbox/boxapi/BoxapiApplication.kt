package io.woodbox.boxapi

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class BoxapiApplication

fun main(args: Array<String>) {
    SpringApplication.run(BoxapiApplication::class.java, *args)
}
