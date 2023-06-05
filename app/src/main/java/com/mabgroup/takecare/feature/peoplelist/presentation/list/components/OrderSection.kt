 package com.mabgroup.takecare.feature.peoplelist.presentation.list.components

 import androidx.compose.foundation.layout.Column
 import androidx.compose.foundation.layout.Row
 import androidx.compose.foundation.layout.Spacer
 import androidx.compose.foundation.layout.fillMaxWidth
 import androidx.compose.foundation.layout.height
 import androidx.compose.foundation.layout.width
 import androidx.compose.runtime.Composable
 import androidx.compose.ui.Modifier
 import androidx.compose.ui.res.dimensionResource
 import androidx.compose.ui.res.stringResource
 import com.mabgroup.takecare.R
 import com.mabgroup.takecare.feature.peoplelist.domain.util.OrderType
 import com.mabgroup.takecare.feature.peoplelist.domain.util.PatientListOrder


 @Composable
fun OrderSection(
     modifier: Modifier,
     dataOrder: PatientListOrder = PatientListOrder.Date(orderType = OrderType.Descending),
     onOrderChange: (PatientListOrder) -> Unit
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(text = stringResource(id = R.string.note_order_title),
                selected = dataOrder is PatientListOrder.Title,
                onSelect = { onOrderChange(PatientListOrder.Title(dataOrder.orderType)) })
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.space_small)))
            DefaultRadioButton(text = stringResource(id = R.string.note_order_date),
                selected = dataOrder is PatientListOrder.Date,
                onSelect = { onOrderChange(PatientListOrder.Date(dataOrder.orderType)) })
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.space_small)))
            DefaultRadioButton(text = stringResource(id = R.string.note_order_color),
                selected = dataOrder is PatientListOrder.Color,
                onSelect = { onOrderChange(PatientListOrder.Color(dataOrder.orderType)) })
        }
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_medium)))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(text = stringResource(id = R.string.note_order_type_Ascending),
                selected = dataOrder.orderType is OrderType.Ascending,
                onSelect = {
                    onOrderChange(dataOrder.copy(OrderType.Ascending))
                })
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.space_small)))
            DefaultRadioButton(text = stringResource(id = R.string.note_order_type_descending),
                selected = dataOrder.orderType is OrderType.Descending,
                onSelect = {
                    onOrderChange(dataOrder.copy(OrderType.Descending))
                })
        }
    }
}