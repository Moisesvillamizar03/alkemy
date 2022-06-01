package com.example.alkipark

import com.example.Parking
import java.text.SimpleDateFormat
import java.util.*

fun main(){

    val parking = Parking(mutableSetOf())                                                           //Here we instantiate the parking, who receive the vehicles set as a parameter.

//    val sdf = SimpleDateFormat("yyyy MMM dd HH:mm:ss")
    val newCalendar = Calendar.getInstance()
    newCalendar.set(Calendar.HOUR, 1)                                                               //This trick is only to set a Calendar with the hour: 1:00, just to test the fee calculation.

    parking.addVehicle(Vehicle("ABC123", VehicleType.Bus, newCalendar))                       //This is how we checkIn a vehicle (receive the plate, the type, the date and, if it exist, the discount card.)
    parking.addVehicle(Vehicle("XYZ323", VehicleType.Motorcycle, newCalendar))
    parking.addVehicle(Vehicle("CBD343", VehicleType.Bus, newCalendar, "DISCOUNT_003"))

    for (i in 1..23){                                                                               //This loop add 23 vehicles, just to test the cap of 20 parked vehicles max.
        parking.addVehicle(Vehicle(i.toString(), VehicleType.Car, Calendar.getInstance()))
    }

    parking.removeVehicle("ABC123")                                                           //Here we try to checkOut the same vehicle two times, just to test this verification.
    parking.removeVehicle("ABC123")
    parking.removeVehicle("XYZ323")                                                           //Here we checkOut another one

    parking.listVehicles()                                                                          //This is the list of parked vehicles.

    parking.getTotalEarnings()                                                                      //This show the total earnings and the total of withdrawn vehicles.
}