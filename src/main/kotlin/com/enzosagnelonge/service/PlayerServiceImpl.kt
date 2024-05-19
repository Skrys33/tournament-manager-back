package com.enzosagnelonge.service

import com.enzosagnelonge.model.Player

class PlayerServiceImpl(): PlayerService  {
    override suspend fun getLeaderboard(): List<Player> {
        TODO("Not yet implemented")
    }

    override suspend fun registerPlayer(name: String?) {
        TODO("Not yet implemented")
    }

    override suspend fun resetTournament() {
        TODO("Not yet implemented")
    }

    override suspend fun findPlayerByName(name: String?): Player? {
        TODO("Not yet implemented")
    }

    override suspend fun updatePlayerScore(name: String?, score: Int?) {
        TODO("Not yet implemented")
    }
}