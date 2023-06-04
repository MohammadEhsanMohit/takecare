package com.mabgroup.takecare.feature.peoplelist.domain.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.mabgroup.takecare.common.utils.Gender

@Entity
data class Patient(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val firstName: String,
    val lastName: String,
    @TypeConverters(GenderTypeConverts::class)
    val gender: Gender,
    val hasMobility: Boolean,
    val mobilityDescription: String = "",
    val hasSpeak: Boolean,
    val communicationDescription: String = "",
    val needCompanion24: Boolean,
    val healthSummery: String = ""
) {
    @get:Ignore
    val fullname : String get() = "$firstName $lastName"
}

class GenderTypeConverts() {

    @TypeConverter
    fun toInt(gender: Gender): Int = gender.ordinal

    @TypeConverter
    fun fromInt(dataCode: Int): Gender = Gender.fromInt(dataCode)

}