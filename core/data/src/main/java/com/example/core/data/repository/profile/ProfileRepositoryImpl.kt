package com.example.core.data.repository.profile

import com.example.core.database.dao.PokemonDao
import com.example.core.database.entity.mapper.asDomain
import com.example.model.Pokemon
import com.example.network.service.PokedexClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val pokedexClient: PokedexClient,
    private val pokemonDao: PokemonDao,
    private val ioDispatcher: CoroutineDispatcher
): ProfileRepository {
    override fun getPokemonById(id: Int): Flow<Pokemon> = flow {
        val pokemon = pokemonDao.getPokemonById(id).asDomain()
        emit(pokemon)
    }.flowOn(ioDispatcher)
}