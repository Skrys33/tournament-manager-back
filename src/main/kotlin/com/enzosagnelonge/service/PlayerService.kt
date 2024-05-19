package com.enzosagnelonge.service

import com.enzosagnelonge.model.Player
import org.koin.core.annotation.Singleton

@Singleton
interface PlayerService {
    suspend fun getLeaderboard(): List<Player>
    suspend fun registerPlayer(name: String?)
    suspend fun resetTournament()
    suspend fun findPlayerByName(name: String?): Player
    suspend fun updatePlayerScore(name: String?, score: Int?)
}