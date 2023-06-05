package com.mabgroup.takecare.feature.peoplelist.presentation.util

import com.mabgroup.takecare.navigation.RouteConstant.FeatureRoutesNAME.PATIENT_ADD_EDIT_SCREEN
import com.mabgroup.takecare.navigation.RouteConstant.FeatureRoutesNAME.PATIENT_LIST_SCREEN


sealed class PatientScreen(val route: String) {
    object PatientListScreen : PatientScreen(PATIENT_LIST_SCREEN)
    object PatientAddEditPatientScreen : PatientScreen(PATIENT_ADD_EDIT_SCREEN)
}