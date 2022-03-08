package com.example.spacextestapp.android.mainscreen.viewmodel

import android.content.Context
import androidx.lifecycle.viewModelScope
import com.example.spacextestapp.SpaceXSDK
import com.example.spacextestapp.android.mainscreen.viewmodel.model.MainScreenAction
import com.example.spacextestapp.android.mainscreen.viewmodel.model.MainScreenEvent
import com.example.spacextestapp.android.mainscreen.viewmodel.model.MainScreenState
import com.example.spacextestapp.cache.DatabaseDriverFactory
import kotlinx.coroutines.launch

internal class MainScreenViewModel(
    appContext: Context
) : ViewModelBase<MainScreenEvent, MainScreenState, MainScreenAction>() {

    private val sdk = SpaceXSDK(DatabaseDriverFactory(appContext))

    override fun onEvent(event: MainScreenEvent) {
        when(event) {
            MainScreenEvent.OnStart -> handleOnStart()
            MainScreenEvent.OnForceReload -> handleOnForceReload()
        }
    }

    private fun handleOnStart() = loadContent(false)

    private fun handleOnForceReload() = loadContent(true)

    private fun loadContent(forceReload: Boolean) {
        viewModelScope.launch {
            setState(MainScreenState.Loading)
            try {
                setState(MainScreenState.Content(sdk.getLaunches(forceReload)))
            } catch (ex: Exception) {
                ex.printStackTrace()
                setState(MainScreenState.Error)
            }
        }
    }
}