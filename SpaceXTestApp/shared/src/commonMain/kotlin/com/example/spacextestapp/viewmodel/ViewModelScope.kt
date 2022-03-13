package com.example.spacextestapp.viewmodel

import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel

class ViewModelScope(override val coroutineContext: CoroutineContext) : CoroutineScope {
    fun close() {
        coroutineContext.cancel()
    }
}