package com.mabgroup.takecare.feature.peoplelist.presentation.add_edit_patient

import androidx.compose.ui.focus.FocusState

sealed class AddEditPatientEvent {
    data class EnteredFirstName(val value:String) : AddEditPatientEvent()
    data class ChangeFirstNameFocus(val focusState:FocusState) : AddEditPatientEvent()
    data class EnteredLastName(val value:String) : AddEditPatientEvent()
    data class ChangeLastNameFocus(val focusState:FocusState) : AddEditPatientEvent()
    data class ChangeGender(val genderInt:Int) : AddEditPatientEvent()
    data class ChangeMobility(val isMobile:Boolean): AddEditPatientEvent()
    data class HasSpeakAbility(val hasSpeakAbility:Boolean) : AddEditPatientEvent()
    data class NeedCompanionFor24Hours(val needCompanion:Boolean) : AddEditPatientEvent()
    data class HealthSummery(val summery:String?) : AddEditPatientEvent()
    data class HealthSummeryChangeFocus(val focusState:FocusState) : AddEditPatientEvent()
    data class CommunicationDescription(val description:String):AddEditPatientEvent()
    data class CommunicationDescriptionChangeFocus(val focusState:FocusState) : AddEditPatientEvent()
    data class MobilityDescription(val description:String):AddEditPatientEvent()
    data class MobilityDescriptionChangeFocus(val focusState:FocusState):AddEditPatientEvent()
    data class ChangeColor(val color: Int) : AddEditPatientEvent()
    object SavePatient: AddEditPatientEvent()
}