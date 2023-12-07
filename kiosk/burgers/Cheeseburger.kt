package com.brandon.kotlinpractices.kiosk.burgers

import com.brandon.kotlinpractices.kiosk.consts.ConstBurger

class Cheeseburger(
    private val name: String = ConstBurger.CHEESE_BURGER,
    private var price: Double = ConstBurger.CHEESE_BURGER_PRICE
) : Burger(name, price) {


    override fun getProductInfo(): String {
        return ConstBurger.CHEESE_BURGER_INFO
    }

    override fun getProductPrice(): Double {
        return price
    }

    override fun getProductName(): String {
        return ConstBurger.CHEESE_BURGER
    }
}