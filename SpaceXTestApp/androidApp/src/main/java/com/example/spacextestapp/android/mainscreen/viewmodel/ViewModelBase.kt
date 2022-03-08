package com.example.spacextestapp.android.mainscreen.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

internal abstract class ViewModelBase<E, S, A> : ViewModel() {
    private val stateFlow =
        MutableSharedFlow<S>(
            replay = 1,
            onBufferOverflow = BufferOverflow.DROP_OLDEST
        )

    private val actionFlow = MutableSharedFlow<A>(
        replay = 0,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
        extraBufferCapacity = 1
    )

    val state: SharedFlow<S> = stateFlow

    val action: SharedFlow<A> = actionFlow

    abstract fun onEvent(event: E)

    protected open fun setState(state: S) = stateFlow.tryEmit(state)

    protected fun getState(): S? = state.replayCache.firstOrNull()

    protected fun emitAction(action: A) {
        actionFlow.tryEmit(action)
    }
}