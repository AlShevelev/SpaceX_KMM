package com.example.spacextestapp.android.mainscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.spacextestapp.android.mainscreen.presentation.Root
import com.example.spacextestapp.android.mainscreen.viewmodel.MainScreenViewModel

class MainScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = MainScreenViewModel(this.applicationContext)

        setContent {
            Root(viewModel)
        }
    }
}