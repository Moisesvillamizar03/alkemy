package com.example.alkipark

import com.example.alkipark.Parking
import com.example.alkipark.Vehicle
import com.example.alkipark.VehicleType
import java.util.*

fun main(){

    val auto = Vehicle("ABC123", VehicleType.Car, Calendar.getInstance(), "DISCOUNT_001")
    val moto = Vehicle("XYZ323", VehicleType.Motorcycle, Calendar.getInstance())
    val bus = Vehicle("ABC123", VehicleType.Bus, Calendar.getInstance(), "DISCOUNT_003")

    val parking = Parking(mutableSetOf(auto, moto, bus))

    println(parking.vehicles.contains(auto))
}