package com.example.core.data.repository.profile

import com.example.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    fun getPokemonById(id: Int): Flow<Pokemon>
}