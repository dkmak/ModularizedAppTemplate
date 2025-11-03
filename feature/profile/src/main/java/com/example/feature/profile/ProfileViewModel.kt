package com.example.feature.profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.common.ui.navigation.POKEMON_ID_ARG
import com.example.core.data.repository.profile.ProfileRepository
import com.example.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    val profileRepository: ProfileRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    // TODO: make a new navigation module, or move pokemon_arg_elsewhere
    @OptIn(ExperimentalCoroutinesApi::class)
    val pokemonInfo: StateFlow<Pokemon> = savedStateHandle.getStateFlow(POKEMON_ID_ARG, 0)
        .flatMapLatest { index ->
           profileRepository.getPokemonById(index)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000), // what is this
            initialValue = Pokemon(
                page = 0,
                nameField = "Unknown Pokemon",
                url = ""
            ),
        )


}
