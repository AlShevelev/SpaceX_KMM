package com.example.spacextestapp.viewmodel.model

import com.example.spacextestapp.entity.RocketLaunch

sealed class MainScreenState {
    object Loading : MainScreenState()

    object Error : MainScreenState()

    data class Content(
        val launches: List<RocketLaunch>
    ) : MainScreenState()
}