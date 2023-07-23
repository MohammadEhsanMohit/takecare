package com.mabgroup.takecare.feature.peoplelist.presentation.util

import com.mabgroup.takecare.navigation.BaseRoutingModel
import com.mabgroup.takecare.navigation.RouteConstant.FeatureRoutesName.PATIENT_ADD_EDIT_SCREEN
import com.mabgroup.takecare.navigation.RouteConstant.FeatureRoutesName.PATIENT_LIST_SCREEN


sealed class PatientScreen(route: String):BaseRoutingModel(route) {
    object PatientListScreen : PatientScreen(PATIENT_LIST_SCREEN)
    object PatientAddEditPatientScreen : PatientScreen(PATIENT_ADD_EDIT_SCREEN)
}