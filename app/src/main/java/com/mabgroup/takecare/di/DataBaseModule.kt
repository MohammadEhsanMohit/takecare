package com.mabgroup.takecare.di

import android.app.Application
import androidx.room.Room
import com.mabgroup.takecare.feature.peoplelist.data.data_source.PatientDataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataBase = module {
    single { providePatientDataBase(androidApplication()) }
    factory { providePatientDao(get()) }
}

fun providePatientDao(db: PatientDataBase) = db.patientDao

fun providePatientDataBase(androidApplication: Application) = Room.databaseBuilder(
    androidApplication,
    PatientDataBase::class.java,
    PatientDataBase.DATA_BASE_NAME
).build()


