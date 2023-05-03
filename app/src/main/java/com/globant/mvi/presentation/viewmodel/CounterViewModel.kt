package com.globant.mvi.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.globant.mvi.presentation.intent.CounterIntent
import com.globant.mvi.presentation.intent.counterReducer
import com.globant.mvi.presentation.state.CounterViewState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CounterViewModel : ViewModel() {
    private val _state = MutableStateFlow<CounterViewState>(CounterViewState.Idle)
    val state: StateFlow<CounterViewState> = _state.asStateFlow()

    private val intentChannel = Channel<CounterIntent>(Channel.BUFFERED)

    init {
        viewModelScope.launch {
            for (intent in intentChannel) {
                intentHandler(intent)
            }
        }
    }

    private fun intentHandler(intent: CounterIntent){
        _state.value = counterReducer(_state.value, intent)
    }

    fun sendIntent(intent: CounterIntent) {
        viewModelScope.launch {
            intentChannel.send(intent)
        }
    }
}
