package io.norio.example.examplewebappstructure.foo.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FooApiApplication

fun main(args: Array<String>) {
    runApplication<FooApiApplication>(*args)
}
