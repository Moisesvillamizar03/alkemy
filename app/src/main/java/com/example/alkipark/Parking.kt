package com.example.alkipark

const val maximumCapacity = 20

data class Parking(val vehicles: MutableSet<Vehicle>){

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

}
