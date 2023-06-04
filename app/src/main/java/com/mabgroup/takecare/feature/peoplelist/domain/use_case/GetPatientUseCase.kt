package com.mabgroup.takecare.feature.peoplelist.domain.use_case

import com.mabgroup.takecare.feature.peoplelist.domain.repository.PatientRepository

class GetPatientUseCase(
    private val repo : PatientRepository
) {

    suspend operator fun invoke(patientId:Long) = repo.getPatientById(patientId)
}