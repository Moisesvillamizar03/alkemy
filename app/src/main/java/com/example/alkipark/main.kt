package com.example.alkipark

import com.example.Parking
import java.util.*

fun main(){

    val auto = Vehicle("ABC123", VehicleType.Car, Calendar.getInstance(), "DISCOUNT_001")
    val moto = Vehicle("XYZ323", VehicleType.Motorcycle, Calendar.getInstance())
    val bus = Vehicle("CBD343", VehicleType.Bus, Calendar.getInstance(), "DISCOUNT_003")
    //println(bus)

    val parking = Parking(mutableSetOf())

    //println(parking.vehicles.contains(auto))

    val moto1 = Vehicle("ABC123", VehicleType.Bus, Calendar.getInstance(), "DISCOUNT_003")
    val isCar2Inserted = parking.vehicles.add(moto1)
    //println(parking.vehicles)
    //println(isCar2Inserted)

    for (i in 1..23){
        parking.addVehicle(Vehicle(i.toString(), VehicleType.Car, Calendar.getInstance()))
    }

    parking.removeVehicle("ABC123")
    parking.listVehicles()

    println(parking.earnings)
}