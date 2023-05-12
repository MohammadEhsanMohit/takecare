package com.mabgroup.takecare.di


import com.mabgroup.takecare.feature.peoplelist.data.repository.PatientRepositoryImpl
import com.mabgroup.takecare.feature.peoplelist.domain.repository.PatientRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<PatientRepository> { PatientRepositoryImpl(get()) }
}