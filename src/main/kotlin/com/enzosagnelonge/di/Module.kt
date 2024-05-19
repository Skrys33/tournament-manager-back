package com.enzosagnelonge.di

import com.enzosagnelonge.configuration.Mongo
import com.enzosagnelonge.repository.PlayerRepository
import com.enzosagnelonge.repository.PlayerRepositoryImpl
import com.enzosagnelonge.service.PlayerService
import com.enzosagnelonge.service.PlayerServiceImpl
import com.typesafe.config.ConfigFactory
import io.ktor.server.config.*
import org.koin.dsl.module

class Module {
    private val applicationConfig = HoconApplicationConfig(ConfigFactory.load())
    private val mongoUri = applicationConfig.property("ktor.mongo.uri").getString()

    val apiModule = module {
        single { Mongo(mongoUri) }
        single <PlayerRepository>{ PlayerRepositoryImpl(get()) }
        single <PlayerService>{ PlayerServiceImpl(get()) }
    }
}