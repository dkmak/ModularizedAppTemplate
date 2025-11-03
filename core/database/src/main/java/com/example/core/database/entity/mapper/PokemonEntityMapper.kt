package com.example.core.database.entity.mapper

import com.example.core.database.entity.PokemonEntity
import com.example.model.Pokemon

/*interface EntityMapper<Entity, Domain> {
    fun asEntity(domain: Domain): Entity
    fun asDomain(entity: Entity): Domain
}

object PokemonEntityMapper : EntityMapper<List<PokemonEntity>, List<Pokemon>> {
    override fun asEntity(domain: List<Pokemon>): List<PokemonEntity> {
        return domain.map { pokemon ->
            PokemonEntity(
                pokedexIndex = pokemon.pokedexIndex,
                page = pokemon.page,
                name = pokemon.nameField,
                url = pokemon.url
            )
        }
    }

    override fun asDomain(entity: List<PokemonEntity>): List<Pokemon> {
        return entity.map{ entity ->
            Pokemon(
                page = entity.page,
                nameField = entity.name,
                url = entity.url
            )
        }
    }
}*/


/**
 * Converts a domain model [Pokemon] to a database [PokemonEntity].
 */
fun Pokemon.asEntity(): PokemonEntity {
    return PokemonEntity(
        pokedexIndex = this.pokedexIndex,
        page = this.page,
        name = this.nameField, // Use nameField as it holds the raw name
        url = this.url
    )
}

/**
 * Converts a database [PokemonEntity] to a domain model [Pokemon].
 */
fun PokemonEntity.asDomain(): Pokemon {
    return Pokemon(
        page = this.page,
        nameField = this.name, // The entity's `name` maps back to `nameField`
        url = this.url
    )
}

/**
 * Converts a list of domain models to a list of database entities.
 */
fun List<Pokemon>.asEntity(): List<PokemonEntity> {
    return this.map { it.asEntity() } // Reuses the single-object mapper
}

/**
 * Converts a list of database entities to a list of domain models.
 * Handles null lists gracefully by converting them to an empty list.
 */
fun List<PokemonEntity>?.asDomain(): List<Pokemon> {
    return this.orEmpty().map { it.asDomain() } // Reuses the single-object mapper
}
