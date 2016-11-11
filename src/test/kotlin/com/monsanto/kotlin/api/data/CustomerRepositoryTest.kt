package com.monsanto.kotlin.api.data

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    lateinit var repository: CustomerRepository

    @Test
    fun findOne() {
        val customer = Customer("Test", "Me")
        repository.save(customer)
        val result = repository.findOne(customer.id)
        assert(result.lastName == customer.lastName)
    }
}