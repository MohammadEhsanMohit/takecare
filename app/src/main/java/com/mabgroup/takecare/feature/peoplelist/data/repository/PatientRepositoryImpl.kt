package com.mabgroup.takecare.feature.peoplelist.data.repository

import com.mabgroup.takecare.feature.peoplelist.data.data_source.PatientDao
import com.mabgroup.takecare.feature.peoplelist.domain.model.Patient
import com.mabgroup.takecare.feature.peoplelist.domain.repository.PatientRepository

class PatientRepositoryImpl(
    private val patientDao: PatientDao
    ) : PatientRepository {

    override fun getAllPatient() = patientDao.getAllPatient()

    override suspend fun insertPatient(patient: Patient) = patientDao.insertPatient(patient)

    override suspend fun deletePatient(patient: Patient) {
        patientDao.deletePatient(patient)
    }

    override suspend fun getPatientById(patientId: Long) = patientDao.getPatientById(patientId)
}