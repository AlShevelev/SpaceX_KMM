package com.example.spacextestapp.android.mainscreen.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.spacextestapp.android.mainscreen.ui.theme.SpaceXTestAppTheme
import com.example.spacextestapp.viewmodel.MainScreenViewModel
import com.example.spacextestapp.viewmodel.model.MainScreenEvent
import com.example.spacextestapp.viewmodel.model.MainScreenState

@Composable
internal fun Root(viewModel: MainScreenViewModel) {
    SpaceXTestAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val state = viewModel.state.collectAsState(initial = MainScreenState.Loading)

            val contentModifier = Modifier.fillMaxSize()

            when(val stateValue = state.value) {
                MainScreenState.Loading -> LoadingState(contentModifier)

                MainScreenState.Error -> ErrorState(
                    contentModifier,
                    onReloadClick = { viewModel.onEvent(MainScreenEvent.OnForceReload) }
                )

                is MainScreenState.Content -> ContentState(
                    modifier = contentModifier,
                    content = stateValue.launches,
                    onReloadClick = { viewModel.onEvent(MainScreenEvent.OnForceReload) }
                )
            }
        }

        LaunchedEffect(true) {
            viewModel.onEvent(MainScreenEvent.OnStart)

            viewModel.action.collect { action ->

            }
        }
    }
}