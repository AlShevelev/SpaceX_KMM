package com.example.spacextestapp.android.mainscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.spacextestapp.android.mainscreen.presentation.Root
import com.example.spacextestapp.cache.DatabaseDriverFactory
import com.example.spacextestapp.viewmodel.MainScreenViewModel

class MainScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel by viewModels<MainScreenAndroidViewModel> {
            object: ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClassMainScreen: Class<T>): T =
                    MainScreenAndroidViewModel(
                        MainScreenViewModel(
                            DatabaseDriverFactory(this@MainScreenActivity.applicationContext)
                        )
                    ) as T
            }
        }

        setContent {
            Root(viewModel.sharedViewModel)
        }
    }
}