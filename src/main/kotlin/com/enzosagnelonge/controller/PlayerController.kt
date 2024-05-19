package com.enzosagnelonge.controller

import com.enzosagnelonge.model.Player
import com.enzosagnelonge.service.PlayerService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configurePlayerController() {
    val service by inject<PlayerService>()

    routing {
        get("/leaderboard") {
            call.respond(HttpStatusCode.OK, service.getLeaderboard())
        }

        get("/players/{name}") {
            val name = call.parameters[Player::name.name]
            val player = service.findPlayerByName(name)

            try {
                call.respond(HttpStatusCode.OK, player)
            } catch (e: RuntimeException) {
                call.respond(HttpStatusCode.BadRequest, e.message.toString())
            }
        }

        post("/players") {
            val params = call.receiveParameters()
            val name = params[Player::name.name]

            try {
                service.registerPlayer(name)
                call.respond(HttpStatusCode.Created, "Player has registered correctly.")
            } catch (e: RuntimeException) {
                call.respond(HttpStatusCode.BadRequest, e.message.toString())
            }
        }

        patch ("/players") {
            val params = call.receiveParameters()
            val name = params[Player::name.name]
            val score = params[Player::score.name]?.toInt()

            try {
                service.updatePlayerScore(name, score)
                call.respond(HttpStatusCode.OK, "Player's score has been updated correctly.")
            } catch (e: RuntimeException) {
                call.respond(HttpStatusCode.BadRequest, e.message.toString())
            }
        }

        delete("/players") {
            service.resetTournamentPlayers()
            call.respond(HttpStatusCode.OK, "Tournament players list reinitialized.")
        }
    }

}