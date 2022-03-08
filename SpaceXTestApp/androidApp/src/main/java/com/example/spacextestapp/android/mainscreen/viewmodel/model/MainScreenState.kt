package com.example.spacextestapp.android.mainscreen.viewmodel.model

import com.example.spacextestapp.entity.RocketLaunch

internal sealed class MainScreenState {
    object Loading : MainScreenState()

    object Error : MainScreenState()

    data class Content(
        val launches: List<RocketLaunch>
    ) : MainScreenState()
}