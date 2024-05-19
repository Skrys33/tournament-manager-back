package com.enzosagnelonge.model

import kotlinx.serialization.Serializable

@Serializable
data class Player(
    val name: String,
    val score: Int = 0,
    var rank: Int? = -1
)
