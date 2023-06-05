package com.mabgroup.takecare.feature.peoplelist.domain.util

sealed class OrderType {
    object Ascending : OrderType()
    object Descending : OrderType()
}
