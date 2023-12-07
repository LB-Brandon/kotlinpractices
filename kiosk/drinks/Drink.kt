package com.brandon.kotlinpractices.kiosk.drinks

import com.brandon.kotlinpractices.kiosk.Product

abstract class Drink(name: String, price: Double) : Product(name, price){
    abstract override fun getProductName(): String
    abstract override fun getProductInfo(): String
    abstract override fun getProductPrice(): Double

}