package com.mabgroup.takecare.navigation

import com.mabgroup.takecare.navigation.RouteConstant.FeatureRoutesNAME.PATIENT_ADD_EDIT_SCREEN


object RouteConstant {
    const val PATIENT_SCREEN = "patientScreen"

    object FeatureRoutesNAME {
        const val PATIENT_LIST_SCREEN = "patient_screen"
        const val PATIENT_ADD_EDIT_SCREEN = "add_edit_patient_screen"
    }

    object PatientNavLinkPARAM {
        const val PATIENT_LIST_SCREEN_URL_PARAMETER = "$PATIENT_ADD_EDIT_SCREEN?patient={patientId}&pColor={patientColor}"
    }


    //Bottom Nav
    const val BOTTOM_PROFILE_ROUTE = "profile"
    const val BOTTOM_RECIPE_LIST_ROUTE= "RecipeList"
    const val BOTTOM_PAGE_ROUTE = "BottomPage"
}