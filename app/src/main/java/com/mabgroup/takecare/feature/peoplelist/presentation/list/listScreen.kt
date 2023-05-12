

package com.mabgroup.takecare.feature.peoplelist.presentation.list

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mabgroup.takecare.R
import com.mabgroup.takecare.feature.peoplelist.presentation.list.components.PeopleListItemView
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientListScreen(
    navController: NavController,
    viewModel: PatientListViewModel = koinViewModel()
) {
    val stateData = viewModel.state.value
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { println("Add Clicked") },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Patient"
                )
            }
        },
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) }
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(stateData) {patient ->
                    PeopleListItemView(
                        patient = patient,
                        modifier = Modifier.fillMaxWidth()
                            .clickable {  },
                        onDeleteClick = {}
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_medium)))
                }
            }
        }
    }
}