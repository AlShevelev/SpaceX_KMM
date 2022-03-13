package com.example.spacextestapp.android.mainscreen

import androidx.lifecycle.ViewModel
import com.example.spacextestapp.viewmodel.MainScreenViewModel

/**
 * It's a wrapper around a shared viewmodel (to embed it into android infrastructure)
 */
class MainScreenAndroidViewModel(
    val sharedViewModel: MainScreenViewModel
) : ViewModel() {

    override fun onCleared() {
        super.onCleared()
        sharedViewModel.clean()
    }
}