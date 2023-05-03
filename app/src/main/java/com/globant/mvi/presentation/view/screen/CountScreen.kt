package com.globant.mvi.presentation.view.screen


import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.globant.mvi.presentation.intent.CounterIntent
import com.globant.mvi.presentation.state.CounterViewState
import com.globant.mvi.presentation.viewmodel.CounterViewModel


@Composable
fun CounterScreen(viewModel: CounterViewModel) {
    val counterState = viewModel.state.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        when(counterState.value){
            // Display idle state UI
            is CounterViewState.Idle -> {
                Text(
                    text = "Click the buttons to start counting!",
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(horizontal = 16.dp))
            }
            // Display current count state UI
            is CounterViewState.Count -> {
                val count = (counterState.value as CounterViewState.Count).count
                Text(text = count.toString(), fontSize = 30.sp)
            }
        }

        Row(
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Button(
                onClick = { viewModel.sendIntent(CounterIntent.Increment) },
                modifier = Modifier.padding(end = 5.dp)
            ) {
                Text("Increment")
            }
            Button(
                onClick = { viewModel.sendIntent(CounterIntent.Decrement) },
                modifier = Modifier.padding(start = 5.dp)
            ) {
                Text("Decrement")
            }
        }
    }
}