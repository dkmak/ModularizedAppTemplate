package com.example.network.service

import com.example.network.model.PokemonResponse
import javax.inject.Inject

class PokedexClient @Inject constructor(
    private val pokedexService: PokedexService
) {
    suspend fun fetchPokemonList(page: Int): PokemonResponse {
     return pokedexService.fetchPokemonList(
         limit = PAGING_SIZE,
         offset = page * PAGING_SIZE
     )
    }

    suspend fun fetchPokemonInfo(name: String){}

    companion object {
        private const val PAGING_SIZE = 20
    }
}