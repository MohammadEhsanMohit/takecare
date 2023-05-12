package com.mabgroup.takecare.feature.peoplelist.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mabgroup.takecare.feature.peoplelist.domain.use_case.PatientListUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn

class PatientListViewModel(
    private val listUseCase: PatientListUseCase
)  : ViewModel() {
    private var getListJob : Job? = null
    init {
        getPatient()
    }

    private fun getPatient() {
        getListJob?.cancel()
        getListJob = listUseCase.invoke()
            .launchIn(viewModelScope)
    }
}