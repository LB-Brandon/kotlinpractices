package com.brandon.kotlinpractices.kiosk.consts


import com.brandon.kotlinpractices.kiosk.Product
import com.brandon.kotlinpractices.kiosk.drinks.CocaCola
import com.brandon.kotlinpractices.kiosk.drinks.Drink
import com.brandon.kotlinpractices.kiosk.drinks.OrangeJuice
import com.brandon.kotlinpractices.kiosk.drinks.Water

object ConstDrink {

    // Instance
    val drinks = listOf<Product>(
        Water(),        // 1
        CocaCola(),     // 2
        OrangeJuice()   // 3
    )

    // Name
    const val WATER: String = "Water"
    const val COCACOLA: String = "Coca Cola"
    const val ORANGEJUICE: String = "Orange Juice"

    // Price
    const val WATER_PRICE: Double = 1.3
    const val COCACOLA_PRICE: Double = 2.0
    const val ORANGEJUICE_PRICE: Double = 1.8

    // Info
    const val WATER_INFO =
        "$WATER         | W $WATER_PRICE | 시원한 물"
    const val COCACOLA_INFO =
        "$COCACOLA      | W $COCACOLA_PRICE | 달달한 콜라"
    const val ORANGEJUICE_INFO =
        "$ORANGEJUICE   | W $ORANGEJUICE_PRICE | 새콤한 오렌지 주스"

}
