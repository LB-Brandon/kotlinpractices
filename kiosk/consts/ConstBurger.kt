package com.brandon.kotlinpractices.kiosk.consts


import com.brandon.kotlinpractices.kiosk.Product
import com.brandon.kotlinpractices.kiosk.burgers.Burger
import com.brandon.kotlinpractices.kiosk.burgers.Cheeseburger
import com.brandon.kotlinpractices.kiosk.burgers.Hamburger
import com.brandon.kotlinpractices.kiosk.burgers.ShackBurger
import com.brandon.kotlinpractices.kiosk.burgers.ShroomBurger
import com.brandon.kotlinpractices.kiosk.burgers.SmokeShack

object ConstBurger {

    // Instance
    val burgers = listOf<Product>(
        ShackBurger(),  // 1
        SmokeShack(),   // 2
        ShroomBurger(), // 3
        Cheeseburger(), // 4
        Hamburger()     // 5
    )

    // Name
    const val SHACK_BURGER: String = "ShackBurger"
    const val SMOKESHACK: String = "SmokeShack"
    const val SHROOM_BURGER: String = "Shroom Burger"
    const val CHEESE_BURGER: String = "Cheeseburger"
    const val HAM_BURGER: String = "Hamburger"

    // Price
    const val SHACK_BURGER_PRICE: Double = 6.9
    const val SMOKESHACK_PRICE: Double = 8.9
    const val SHROOM_BURGER_PRICE: Double = 9.4
    const val CHEESE_BURGER_PRICE: Double = 6.9
    const val HAM_BURGER_PRICE: Double = 5.4

    // Info
    const val SHACK_BURGER_INFO =
        "$SHACK_BURGER     | W $SHACK_BURGER_PRICE | 토마토, 양상추, 쉑소스가 토핑된 치즈버거"
    const val SMOKESHACK_INFO =
        "$SMOKESHACK      | W $SMOKESHACK_PRICE | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"
    const val SHROOM_BURGER_INFO =
        "$SHROOM_BURGER   | W $SHROOM_BURGER_PRICE | 몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"
    const val CHEESE_BURGER_INFO =
        "$CHEESE_BURGER    | W $CHEESE_BURGER_PRICE | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"
    const val HAM_BURGER_INFO =
        "$HAM_BURGER       | W $HAM_BURGER_PRICE | 비프패티를 기반으로 야채가 들어간 기본버거"

}
