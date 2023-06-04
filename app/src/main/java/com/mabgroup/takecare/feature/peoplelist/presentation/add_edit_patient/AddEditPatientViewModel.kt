package com.mabgroup.takecare.feature.peoplelist.presentation.add_edit_patient

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mabgroup.takecare.R
import com.mabgroup.takecare.common.utils.Gender
import com.mabgroup.takecare.common.utils.itemRandomColor
import com.mabgroup.takecare.feature.peoplelist.domain.model.InvalidPatientException
import com.mabgroup.takecare.feature.peoplelist.domain.model.Patient
import com.mabgroup.takecare.feature.peoplelist.domain.use_case.PatientAddEditUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class AddEditPatientViewModel(
    private val patientUseCase: PatientAddEditUseCase,
    _patientId: Long?
) : ViewModel() {
    private var currentNoteId: Long? = null
    private val _patientColor = mutableStateOf<Int>(
        itemRandomColor
    )
    val patientColor: State<Int> = _patientColor
    private val _hasMobility = mutableStateOf(true)
    val hasMobility : State<Boolean> = _hasMobility
    private val _descriptionOfCommunication = mutableStateOf(
        PatientTextFieldState(
            hint = R.string.description_of_communication
        )
    )
    val descriptionOfCommunication : State<PatientTextFieldState> = _descriptionOfCommunication
    private val _patientNeedCompanion24 = mutableStateOf(false)
    val patientNeedCompanion24: State<Boolean> = _patientNeedCompanion24
    private val _hasSpeakAbility = mutableStateOf(true)
    val hasSpeakAbility :State<Boolean> = _hasSpeakAbility
    private val _descriptionHealthSummery = mutableStateOf(
        PatientTextFieldState(
            hint = R.string.description_health_summery
        )
    )
    val descriptionHealthSummery : State<PatientTextFieldState> = _descriptionHealthSummery
    private val _mobilityDescription = mutableStateOf(
        PatientTextFieldState(
            hint = R.string.description_mobility_summery
        )
    )
    val mobilityDescription : State<PatientTextFieldState> = _mobilityDescription
    init {
        _patientId?.let { patientId ->
            if (patientId != -1L) {
                viewModelScope.launch {
                    patientUseCase.getPatient(patientId)?.also { patientId ->
                        currentNoteId = patientId.id
                        _patientFirstName.value = patientFirstName.value.copy(
                            text = patientId.firstName,
                            isHintVisible = false
                        )
                        _patientFamily.value = patientFamily.value.copy(
                            text = patientId.lastName,
                            isHintVisible = false
                        )
                    }
                }
            }
        }
    }

    private val _patientFirstName = mutableStateOf(
        PatientTextFieldState(
            hint = R.string.patient_first_name
        )
    )
    val patientFirstName: State<PatientTextFieldState> = _patientFirstName

    private val _patientGender = mutableStateOf(
        Gender.NON_BINARY
    )
    val patientGender: State<Gender> = _patientGender

    private val _patientFamily = mutableStateOf(
        PatientTextFieldState(
            hint = R.string.patient_last_name
        )
    )
    val patientFamily: State<PatientTextFieldState> = _patientFamily


    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: AddEditPatientEvent) {
        when (event) {
            is AddEditPatientEvent.EnteredFirstName -> {
                _patientFirstName.value = patientFirstName.value.copy(
                    text = event.value
                )
            }

            is AddEditPatientEvent.ChangeFirstNameFocus -> {
                _patientFirstName.value = patientFirstName.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            patientFirstName.value.text.isBlank()
                )
            }

            is AddEditPatientEvent.EnteredLastName -> {
                _patientFamily.value = patientFamily.value.copy(
                    text = event.value
                )
            }

            is AddEditPatientEvent.ChangeLastNameFocus -> {
                _patientFamily.value = patientFamily.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            patientFamily.value.text.isBlank()
                )
            }

            AddEditPatientEvent.SavePatient -> {
                viewModelScope.launch {
                    try {
                        patientUseCase.addPatient.invoke(
                            Patient(
                                firstName = patientFirstName.value.text,
                                lastName = patientFamily.value.text,
                                gender = patientGender.value,
                                hasMobility = hasMobility.value,
                                mobilityDescription = mobilityDescription.value.text,
                                hasSpeak = hasSpeakAbility.value,
                                communicationDescription = descriptionOfCommunication.value.text,
                                needCompanion24 = patientNeedCompanion24.value,
                                healthSummery = descriptionHealthSummery.value.text,
                                color = patientColor.value,
                                id = currentNoteId ?: 0,
                            )
                        )

                        _eventFlow.emit(UiEvent.SaveNote)
                    } catch (e: InvalidPatientException) {
                        _eventFlow.emit(
                            UiEvent.ShowSnackBar(
                                e.message ?: "Couldn't Save Note!"
                            )
                        )
                    }
                }
            }

            is AddEditPatientEvent.ChangeGender -> {
                _patientGender.value = Gender.fromInt(event.genderInt)
            }

            is AddEditPatientEvent.ChangeColor -> {
                _patientColor.value = event.color
            }

            is AddEditPatientEvent.NeedCompanionFor24Hours -> {
                _patientNeedCompanion24.value = event.needCompanion
            }

            is AddEditPatientEvent.ChangeMobility -> _hasMobility.value = event.isMobile
            is AddEditPatientEvent.CommunicationDescription -> {
                _descriptionOfCommunication.value = descriptionOfCommunication.value.copy(
                    text = event.description
                )
            }
            is AddEditPatientEvent.CommunicationDescriptionChangeFocus -> {
                _descriptionOfCommunication.value = descriptionOfCommunication.value.copy(
                    isHintVisible = event.focusState.isFocused &&
                            descriptionOfCommunication.value.text.isBlank()
                )
            }
            is AddEditPatientEvent.HasSpeakAbility -> _hasSpeakAbility.value = event.hasSpeakAbility
            is AddEditPatientEvent.HealthSummery -> {
                _descriptionHealthSummery.value = descriptionHealthSummery.value.copy(
                    text = event.summery?:""
                )
            }
            is AddEditPatientEvent.HealthSummeryChangeFocus -> {
                _descriptionHealthSummery.value = descriptionHealthSummery.value.copy(
                    isHintVisible = event.focusState.isFocused &&
                            descriptionHealthSummery.value.text.isBlank()
                )
            }
            is AddEditPatientEvent.MobilityDescription -> {
                _mobilityDescription.value = mobilityDescription.value.copy(
                    text = event.description
                )
            }
            is AddEditPatientEvent.MobilityDescriptionChangeFocus -> {
                _mobilityDescription.value = mobilityDescription.value.copy(
                    isHintVisible = event.focusState.isFocused &&
                            mobilityDescription.value.text.isBlank()
                )
            }
        }
    }

    sealed class UiEvent {
        data class ShowSnackBar(val message: String) : UiEvent()
        object SaveNote : UiEvent()
    }
}