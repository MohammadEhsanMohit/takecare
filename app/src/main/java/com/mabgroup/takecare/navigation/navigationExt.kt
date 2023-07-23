package com.mabgroup.takecare.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.mabgroup.takecare.feature.peoplelist.presentation.add_edit_patient.AddEditPatientScreen
import com.mabgroup.takecare.feature.peoplelist.presentation.add_edit_patient.AddEditPatientViewModel
import com.mabgroup.takecare.feature.peoplelist.presentation.list.PatientListScreen
import com.mabgroup.takecare.feature.peoplelist.presentation.util.PatientScreen
import com.mabgroup.takecare.navigation.RouteConstant.PATIENT_GRAPH_ROUE
import com.mabgroup.takecare.navigation.RouteConstant.PatientNavLinkPARAM.PATIENT_LIST_SCREEN_URL_PARAMETER
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

fun NavGraphBuilder.patientGraph(navController: NavController) {
    navigation(
        startDestination = PatientScreen.PatientListScreen.route,
        route = PATIENT_GRAPH_ROUE
    ) {
        composable(route = PatientScreen.PatientListScreen.route) {
            PatientListScreen(navController = navController)
        }
        composable(route = PATIENT_LIST_SCREEN_URL_PARAMETER,
            arguments = listOf(
                navArgument("patient") {
                    type = NavType.LongType
                    defaultValue = -1
                },
                navArgument("pColor") {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )) {
            val colorInt = it.arguments?.getInt("pColor") ?: -1
            val patientId = it.arguments?.getLong("patient") ?: -1
            val viewModel = getViewModel<AddEditPatientViewModel>(
                parameters = { parametersOf(patientId) }
            )
            AddEditPatientScreen(navController = navController, pColor = colorInt,viewModel)
        }
    }
}