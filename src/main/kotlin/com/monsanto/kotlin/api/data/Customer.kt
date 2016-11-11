package com.monsanto.kotlin.api.data

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Customer(
        @JsonProperty(required = true, value = "first_name")
        var firstName: String = "",
        @JsonProperty(required = true, value = "last_name")
        var lastName: String = "",
        @Id @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
        var id: Long = 0
)