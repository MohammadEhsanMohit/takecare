package com.mabgroup.takecare.feature.peoplelist.presentation.add_edit_patient

import android.annotation.SuppressLint
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composeapplication.feature.note.presentation.add_edit_note.components.TransparentHintTextField
import com.mabgroup.takecare.common.utils.Gender
import com.mabgroup.takecare.common.utils.itemColors
import com.mabgroup.takecare.common.utils.itemRandomColor
import com.mabgroup.takecare.feature.peoplelist.domain.model.Patient
import com.mabgroup.takecare.feature.peoplelist.presentation.add_edit_patient.components.KindRadioGroup
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditNoteScreen(
    navController: NavController,
    noteColor: Int,
    viewModel: AddEditPatientViewModel = koinViewModel()
) {
    val titleState = viewModel.patientFirstName.value
    val contentState = viewModel.patientFamily.value
    val gender = viewModel.patientGender.value

    val scaffoldState = remember { SnackbarHostState() }

    val noteBackgroundAnimatable = remember {
        Animatable(
            Color(if (noteColor != -1) noteColor else viewModel.patientColor.value)
        )
    }
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when(event) {
                is AddEditPatientViewModel.UiEvent.ShowSnackBar -> {
                    scaffoldState.showSnackbar(
                        message = event.message
                    )
                }
                is AddEditPatientViewModel.UiEvent.SaveNote -> {
                    navController.navigateUp()
                }
            }
        }
    }


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.onEvent(AddEditPatientEvent.SavePatient)
                },
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Save Note"
                )
            }
        },
        snackbarHost = { SnackbarHost(scaffoldState) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(noteBackgroundAnimatable.value)
                .padding(16.dp)
        ) {
            Row(modifier =
            Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(noteBackgroundAnimatable.value)
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        itemColors.forEach { color ->
                            val colorInt = color.toArgb()
                            Box(
                                modifier = Modifier
                                    .size(50.dp)
                                    .shadow(15.dp, CircleShape)
                                    .clip(CircleShape)
                                    .background(color)
                                    .border(
                                        width = 3.dp,
                                        color = if (viewModel.patientColor.value == colorInt) {
                                            Color.Black
                                        } else Color.Transparent,
                                        shape = CircleShape
                                    )
                                    .clickable {
                                        scope.launch {
                                            noteBackgroundAnimatable.animateTo(
                                                targetValue = Color(colorInt),
                                                animationSpec = tween(
                                                    durationMillis = 500
                                                )
                                            )
                                        }
                                        viewModel.onEvent(AddEditPatientEvent.ChangeGender(colorInt))
                                    }
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    TransparentHintTextField(
                        text = titleState.text,
                        hint = stringResource(id = titleState.hint),
                        onValueChange = {
                            viewModel.onEvent(AddEditPatientEvent.EnteredFirstName(it))
                        },
                        onFocusChange = {
                            viewModel.onEvent(AddEditPatientEvent.ChangeFirstNameFocus(it))
                        },
                        isHintVisible = titleState.isHintVisible,
                        singleLine = true,
                        textStyle = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    TransparentHintTextField(
                        text = contentState.text,
                        hint = stringResource(id = contentState.hint),
                        onValueChange = {
                            viewModel.onEvent(AddEditPatientEvent.EnteredLastName(it))
                        },
                        onFocusChange = {
                            viewModel.onEvent(AddEditPatientEvent.ChangeLastNameFocus(it))
                        },
                        isHintVisible = contentState.isHintVisible,
                        textStyle = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.fillMaxHeight()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    KindRadioGroup(mItems = Gender.values(), selected = gender, setSelected = { selected -> viewModel.onEvent(AddEditPatientEvent.ChangeGender(selected.ordinal)) })
                }
            }
        }
    }
}