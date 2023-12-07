package com.brandon.kotlinpractices.kiosk.burgers

import com.brandon.kotlinpractices.kiosk.consts.ConstBurger

class SmokeShack(
    private val name: String = ConstBurger.SMOKESHACK,
    private var price: Double = ConstBurger.SMOKESHACK_PRICE
) :
    Burger(name, price) {

    override fun getProductInfo(): String {
        return ConstBurger.SMOKESHACK_INFO
    }

    override fun getProductName(): String {
        return ConstBurger.SMOKESHACK
    }
    override fun getProductPrice(): Double {
        return price
    }
}