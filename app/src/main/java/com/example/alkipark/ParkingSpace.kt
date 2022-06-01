package com.example.alkipa

import com.example.alkipark.Vehicle
import java.util.*
const val MINUTE_IN_MILISECONDS = 60000

open class ParkingSpace(val vehicles: MutableSet<Vehicle>){

    var parkedTime: Long = 0

     fun checkOut(plate: String) : Int {                                                            //Returns the fee, or -1 if the checkout failed

        val vehicle: Vehicle? = vehicles.find { it.plate == plate }                                 //We find for the car with the plate
        vehicle?.let {
            parkedTime = (Calendar.getInstance().timeInMillis -                                     //If the car is parked, this block runs
                    it.checkInTime.timeInMillis) / MINUTE_IN_MILISECONDS
           val fee = calculateFee(parkedTime, vehicle.type.fee, !vehicle.discountCard.isNullOrEmpty()) //Here we calculate the Fee
            onSuccess(fee)
            vehicles.remove(vehicle)                                                                //We remove the vehicle from the set
            return fee
        } ?: run{
            onError()                                                                               //If the car isn´t parked, this block would be runned.
            return -1
        }
    }

    fun calculateFee(parkedTime: Long, feeType: Int, hasDicountCard: Boolean): Int {                //Given those parameters, return the fee to be payed.

    var fee = 0
    var myParkedTime = parkedTime                                                                   //Because we receive a fixed parameter, so we can´t modify it.
    var fragmentsTime = 0
    myParkedTime -= 120
    if (myParkedTime > 0){
        fragmentsTime = Math.ceil(myParkedTime.toDouble() / 15).toInt()                             //Math.ceil rounds a Double value to the next larger Int
    }
    fee += feeType
    fee += (fragmentsTime * 5)
    if (hasDicountCard) {
        fee = (fee.toDouble() * 0.85).toInt()                                                       //We round the value.
    }
    return fee
}

    fun onSuccess(fee: Int){                                                                        //Called if the checkOut is done correctly
        println("Your fee is $$fee. Come back soon.")
    }

    fun onError(){
        println("Sorry, the check-out failed.")                                                     //Called if the checkOut fail.
    }

 }
