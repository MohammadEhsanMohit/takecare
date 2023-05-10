package com.mabgroup.takecare.common.utils

enum class Gender {
    NON_BINARY,
    FEMALE,
    MALE;

    companion object {

        fun fromInt(dataCode: Int): Gender = when (dataCode) {
            1 -> FEMALE
            2 -> MALE
            else -> NON_BINARY
        }
    }

    override fun toString(): String {
        return when (this.ordinal) {
            NON_BINARY.ordinal -> "مشخص نشده"
            FEMALE.ordinal -> "خانم"
            MALE.ordinal -> "آقا"

            else -> "مشخص نشده"
        }
    }

}