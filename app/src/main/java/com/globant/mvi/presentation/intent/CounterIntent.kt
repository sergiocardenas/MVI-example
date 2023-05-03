package com.globant.mvi.presentation.intent

import com.globant.mvi.presentation.state.CounterViewState

sealed class CounterIntent {
    object Increment : CounterIntent()
    object Decrement : CounterIntent()
}

fun counterReducer(state: CounterViewState, intent: CounterIntent): CounterViewState {
    var currentCount = 0
    if (state is CounterViewState.Count) {
        currentCount = state.count
    }
    return when (intent) {
        is CounterIntent.Increment -> CounterViewState.Count(currentCount + 1)
        is CounterIntent.Decrement -> CounterViewState.Count(currentCount - 1)
    }
}