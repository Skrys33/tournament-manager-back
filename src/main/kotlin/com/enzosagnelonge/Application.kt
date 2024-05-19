package com.enzosagnelonge

import com.enzosagnelonge.configuration.configureSerialization
import com.enzosagnelonge.controller.configurePlayerController
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.koin.core.context.startKoin
import org.koin.logger.slf4jLogger
import com.enzosagnelonge.di.Module

fun main(args: Array<String>) {
    embeddedServer(Netty, commandLineEnvironment(args)).start(wait = true)
}

fun Application.module() {
    startKoin {
        slf4jLogger()
        modules(Module().apiModule)
    }

    configureSerialization()
    configurePlayerController()
}
