package com.snapshoes.store.persistense.entities

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
data class Genre(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
) {
    // Default constructor
    constructor() : this(
        null,
        "",
        null,
        null
    )
}