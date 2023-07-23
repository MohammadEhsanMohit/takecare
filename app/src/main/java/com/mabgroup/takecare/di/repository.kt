package com.mabgroup.takecare.di


import com.example.composeapplication.feature.splash.data.repository.SplashScreenRepositoryImp
import com.mabgroup.takecare.feature.splash.domain.repository.SplashScreenRepository
import com.mabgroup.takecare.feature.peoplelist.data.repository.PatientRepositoryImpl
import com.mabgroup.takecare.feature.peoplelist.domain.repository.PatientRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<PatientRepository> { PatientRepositoryImpl(get()) }
    factory<SplashScreenRepository> { SplashScreenRepositoryImp() }
}