package com.example


import com.example.alkipa.ParkingSpace
import com.example.alkipark.Vehicle

const val maximumCapacity = 20

data class Parking(val parkingVehicles: MutableSet<Vehicle>): ParkingSpace(parkingVehicles) {
    var earnings = Pair(0,0)

    fun addVehicle(vehicle: Vehicle): Boolean{

        if (vehicles.size < maximumCapacity){

        val check = vehicles.add(vehicle)

        if(check)println("Welcome to AlkeParking!") else println("Sorry, the check-in failed")
        return check

        }else{
            println("Sorry, the check-in failed")
            return false
        }

    }

     fun removeVehicle(plate: String){                                                              //Beginning of the checkout
         val fee = ParkingSpace(vehicles).checkOut(plate)                                           //This call the checkout and receive the fee
         if(fee != -1){                                                                             //If the fee isn´t -1, seems that the checkout finished well.
             earnings = earnings.copy(first = earnings.first + fee)                                 //The total earning is updated.
             earnings = earnings.copy(second = earnings.second + 1)                                 //The total amount of withdrawn vehicles is updated.
         }
     }

    fun listVehicles(){                                                                             //List only the plate of the parked vehicles.
        println("Plates of parked vehicles: ")
        vehicles.toList().forEach { println(it.plate) }
    }

    fun getTotalEarnings(){
        println( "${earnings.second} vehicles have checked out and have earnings of $${earnings.first}")
    }

}
