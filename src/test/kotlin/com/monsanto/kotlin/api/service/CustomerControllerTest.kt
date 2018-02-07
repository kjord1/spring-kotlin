package com.monsanto.kotlin.api.service

import com.monsanto.kotlin.api.SchemaFactory
import com.monsanto.kotlin.api.data.Customer
import com.monsanto.kotlin.api.data.CustomerRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.context.WebApplicationContext
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.json.JSONObject
import com.fasterxml.jackson.databind.ObjectMapper



@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest
class CustomerControllerTest {

    lateinit var springMvc: MockMvc

    @Autowired
    lateinit var controller: CustomerController

    @Autowired
    lateinit var repository: CustomerRepository

    @Autowired
    var wContext: WebApplicationContext? = null

    @Before
    @Throws(Exception::class)
    fun init() {
        springMvc = MockMvcBuilders.webAppContextSetup(wContext!!).build()
    }

    @Test
    fun findAll() {
        controller.findAll()
    }

    @Test
    fun find() {
        val customer = Customer("Testme", "John")
        repository.save(customer)

        val result = springMvc.perform(MockMvcRequestBuilders
                .get("/customers/${customer.id}").accept(MediaType.APPLICATION_JSON)).andReturn()
        val content = result.response.contentAsString
        val mapper = ObjectMapper()
        val node = mapper.readTree(content)
        SchemaFactory.getSchema("customer").validate(node)
    }
}