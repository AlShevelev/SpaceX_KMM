package com.example.spacextestapp.viewmodel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

abstract class ViewModelBase<E, S, A> : Cleanable {
    protected val viewModelScope by lazy {
        ViewModelScope(SupervisorJob() + Dispatchers.Main.immediate)
    }

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

    override fun clean() {
        viewModelScope.close()
    }

    protected open fun setState(state: S) = stateFlow.tryEmit(state)

    protected fun getState(): S? = state.replayCache.firstOrNull()

    protected fun emitAction(action: A) {
        actionFlow.tryEmit(action)
    }
}