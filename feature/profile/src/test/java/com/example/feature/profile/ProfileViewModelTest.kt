package com.example.feature.profile

import androidx.lifecycle.SavedStateHandle
import com.example.core.common.ui.navigation.POKEMON_ID_ARG
import com.example.core.data.repository.profile.ProfileRepository
import com.example.model.Pokemon
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ProfileViewModelTest {
    private val testDispatcher = StandardTestDispatcher()

    private lateinit var profileRepository: ProfileRepository

    private lateinit var viewModel: ProfileViewModel

    @Before
    fun setup(){
        Dispatchers.setMain(testDispatcher)
        profileRepository = mockk()

        val testPokemonId = 25

        val savedStateHandle = SavedStateHandle(
            mapOf(POKEMON_ID_ARG to testPokemonId)
        )
        val mockPokemon = Pokemon(nameField = "Pikachu", url = "https://pokeapi.co/api/v2/pokemon/25/")
        coEvery { profileRepository.getPokemonById(testPokemonId) } returns flowOf(mockPokemon)

        viewModel = ProfileViewModel(
            profileRepository,
            savedStateHandle
        )
    }

    @After
    fun after(){
        Dispatchers.resetMain()
    }

    @Test
    fun  `pokemonInfo emits correct Pokemon from repository`() = runTest {
        val job = launch(testDispatcher) {viewModel.pokemonInfo.collect {}}
        advanceUntilIdle()

        val pokemonInfo = viewModel.pokemonInfo.value
        Assert.assertEquals("Pikachu", pokemonInfo.name)
        Assert.assertEquals(25, pokemonInfo.pokedexIndex)

        job.cancel()
    }

}