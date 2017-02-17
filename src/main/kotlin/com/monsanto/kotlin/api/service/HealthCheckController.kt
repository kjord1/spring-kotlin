package com.monsanto.kotlin.api.service

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.naming.ServiceUnavailableException

data class StatusResponse(val backend1Status: String, val backend2Status: Boolean)

@RestController
@ControllerAdvice
class HealthCheckController {
    @RequestMapping("/health")
    @ResponseStatus(HttpStatus.OK)
    fun checkHealth() : Int = 1

    @RequestMapping("/healthcheck")
    fun healthCheck() : StatusResponse {
        return StatusResponse("disconnected", true)
    }

//    @RequestMapping("/healthcheck")
//    fun healthCheck() : Map<String, Any> {
//        throw ServiceUnavailableException()
////        return mapOf(
////                Pair("webapp", true),
////                Pair("rabbitmq","connected")
////        )
//    }
}