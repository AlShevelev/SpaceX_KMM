package com.example.spacextestapp.android.mainscreen.viewmodel.model

internal sealed class MainScreenEvent {
    object OnStart : MainScreenEvent()

    object OnForceReload : MainScreenEvent()
}