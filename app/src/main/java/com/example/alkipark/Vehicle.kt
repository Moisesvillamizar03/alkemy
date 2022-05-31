package com.example.alkipark

import java.util.*
import javax.xml.datatype.DatatypeConstants.MINUTES

const val MINUTE_IN_MILISECONDS = 60000

// We declared discountCard as a Nullable String type with a default value of null.
data class Vehicle(val plate: String, val type: VehicleType, val checkInTime: Calendar, val discountCard: String?=null ){


    override fun equals(other: Any?) : Boolean {
        if (other is Vehicle) {
            return this.plate == other.plate
        }

        return super.equals(other)
    }

    override fun hashCode(): Int = this.plate.hashCode()


val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis) / MINUTE_IN_MILISECONDS
}
