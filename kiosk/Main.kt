package com.brandon.kotlinpractices.kiosk

import com.brandon.kotlinpractices.kiosk.consts.ConstBurger.burgers
import com.brandon.kotlinpractices.kiosk.consts.ConstDrink.drinks
import com.brandon.kotlinpractices.kiosk.consts.ConstUser.user
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter


fun main() {
    // 유저 정보 (잔액: 랜덤)
    user

    while (true) {
        printMainMenu()
        when (readIntCommand()) {
            0    -> {   // exit
                println("프로그램이 종료됩니다..")
                break
            }

            1    -> {
                moveToBurgerMenu(burgers)
            }

            2    -> {
                moveToFrozenCustardMenu()
            }

            3    -> {
                moveToDrinkMenu(drinks)
            }

            4    -> {
                moveToBeerMenu()
            }

            5    -> {
                moveToOrderMenu(user)
            }

            6    -> {
                moveToCancelMenu()
            }

            7 -> {
//                moveToEventMenu()
            }
            8 -> {
//                moveToDeliveryOrderMenu()
            }

            else -> println("잘못된 입력입니다.(0~6)\n")
        }

    }
}


fun readIntCommand(): Int {
    print("입력: ")
    var command: Int = -1
    try {
        command = readlnOrNull()?.toInt() ?: -1
    } catch (e: Exception) {
        println("")
    }
    return command
}

fun moveToBurgerMenu(burgers: List<Product>) {
    printProductMenu(burgers)
    purchaseProduct(burgers)
}

fun moveToFrozenCustardMenu() {
    println("FrozenCustard Menu")
}

fun moveToDrinkMenu(drinks: List<Product>) {
    printProductMenu(drinks)
    purchaseProduct(drinks)
}

fun moveToBeerMenu() {
    println("Beer Menu")
}

fun moveToOrderMenu(user: User) {

    while (true) {
        var total: Double = 0.0

        println("아래와 같이 주문 하시겠습니까?")
        println("[  Order  ]")
        for (product in user.cart) {
            println(product.getProductInfo())
            total += product.getProductPrice()
        }
        println("\n[  Total  ]")
        println(String.format("W %.1f", total))

        println("1. 주문    2. 메뉴판")
        when (readIntCommand()) {
            1    -> {
                if (isServiceAvailableNow().not()) return
                val temp = user.balance - total
                if (temp >= 0) {
                    printProgressBar(3)
                    println(String.format("구매하였습니다. 잔액은 %.1f 입니다.\n", temp))
                    user.balance = temp
                    user.cart.clear()
                } else {
                    println(
                        String.format(
                            "구매총액은 %.1fW입니다. 현재 잔액은 %.1f 으로 %.1fW 만큼 잔액이 부족합니다.\n",
                            total,
                            user.balance,
                            temp
                        )
                    )
                }
            }

            2    -> {
                return
            }

            else -> println("잘못된 입력입니다.(1~2)\n")
        }
    }

}

fun moveToCancelMenu() {
    println("모든 장바구니의 상품을 비웁니다.")
    user.cart.clear()
}

fun printProgressBar(seconds: Int) {

    fun makeProgressBar(current: Int, total: Int, length: Int = 50) {
        val progress = (current.toDouble() / total.toDouble() * length).toInt()
        val progressBar = "[" + "█".repeat(progress) + "-".repeat(length - progress) + "]"
        val now = (current * 100 / total)
        print("\r$progressBar $now%")
    }


    println("결제가 진행중입니다.")
    val totalSteps = seconds * 10
    for (currentStep in 1..totalSteps) {
        makeProgressBar(currentStep, totalSteps)
        Thread.sleep(100)
    }

    println("\n결제가 완료되었습니다. (${getCurrentTime()})")
}

fun isServiceAvailableNow(): Boolean {
    // 은행 점검 시간 설정
    val yesterdayEndTime = LocalTime.of(23, 10)
    val tomorrowStartTime = LocalTime.of(2, 0)

    // 현재 시간이 점검 시간에 속하는지 확인
    if (isBetweenTimes(yesterdayEndTime, tomorrowStartTime)) {
        Thread.sleep(1000)
        println("은행 점검 시간 중입니다. 서비스 이용이 제한됩니다.")

        // 현재 시간 정보 얻기
        val currentTime = LocalTime.now()
        val hour = currentTime.hour
        val minute = currentTime.minute

        // 현재 시간 출력
        println("현재 시각은 ${if (hour < 12) "오전" else "오후"} $hour 시 $minute 분 입니다.")

        // 은행 점검 시간 안내
        println("은행 점검 시간은 ${yesterdayEndTime}부터 ${tomorrowStartTime}까지이며, 이 시간에는 결제할 수 없습니다.\n\n")

        return false
    } else {
        return true
    }

}


fun isBetweenTimes(startTime: LocalTime, endTime: LocalTime): Boolean {
    val currentTime = LocalTime.now()

    return if (endTime.isBefore(startTime)) {
        currentTime.isAfter(startTime) || currentTime.isBefore(endTime)
    } else {
        currentTime.isAfter(startTime) && currentTime.isBefore(endTime)
    }
}

fun getCurrentTime(): String {
    val currentDateTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    return currentDateTime.format(formatter)
}


private fun purchaseProduct(products: List<Product>) {
    while (true) {
        val command = readIntCommand()
        if (command == 0) return // back to Main Menu
        for ((i, product) in products.withIndex()) {
            if (i == (command - 1)) {
                println(product.getProductInfo())
                println("위 메뉴를 장바구니에 추가하시겠습니까?")
                println("1. 확인    2. 취소")
                if (readIntCommand() == 1) {    // 확인
                    user.cart.add(product)
                    println("${product.getProductName()} 가 장바구니에 추가되었습니다.\n\n")
                    return
                } else {    // 취소
                    println("구매를 취소합니다.\n")
                    printProductMenu(products)
                    break
                }
            }
        }
    }
}

private fun printProductMenu(products: List<Product>) {
    val productName = products.first().javaClass.superclass.simpleName

    println("[  $productName MENU  ]")
    for ((i, product) in products.withIndex()) {
        println("${i + 1}. ${product.getProductInfo()}")
    }
    println("0. Back            | 뒤로가기")
}

private fun printMainMenu() {
    println("----SHAKESHACK BURGER 에 오신 걸 환영합니다.----")
    println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n")

    println("[  SHAKESHACK MENU  ]")
    println("1. Burger         | 앵거스 비프 통살을 다져만든 버거")
    println("2. Frozen Custard | 매장에서 신선하게 만드는 아이스크림")
    println("3. Drink          | 매장에서 직접 만드는 음료")
    println("4. Beer           | 뉴욕 브루클린 브루어리에서 양조한 맥주")
    println("0. Exit           | 프로그램 종료")

    println("\n[  SHAKESHACK MENU  ]")
    println("5. Order          | 장바구니를 확인 후 주문합니다.")
    println("6. Cancel         | 진행중인 주문을 취소합니다.")

    println("\n[  EXTRA MENU  ]")
    println("7. Event          | 일정 금액 이상 구매 시 사용 가능한 쿠폰을 발급합니다.")
    println("6. Delivery Order | 자동 생성된 배달요청 목록을 확인합니다.")
}