package com.monsanto.kotlin.api.service

import com.monsanto.kotlin.api.service.HealthCheckController
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest
class HealthCheckControllerTest {
    @Autowired
    lateinit var controller: HealthCheckController

    @Test
    fun findAll() {
        assert(1 == controller.checkHealth())
    }
}