package com.mabgroup.takecare.di

import com.mabgroup.takecare.feature.peoplelist.presentation.add_edit_patient.AddEditPatientViewModel
import com.mabgroup.takecare.feature.peoplelist.presentation.list.PatientListViewModel
import com.mabgroup.takecare.feature.splash.presentation.splash.SplashScreenView
import com.mabgroup.takecare.feature.splash.presentation.splash.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { SplashScreenViewModel(get()) }
    viewModel { PatientListViewModel(get()) }
    viewModel { AddEditPatientViewModel(get(),get())}
}