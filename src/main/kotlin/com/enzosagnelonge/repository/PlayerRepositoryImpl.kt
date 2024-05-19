package com.enzosagnelonge.repository

import com.enzosagnelonge.model.Player

class PlayerRepositoryImpl: PlayerRepository {
    override suspend fun getLeaderboard(): List<Player> {
        TODO("Not yet implemented")
    }

    override suspend fun registerPlayer(player: Player) {
        TODO("Not yet implemented")
    }

    override suspend fun resetTournament() {
        TODO("Not yet implemented")
    }

    override suspend fun findPlayerByName(name: String): Player {
        TODO("Not yet implemented")
    }

    override suspend fun updatePlayerScore(name: String, score: Int) {
        TODO("Not yet implemented")
    }
}