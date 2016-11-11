package com.monsanto.kotlin.api.service

import com.monsanto.kotlin.api.data.Customer
import com.monsanto.kotlin.api.data.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController @Autowired constructor(val repository: CustomerRepository) {

//    @Autowired
//    lateinit var repository: CustomerRepository

    @RequestMapping("/customers")
    fun findAll() : Iterable<Customer> = repository.findAll()

    @RequestMapping("/customers/{id}")
    fun find(@PathVariable id:Long) : Customer = repository.findOne(id)
}