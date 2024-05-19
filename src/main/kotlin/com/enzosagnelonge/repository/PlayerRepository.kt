package com.enzosagnelonge.repository

import com.enzosagnelonge.model.Player
import org.bson.BsonValue
import org.koin.core.annotation.Singleton

@Singleton
interface PlayerRepository {
    suspend fun getLeaderboard(): List<Player>
    suspend fun registerPlayer(name: String): BsonValue?
    suspend fun resetTournamentPlayers(): Long
    suspend fun findPlayerByName(name: String): Player?
    suspend fun updatePlayerScore(name: String, score: Int): Long
}