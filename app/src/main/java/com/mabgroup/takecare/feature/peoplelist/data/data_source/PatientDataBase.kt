package com.mabgroup.takecare.feature.peoplelist.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mabgroup.takecare.feature.peoplelist.domain.moodel.GenderTypeConverts
import com.mabgroup.takecare.feature.peoplelist.domain.moodel.Patient

@Database(entities = [(Patient::class)], version = 1, exportSchema = false)
@TypeConverters(GenderTypeConverts::class)
abstract class PatientDataBase : RoomDatabase() {
    abstract val patientDao : PatientDao

    companion object {
        val DATA_BASE_NAME = "Patient_db"
    }
}