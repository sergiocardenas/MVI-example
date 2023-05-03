package com.globant.mvi.presentation.state

sealed class CounterViewState {
    object Idle : CounterViewState()
    data class Count(val count: Int) : CounterViewState()
}