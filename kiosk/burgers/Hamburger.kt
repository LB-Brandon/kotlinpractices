package com.brandon.kotlinpractices.kiosk.burgers

import com.brandon.kotlinpractices.kiosk.consts.ConstBurger

class Hamburger(
    private val name: String = ConstBurger.HAM_BURGER,
    private var price: Double = ConstBurger.HAM_BURGER_PRICE
) :
    Burger(name, price) {
    override fun getProductInfo(): String {
        return ConstBurger.HAM_BURGER_INFO
    }

    override fun getProductName(): String {
        return ConstBurger.HAM_BURGER
    }
    override fun getProductPrice(): Double {
        return price
    }
}