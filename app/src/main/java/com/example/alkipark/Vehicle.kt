package com.example.alkipark

import java.util.*

// We declared discountCard as a Nullable String type with a default value of null.
data class Vehicle(val plate: String, val type: VehicleType, val checkInTime: Calendar, val discountCard: String?=null ){

    override fun equals(other: Any?) : Boolean {                                                    //Override this Set method to search correctly.
        if (other is Vehicle) {
            return this.plate == other.plate
        }

        return super.equals(other)
    }

    override fun hashCode(): Int = this.plate.hashCode()                                            //Override this Set method to generate the proper Hashcode.

}
