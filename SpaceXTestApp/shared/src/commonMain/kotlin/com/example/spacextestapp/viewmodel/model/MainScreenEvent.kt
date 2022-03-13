package com.example.spacextestapp.viewmodel.model

sealed class MainScreenEvent {
    object OnStart : MainScreenEvent()

    object OnForceReload : MainScreenEvent()
}