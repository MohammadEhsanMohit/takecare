package com.mabgroup.takecare.feature.peoplelist.domain.use_case

import com.mabgroup.takecare.feature.peoplelist.domain.model.Patient
import com.mabgroup.takecare.feature.peoplelist.domain.repository.PatientRepository
import kotlinx.coroutines.flow.Flow

class PatientListUseCase(
    private val repo : PatientRepository
) {
    operator fun invoke() : Flow<List<Patient>> = repo.getAllPatient()
}