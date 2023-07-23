package com.mabgroup.takecare.feature.splash.presentation.util

import com.mabgroup.takecare.navigation.BaseRoutingModel
import com.mabgroup.takecare.navigation.RouteConstant.FeatureRoutesName.SPLASH_SCREEN
import com.mabgroup.takecare.navigation.RouteConstant.FeatureRoutesName.SPLASH_TO_PATIENT_LIST

sealed class SplashRoutingClass(route: String) : BaseRoutingModel(route) {
    object SplashScreenLoadingClass : SplashRoutingClass(SPLASH_SCREEN)
    object GoToHome : SplashRoutingClass(SPLASH_TO_PATIENT_LIST)
}