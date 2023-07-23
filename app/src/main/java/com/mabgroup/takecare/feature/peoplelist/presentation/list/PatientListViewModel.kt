package com.mabgroup.takecare.feature.peoplelist.presentation.list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mabgroup.takecare.feature.peoplelist.domain.use_case.PatientListUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class PatientListViewModel(
    private val listUseCase: PatientListUseCase
)  : ViewModel() {
    private val _state = mutableStateOf(PatientListState())
    val state : State<PatientListState> = _state
    private var getListJob : Job? = null
    init {
        getPatient()
    }

    private fun getPatient() {
        getListJob?.cancel()
        getListJob = listUseCase.invoke()
            .onEach {
                _state.value = state.value.copy(
                    patientList = it
                )
            }
            .launchIn(viewModelScope)
    }

    fun onEvent(event: PatientListEvent) {
        when(event) {
            is PatientListEvent.DeleteNote -> {

            }
            is PatientListEvent.Order -> {
                _state.value = state.value.copy(
                    patientListOrder = event.listOrder
                )

            }
            PatientListEvent.RestoreNote -> {

            }
            is PatientListEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = event.open
                )
            }
        }
    }

}