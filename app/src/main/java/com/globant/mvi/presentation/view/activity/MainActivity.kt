package com.globant.mvi.presentation.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.globant.mvi.presentation.view.screen.CounterScreen
import com.globant.mvi.presentation.viewmodel.CounterViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var counterViewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        counterViewModel = ViewModelProvider(this)[CounterViewModel::class.java]
        setContent {
            CounterScreen(viewModel = counterViewModel)
        }
    }
}