package com.mabgroup.takecare.feature.peoplelist.domain.use_case

import com.mabgroup.takecare.feature.peoplelist.domain.model.InvalidPatientException
import com.mabgroup.takecare.feature.peoplelist.domain.model.Patient
import com.mabgroup.takecare.feature.peoplelist.domain.repository.PatientRepository

class AddPatientUseCase(
    private val repos: PatientRepository
) {
    @Throws(InvalidPatientException::class)
    suspend operator fun invoke(patient:Patient) {
        if(patient.firstName.isNullOrBlank()) {
            throw InvalidPatientException("Patient WithOut Name Is Not Valid!")
        }
        if(patient.lastName.isNullOrBlank()) {
            throw InvalidPatientException("Patient WithOut LastName is not valid!")
        }
        repos.insertPatient(patient)
    }
}