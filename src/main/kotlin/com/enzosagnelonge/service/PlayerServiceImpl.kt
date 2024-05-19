package com.enzosagnelonge.service

import com.enzosagnelonge.model.Player
import com.enzosagnelonge.repository.PlayerRepository
import java.lang.RuntimeException

class PlayerServiceImpl(private val repository: PlayerRepository): PlayerService  {
    override suspend fun getLeaderboard(): List<Player> {
        return repository.getLeaderboard()
    }

    override suspend fun resetTournament() {
        repository.resetTournament()
    }

    override suspend fun registerPlayer(name: String?) {
        val sanitizedName = playerNameValidation(name)
        val player = repository.findPlayerByName(sanitizedName)

        if (player != null) throw RuntimeException("Player '$name' already exist.")
        repository.registerPlayer(sanitizedName)
    }

    override suspend fun findPlayerByName(name: String?): Player {
        val sanitizedName = playerNameValidation(name)
        val player = repository.findPlayerByName(sanitizedName)

        if (player == null) throw RuntimeException("Player '$name' not found.")

        return player
    }

    override suspend fun updatePlayerScore(name: String?, score: Int?) {
        if (score == null) throw RuntimeException("Player score can't be null.")
        val sanitizedName = playerNameValidation(name)
        val count = repository.updatePlayerScore(sanitizedName, score)

        if (count < 1) throw RuntimeException("Player '$name' not found.")
    }

    private fun playerNameValidation(name: String?): String {
        if (name == null) throw RuntimeException("Player name can't be null.")
        val sanitizedName = sanitizeName(name)

        if (sanitizedName == "") throw RuntimeException("Player name can't be ''.")

        return sanitizedName
    }
    private fun sanitizeName(name: String): String{
        return name.trim().lowercase()
    }
}