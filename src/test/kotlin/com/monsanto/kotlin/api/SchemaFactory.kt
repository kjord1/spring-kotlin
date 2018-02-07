package com.monsanto.kotlin.api

import com.networknt.schema.JsonSchema
import com.networknt.schema.JsonSchemaFactory

class SchemaFactory {
    companion object {
        fun getSchema(schemaName: String): JsonSchema {
            val inputStream = SchemaFactory::class.java.getResourceAsStream("/schemas/${schemaName}.json")
            val factory = JsonSchemaFactory()
            return factory.getSchema(inputStream)
        }
    }
}
