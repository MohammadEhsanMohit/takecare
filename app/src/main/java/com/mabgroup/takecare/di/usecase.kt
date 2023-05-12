package com.mabgroup.takecare.di

import com.mabgroup.takecare.feature.peoplelist.domain.use_case.PatientListUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { PatientListUseCase(get()) }
}