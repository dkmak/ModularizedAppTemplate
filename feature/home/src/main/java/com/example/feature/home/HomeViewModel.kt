package com.example.feature.home

import androidx.lifecycle.ViewModel
import com.example.core.data.repository.home.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.example.model.Pokemon
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

@HiltViewModel
class HomeViewModel @Inject constructor(
    val homeRepository: HomeRepository
): ViewModel(){

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    private val pokemonFetchingIndex: MutableStateFlow<Int> = MutableStateFlow(0)

    @OptIn(ExperimentalCoroutinesApi::class)
    val pokemonList : StateFlow<List<Pokemon>> = pokemonFetchingIndex.flatMapLatest { page ->
        homeRepository.fetchPokemonList(page = page)
            .onStart { _isLoading.value = true }
            .onCompletion { _isLoading.value = false }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList(),
    )

    fun fetchNextPokemonList() {
        pokemonFetchingIndex.value++
    }
}