package com.brandon.kotlinpractices.kiosk.drinks

import com.brandon.kotlinpractices.kiosk.consts.ConstDrink.COCACOLA
import com.brandon.kotlinpractices.kiosk.consts.ConstDrink.COCACOLA_INFO
import com.brandon.kotlinpractices.kiosk.consts.ConstDrink.COCACOLA_PRICE

class CocaCola(
    private val name: String = COCACOLA,
    private val price: Double = COCACOLA_PRICE
) : Drink(name, price) {
    override fun getProductName(): String {
        return COCACOLA
    }

    override fun getProductInfo(): String {
        return COCACOLA_INFO
    }
    override fun getProductPrice(): Double {
        return price
    }
}