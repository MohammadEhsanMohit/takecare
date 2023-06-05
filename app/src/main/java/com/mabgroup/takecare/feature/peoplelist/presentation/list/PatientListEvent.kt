package com.mabgroup.takecare.feature.peoplelist.presentation.list

import com.mabgroup.takecare.feature.peoplelist.domain.model.Patient
import com.mabgroup.takecare.feature.peoplelist.domain.util.PatientListOrder

sealed class PatientListEvent {
    data class Order(val listOrder: PatientListOrder) : PatientListEvent()
    data class DeleteNote(val patient: Patient) : PatientListEvent()
    object RestoreNote : PatientListEvent()
    object ToggleOrderSection : PatientListEvent()
}
