package com.brandon.kotlinpractices.kiosk.user

import com.brandon.kotlinpractices.kiosk.product.Product
import kotlin.random.Random

class User(){
    var balance: Double = Random.nextDouble(10.0, 20.0)
    var cart: MutableList<Product> = mutableListOf()
    var coupon: Boolean = false
    init{
        println(String.format("사용자 정보 임의 생성. 잔액: %.2f", balance))
    }


}
