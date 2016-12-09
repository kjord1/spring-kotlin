package com.monsanto.kotlin.api

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * Created by rjordan on 12/8/16.
 */

@Component
@ConfigurationProperties(prefix="application")
class ApplicationConfig {
    var port = 0
}
