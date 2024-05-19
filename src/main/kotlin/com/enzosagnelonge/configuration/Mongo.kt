package com.enzosagnelonge.configuration

import com.mongodb.kotlin.client.coroutine.MongoClient
import org.koin.core.annotation.Singleton

@Singleton
class Mongo(connectionString: String) {
    val client = MongoClient.create(connectionString)
}