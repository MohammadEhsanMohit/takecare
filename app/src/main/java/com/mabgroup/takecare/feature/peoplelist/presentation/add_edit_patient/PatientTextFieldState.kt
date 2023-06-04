package com.mabgroup.takecare.feature.peoplelist.presentation.add_edit_patient

import androidx.annotation.StringRes

data class PatientTextFieldState(
    val text : String = "",
    @StringRes val hint : Int,
    val isHintVisible : Boolean = true
)