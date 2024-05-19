package com.enzosagnelonge.repository

import com.enzosagnelonge.configuration.Mongo
import com.enzosagnelonge.model.Player
import com.mongodb.client.model.Filters
import com.mongodb.client.model.Sorts
import com.mongodb.client.model.Updates
import com.mongodb.kotlin.client.coroutine.MongoCollection
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.toList
import org.bson.BsonDocument
import org.bson.BsonValue

class PlayerRepositoryImpl(mongo: Mongo): PlayerRepository {
    private val database: MongoDatabase = mongo.client.getDatabase("TournamentManager")
    private val collection by lazy { selectRepositoryCollection() }
    private fun selectRepositoryCollection(): MongoCollection<Player> = database.getCollection("players")

    suspend fun <RETURN> withCollection(block: suspend MongoCollection<Player>.() -> RETURN): RETURN {
        return collection.block()
    }

    override suspend fun getLeaderboard(): List<Player> = withCollection {
        val players = find().sort(Sorts.descending(Player::score.name)).toList()
        var rank = 0
        var lastScore: Int = -1
        players.forEachIndexed { index, player ->
            run {
                if (player.score != lastScore) {
                    rank = index + 1
                    lastScore = player.score
                }
                player.rank = rank
            }
        }

        players
    }

    override suspend fun registerPlayer(name: String): BsonValue?  = withCollection {
        insertOne(Player(name)).insertedId
    }

    override suspend fun resetTournamentPlayers(): Long = withCollection {
        deleteMany(BsonDocument()).deletedCount
    }

    override suspend fun findPlayerByName(name: String): Player? {
        return getLeaderboard().find { player ->  player.name == name }
    }

    override suspend fun updatePlayerScore(name: String, score: Int): Long = withCollection {
        val filter = Filters.eq(Player::name.name, name)
        val update = Updates.set(Player::score.name, score)

        updateOne(filter, update).modifiedCount
    }
}