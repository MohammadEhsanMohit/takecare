package com.mabgroup.takecare.feature.peoplelist.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mabgroup.takecare.feature.peoplelist.domain.model.Patient
import kotlinx.coroutines.flow.Flow

@Dao
interface PatientDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPatient(patient: Patient) : Long

    @Delete
    suspend fun deletePatient(patient: Patient)

    @Query("select * from patient where id = :patientId")
    suspend fun getPatientById(patientId: Long) : Patient

    @Query("Select * from patient")
    fun getAllPatient() : Flow<List<Patient>>
}