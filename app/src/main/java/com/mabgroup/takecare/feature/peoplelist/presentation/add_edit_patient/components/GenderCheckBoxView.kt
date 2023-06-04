package com.mabgroup.takecare.feature.peoplelist.presentation.add_edit_patient.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.mabgroup.takecare.R
import com.mabgroup.takecare.common.utils.Gender
import com.mabgroup.takecare.ui.theme.BabyBlue


@Composable
fun KindRadioGroup(
    mItems: Array<Gender>,
    selected: Gender,
    setSelected: (selected: Gender) -> Unit,
) {
    val newSelected = remember {
        mutableStateOf(selected)
    }
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(id = R.string.gender_title),
            style = MaterialTheme.typography.titleSmall,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
                .padding(start = 8.dp,end=8.dp,top=8.dp, bottom = 8.dp))
            Row(
                modifier=Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                mItems.forEach { item ->
                    RadioButton(
                        modifier = Modifier.padding(start = 0.dp, end = 0.dp),
                        selected = newSelected.value == item,
                        onClick = {
                            newSelected.value = item
                            setSelected(item)
                        },
                        enabled = true,
                        colors = RadioButtonDefaults.colors(
                            selectedColor = BabyBlue
                        )
                    )
                    Text(text = item.toString(),
                        modifier = Modifier.padding(start = 0.dp,
                            end = 8.dp),
                        style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewOfGenderButtons() {
    KindRadioGroup(
        Gender.values() ,
        selected = Gender.FEMALE,
        setSelected ={ selected ->
        println(selected)
    } )
}