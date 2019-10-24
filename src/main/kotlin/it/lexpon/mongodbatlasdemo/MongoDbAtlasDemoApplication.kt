package it.lexpon.mongodbatlasdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MongoDbAtlasDemoApplication

fun main(args: Array<String>) {
    runApplication<MongoDbAtlasDemoApplication>(*args)
}
