package com.mabgroup.takecare.feature.peoplelist.domain.use_case

data class PatientAddEditUseCase(
    val getPatient:GetPatientUseCase,
    val addPatient:AddPatientUseCase
)