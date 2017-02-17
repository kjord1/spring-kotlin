package com.monsanto.kotlin.api

import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.monsanto.kotlin.api.data.Customer
import com.monsanto.kotlin.api.data.CustomerRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@SpringBootApplication
open class Application {

    @Autowired
    private lateinit var appConfig:ApplicationConfig

    private val log = LoggerFactory.getLogger(Application::class.java)

    @Bean
    open fun objectMapperBuilder() : Jackson2ObjectMapperBuilder {
        val builder = Jackson2ObjectMapperBuilder().modulesToInstall(KotlinModule())
        builder.indentOutput(true)
        //builder.dateFormat(SimpleDateFormat("yyyy-MM-dd"))
        //builder.propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
        return builder
    }

    @Bean
    open fun init(repository: CustomerRepository) = CommandLineRunner {
        log.info("App port: ${appConfig.port}")

        // save a couple of customers
        repository.save(Customer("Jack", "Bauer"))
        repository.save(Customer("Chloe", "O'Brian"))
        repository.save(Customer("Kim", "Bauer"))
        repository.save(Customer("David", "Palmer"))
        repository.save(Customer("Michelle", "Dessler"))

        // fetch all customers
        log.info("Customers found with findAll():")
        log.info("-------------------------------")
        repository.findAll().forEach { log.info(it.toString()) }
        log.info("")

        // fetch an individual customer by ID
        val customer = repository.findOne(1L)
        log.info("Customer found with findOne(1L):")
        log.info("--------------------------------")
        log.info(customer.toString())
        log.info("")

        // fetch customers by last name
        log.info("Customer found with findByLastName('Bauer'):")
        log.info("--------------------------------------------")
        repository.findByLastName("Bauer").forEach { log.info(it.toString()) }
        log.info("")
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}