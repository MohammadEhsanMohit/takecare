package com.mabgroup.takecare.common.utils

import androidx.compose.ui.graphics.toArgb
import com.mabgroup.takecare.ui.theme.BabyBlue
import com.mabgroup.takecare.ui.theme.RedPink
import com.mabgroup.takecare.ui.theme.Violet
import com.mabgroup.takecare.ui.theme.LightGreen
import com.mabgroup.takecare.ui.theme.RedOrange

val itemColors = listOf(RedOrange, LightGreen,Violet, BabyBlue, RedPink)
val itemRandomColor get() = itemColors.random().toArgb()