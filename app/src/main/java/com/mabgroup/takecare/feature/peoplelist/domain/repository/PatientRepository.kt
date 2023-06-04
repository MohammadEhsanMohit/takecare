package com.mabgroup.takecare.feature.peoplelist.domain.repository

import com.mabgroup.takecare.feature.peoplelist.domain.model.Patient
import kotlinx.coroutines.flow.Flow

interface PatientRepository {
    fun getAllPatient() : Flow<List<Patient>>

    suspend fun insertPatient(patient: Patient) : Long

    suspend fun deletePatient(patient: Patient)

    suspend fun getPatientById(patientId: Long) : Patient?
}