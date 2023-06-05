package com.mabgroup.takecare.di

import com.mabgroup.takecare.feature.peoplelist.presentation.add_edit_patient.AddEditPatientViewModel
import com.mabgroup.takecare.feature.peoplelist.presentation.list.PatientListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { PatientListViewModel(get()) }
    viewModel { AddEditPatientViewModel(get(),get())}
}