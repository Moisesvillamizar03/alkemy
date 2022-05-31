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

     fun removeVehicle(plate: String){
         val fee = ParkingSpace(vehicles).checkOut(plate)
         if(fee != -1){
             earnings = earnings.copy(first = earnings.first + fee)
             earnings = earnings.copy(second = earnings.second + 1)
         }
     }

    fun listVehicles(){
        println("Plates of parked vehicles: ")
        vehicles.toList().forEach { println(it.plate) }
    }


}
