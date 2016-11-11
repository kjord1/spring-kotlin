package com.monsanto.kotlin.api

import org.everit.json.schema.Schema
import org.everit.json.schema.loader.SchemaLoader
import org.json.JSONObject
import org.json.JSONTokener

class SchemaFactory {
    companion object {
        fun getSchema(schemaName: String): Schema {
            val inputStream = SchemaFactory::class.java.getResourceAsStream("/schemas/${schemaName}.json")
            val rawSchema = JSONObject(JSONTokener(inputStream))
            return SchemaLoader.load(rawSchema)
        }
    }
}
