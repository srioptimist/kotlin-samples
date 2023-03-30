package nl.sri.ksapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KsAppApplication

fun main(args: Array<String>) {
    runApplication<KsAppApplication>(*args)
}
