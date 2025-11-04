package com.example.core.database.entity.mapper
import com.example.core.database.entity.PokemonEntity
import com.example.model.Pokemon
import org.junit.Assert.assertEquals
import org.junit.Test

class PokemonEntityMapperTest {

    @Test
    fun `PokemonEntity asDomain() correctly maps to model`(){
        val testEntity = PokemonEntity(
            pokedexIndex = 25,
            name = "pikachu",
            page = 2,
            url = "https://pokeapi.co/api/v2/pokemon/25/"
        )

        val domainModel = testEntity.asDomain()

        assertEquals(25, domainModel.pokedexIndex)
        assertEquals("pikachu", domainModel.nameField)
        assertEquals("Pikachu", domainModel.name)
        assertEquals(2, domainModel.page)
        assertEquals("https://pokeapi.co/api/v2/pokemon/25/", domainModel.url)
    }

    @Test
    fun `Pokemon asEntity() correctly maps to PokemonEntity`() {
        val domainModel = Pokemon(
            page = 2,
            nameField = "pikachu",
            url = "https://pokeapi.co/api/v2/pokemon/25/"
        )

        val entity = domainModel.asEntity()

        assertEquals(25, entity.pokedexIndex)
        assertEquals("pikachu", entity.name)
        assertEquals(2, entity.page)
        assertEquals("https://pokeapi.co/api/v2/pokemon/25/", entity.url)
    }
}