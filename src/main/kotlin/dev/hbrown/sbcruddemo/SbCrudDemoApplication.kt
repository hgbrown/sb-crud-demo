package dev.hbrown.sbcruddemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SbCrudDemoApplication

fun main(args: Array<String>) {
    runApplication<SbCrudDemoApplication>(*args)
}
