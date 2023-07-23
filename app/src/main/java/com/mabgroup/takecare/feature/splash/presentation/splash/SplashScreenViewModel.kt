package com.mabgroup.takecare.feature.splash.presentation.splash

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mabgroup.takecare.feature.splash.domain.user_case.CheckUserLogin
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch

class SplashScreenViewModel(
    private val useCase : CheckUserLogin
) : ViewModel(){

    private val _progressState = mutableStateOf(0f)
    val progressState = _progressState

    private val _operationDone = MutableSharedFlow<Float>()
    val operationDone = _operationDone.asSharedFlow()

    init {
        viewModelScope.launch {
            useCase().collect {
                for(i in 0..100) {
                    delay(100)
                    _progressState.value = _progressState.value + 0.1f
                    _operationDone.emit(_progressState.value)
                }
            }
        }
    }
}