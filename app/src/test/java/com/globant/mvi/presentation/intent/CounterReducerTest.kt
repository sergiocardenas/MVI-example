package com.globant.mvi.presentation.intent

import com.globant.mvi.presentation.state.CounterViewState
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.Strict::class)
class CounterReducerTest {

    @Test
    fun `counterReducer should increment count when given Increment intent`() {
        val model = CounterViewState.Count(0)
        val intent = CounterIntent.Increment
        val expected = CounterViewState.Count(1)

        val actual = counterReducer(model, intent)

        assertEquals(expected, actual)
    }

    @Test
    fun `counterReducer should decrement count when given Decrement intent`() {
        val model = CounterViewState.Count(1)
        val intent = CounterIntent.Decrement
        val expected = CounterViewState.Count(0)

        val actual = counterReducer(model, intent)

        assertEquals(expected, actual)
    }
}