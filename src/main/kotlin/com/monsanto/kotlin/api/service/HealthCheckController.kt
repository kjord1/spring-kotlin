package com.monsanto.kotlin.api.service

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {
    @RequestMapping("/healthcheck")
    @ResponseStatus(HttpStatus.OK)
    fun checkHealth() : Int = 1
}