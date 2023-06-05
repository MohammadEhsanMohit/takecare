package com.mabgroup.takecare.feature.peoplelist.domain.util

sealed class PatientListOrder(val orderType: OrderType) {
    class Title(orderType: OrderType) : PatientListOrder(orderType)
    class Date(orderType: OrderType) : PatientListOrder(orderType)
    class Color(orderType: OrderType) : PatientListOrder(orderType)

    fun copy(orderType: OrderType) : PatientListOrder = when(this) {
        is Color -> Color(orderType)
        is Date -> Date(orderType)
        is Title -> Title(orderType)
    }
}
