package com.brandon.kotlinpractices.kiosk.burgers

import com.brandon.kotlinpractices.kiosk.consts.ConstBurger

class ShroomBurger(
    private val name: String = ConstBurger.SHROOM_BURGER,
    private var price: Double = ConstBurger.SHROOM_BURGER_PRICE
) : Burger(name, price) {

    override fun getProductInfo(): String {
        return ConstBurger.SHROOM_BURGER_INFO
    }

    override fun getProductName(): String {
        return ConstBurger.SHROOM_BURGER
    }
    override fun getProductPrice(): Double {
        return price
    }
}