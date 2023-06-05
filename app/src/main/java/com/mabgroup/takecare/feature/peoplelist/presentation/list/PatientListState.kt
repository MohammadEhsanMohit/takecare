package com.mabgroup.takecare.feature.peoplelist.presentation.list

import com.mabgroup.takecare.feature.peoplelist.domain.util.PatientListOrder
import com.mabgroup.takecare.feature.peoplelist.domain.util.OrderType
import com.mabgroup.takecare.feature.peoplelist.domain.model.Patient


data class PatientListState(
    val patientList : List<Patient> = emptyList(),
    val patientListOrder: PatientListOrder = PatientListOrder.Date(OrderType.Descending),
    val isOrderSectionVisible : Boolean = false
)