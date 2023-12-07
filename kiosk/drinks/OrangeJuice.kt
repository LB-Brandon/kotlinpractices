package com.brandon.kotlinpractices.kiosk.drinks

import com.brandon.kotlinpractices.kiosk.consts.ConstDrink.ORANGEJUICE
import com.brandon.kotlinpractices.kiosk.consts.ConstDrink.ORANGEJUICE_INFO
import com.brandon.kotlinpractices.kiosk.consts.ConstDrink.ORANGEJUICE_PRICE

class OrangeJuice(
    private val name: String = ORANGEJUICE,
    private val price: Double = ORANGEJUICE_PRICE
) : Drink(name, price) {
    override fun getProductName(): String {
        return ORANGEJUICE
    }

    override fun getProductInfo(): String {
        return ORANGEJUICE_INFO
    }
    override fun getProductPrice(): Double {
        return price
    }
}