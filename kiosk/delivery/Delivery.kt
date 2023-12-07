package com.brandon.kotlinpractices.kiosk.delivery

import com.brandon.kotlinpractices.kiosk.consts.ConstDrink

class Delivery(
    val name: String,
    val price: Double,
    val latitude: Double,
    val longitude: Double
) {

    fun getDeliveryInfo(delivery: Delivery): String {
        return String.format("%s | %.2f | %.1f | %.1f", delivery.name, delivery.price, delivery.latitude, delivery.longitude)
    }
}
