package com.brandon.kotlinpractices.kiosk.product

abstract class Product(name: String, price: Double) {
    abstract fun getProductName(): String

    abstract fun getProductInfo(): String

    abstract fun getProductPrice(): Double


}