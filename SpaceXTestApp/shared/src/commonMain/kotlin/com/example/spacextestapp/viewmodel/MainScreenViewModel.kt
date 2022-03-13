package com.example.spacextestapp.viewmodel

import com.example.spacextestapp.SpaceXSDK
import com.example.spacextestapp.cache.DatabaseDriverFactory
import com.example.spacextestapp.viewmodel.model.MainScreenAction
import com.example.spacextestapp.viewmodel.model.MainScreenEvent
import com.example.spacextestapp.viewmodel.model.MainScreenState
import kotlinx.coroutines.launch

class MainScreenViewModel(
    databaseDriverFactory: DatabaseDriverFactory
) : ViewModelBase<MainScreenEvent, MainScreenState, MainScreenAction>() {

    private val sdk = SpaceXSDK(databaseDriverFactory)

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