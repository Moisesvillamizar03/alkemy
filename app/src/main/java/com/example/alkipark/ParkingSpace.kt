package com.example.alkipa

import com.example.alkipark.Vehicle
import com.example.alkipark.VehicleType


import java.util.*
import javax.xml.datatype.DatatypeConstants.MINUTES
const val MINUTE_IN_MILISECONDS = 60000

open class ParkingSpace(val vehicles: MutableSet<Vehicle>){

    
    var less: Int = 0
    var earn :Int  =0
     fun checkOut(plate: String) : Int {

        val vehicle: Vehicle? = vehicles.find { it.plate == plate }
        vehicle?.let {
            val parkedTime: Long = (Calendar.getInstance().timeInMillis -
                    it.checkInTime.timeInMillis) / MINUTE_IN_MILISECONDS
            val fee = calculateFee(parkedTime, vehicle.type.fee, !vehicle.discountCard.isNullOrEmpty())
            onSuccess(fee)
            vehicles.remove(vehicle)                                                                                        //Llamar remove(vehicle )
            return fee
        } ?: run{
                onError()
           return -1
                }
    }

    fun calculateFee(parkedTime: Long, feeType: Int, hasDicountCard: Boolean): Int {

        var fee = 0
        var myParkedTime =
            parkedTime                                                              //Because we receive a fixed parameter, so we can´t modify it.
        val fragmentsTime: Int                                                      //???? No se porq no pude inicializarlo
        if (myParkedTime >= 120) {
            fee += feeType
            myParkedTime -= 120
            fragmentsTime = Math.ceil(myParkedTime.toDouble() / 15).toInt()
        } else {
            fragmentsTime = Math.ceil((parkedTime.toDouble() / 15))
                .toInt()                                                            //Math.ceil rounds a Double value to the next larger Int
        }
        fee += (fragmentsTime * 5)
        if (hasDicountCard) {
            fee = (fee.toDouble() * 0.85).toInt()                                   //????Dice descartar centavos, no redondear.
        }
        return fee
    }


    fun onSuccess(fee: Int){
        println("Your fee is $$fee. Come back soon.")
    }

    fun onError(){
        println("Sorry, the check-out failed.")
    }

 }
