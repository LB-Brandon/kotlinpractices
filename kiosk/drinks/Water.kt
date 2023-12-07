package com.brandon.kotlinpractices.kiosk.drinks

import com.brandon.kotlinpractices.kiosk.consts.ConstDrink.WATER
import com.brandon.kotlinpractices.kiosk.consts.ConstDrink.WATER_INFO
import com.brandon.kotlinpractices.kiosk.consts.ConstDrink.WATER_PRICE

class Water(
    private val name: String = WATER,
    private val price: Double = WATER_PRICE
) : Drink(name, price){
    override fun getProductName(): String {
        return WATER
    }

    override fun getProductInfo(): String {
        return WATER_INFO
    }
    override fun getProductPrice(): Double {
        return price
    }
}