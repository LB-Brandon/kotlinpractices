package com.brandon.kotlinpractices.kiosk.burgers

import com.brandon.kotlinpractices.kiosk.product.Product

abstract class Burger(name: String, price: Double) : Product(name, price) {
    abstract override fun getProductName(): String
    abstract override fun getProductInfo(): String
    abstract override fun getProductPrice(): Double

}