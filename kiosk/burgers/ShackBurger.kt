package com.brandon.kotlinpractices.kiosk.burgers

import com.brandon.kotlinpractices.kiosk.consts.ConstBurger

class ShackBurger(private val name: String = ConstBurger.SHACK_BURGER, private var price: Double = ConstBurger.SHACK_BURGER_PRICE) :
    Burger(name, price) {

    override fun getProductInfo(): String {
        return ConstBurger.SHACK_BURGER_INFO
    }

    override fun getProductName(): String {
        return ConstBurger.SHACK_BURGER
    }
    override fun getProductPrice(): Double {
        return price
    }
}