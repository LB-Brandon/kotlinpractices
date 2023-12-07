import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.random.Random

class CustomException(message: String) : Exception(message)
class Time(var year: Int, var month: Int, var day: Int)

data class Guest(
    var name: String,
    var roomNumber: Int,
    var checkIn: LocalDate,
    var checkOut: LocalDate,
    var price: Int,
    var deposit: Int
)

fun isBookingDateInRange(targetDate: LocalDate, startDate: LocalDate, endDate: LocalDate): Boolean {
    val isAfter = (targetDate.isEqual(startDate) || targetDate.isAfter(startDate))
    val isBefore = (targetDate.isBefore(endDate))
    return isAfter && isBefore
}


// currentTime

fun main() {
    val currentDate = LocalDate.now()
    val curYear = currentDate.year
    val curMonth = currentDate.month.value
    val curDay = currentDate.dayOfMonth

    val guestDB = mutableListOf<Guest>()

    while (true) {
        println("호텔예약 프로그램입니다.")
        println("[메뉴]")
        println("1. 방예약, 2. 예약목록 출력, 3. 예약목록 (정렬) 출력, 4. 시스템 종료, 5. 금액 입금-출금 내역 목록 출력, 6. 예약 변경/취소")

        val command: Int = readlnOrNull()?.toInt() ?: 0

        var name: String?
        var roomNumber: Int?
        var checkInTime: String?
        var checkOutTime: String?


        var checkInYear: Int
        var checkInMonth: Int
        var checkInDay: Int
        var checkInDate: LocalDate


        var checkOutYear: Int
        var checkOutMonth: Int
        var checkOutDay: Int
        var checkOutDate: LocalDate



        when (command) {
            1 -> {
                // 1. 예약자 성함 입력
                println("예약자분의 성함을 입력해주세요")
                name = readlnOrNull()

                // 2. 예약자 방 번호 입력
                while (true) {
                    try {
                        println("예약할 방번호를 입력해주세요")
                        val tmp = readlnOrNull()?.toInt()
                        if (tmp in (100..999)) {
                            roomNumber = tmp
                            break
                        } else {
                            throw CustomException("올바르지 않은 방번호 입니다. 방번호는 100~999 영역 이내입니다.")
                        }
                    } catch (error: Exception) {
                        println("\u001B[31m$error\u001B[0m")
                    }
                }

                // 3. 체크인 날짜 입력
                while (true) {
                    try {
                        println(
                            "체크인 날짜를 입력해주세요. 표기형식. ${
                                currentDate.format(
                                    DateTimeFormatter.ofPattern(
                                        "yyyyMMdd"
                                    )
                                )
                            }"
                        )
                        checkInTime = readlnOrNull() ?: ""

                        if (checkInTime.length != 8) continue
                        checkInYear = checkInTime.slice(0..3).toInt()
                        checkInMonth = checkInTime.slice(4..5).toInt()
                        checkInDay = checkInTime.slice(6..7).toInt()

                        checkInDate = LocalDate.of(checkInYear, checkInMonth, checkInDay)

                        // 기간 내 예약 확인
                        for (booking in guestDB) {
                            if (booking.roomNumber == roomNumber) {
                                val flag = isBookingDateInRange(
                                    checkInDate, booking.checkIn, booking.checkOut
                                )
                                if (flag) {
                                    throw CustomException("해당 날짜에 이미 방을 사용중입니다. 다른 날짜를 입력해주세요.")
                                }
                            }
                        }

                        if (checkInYear > curYear || checkInYear == curYear && checkInMonth > curMonth || checkInYear == curYear && checkInMonth == curMonth && checkInDay >= curDay) {
                            break
                        } else {
                            throw CustomException("체크인 날짜는 지난 날을 선택할 수 없습니다.")
                        }
                    } catch (error: java.time.DateTimeException) {
                        println("유효하지 않은 날짜입니다.")
                    } catch (error: Exception) {
                        println("\u001B[31m$error\u001B[0m")
                    }
                }
                // 4. 체크아웃 날짜 입력
                while (true) {
                    try {
                        println(
                            "체크아웃 날짜를 입력해주세요. 표기형식. ${
                                currentDate.format(
                                    DateTimeFormatter.ofPattern(
                                        "yyyyMMdd"
                                    )
                                )
                            }"
                        )
                        checkOutTime = readlnOrNull() ?: ""

                        if (checkOutTime.length != 8) continue
                        checkOutYear = checkOutTime.slice(0..3).toInt()
                        checkOutMonth = checkOutTime.slice(4..5).toInt()
                        checkOutDay = checkOutTime.slice(6..7).toInt()

                        checkOutDate = LocalDate.of(checkOutYear, checkOutMonth, checkOutDay)


                        if (checkOutYear > checkInYear || checkOutYear == checkInYear && checkOutMonth > checkInMonth || checkOutYear == checkInYear && checkOutMonth == checkInMonth && checkOutDay > checkInDay) {
                            break
                        } else {
                            throw CustomException("체크인 날짜는 체크아웃 날짜 이후여야 합니다.")
                        }
                    } catch (error: java.time.DateTimeException) {
                        println("유효하지 않은 날짜입니다.")
                    } catch (error: Exception) {
                        println("\u001B[31m$error\u001B[0m")
                    }
                }
                // 5. 호텔 예약 완료


                val price = Random.nextInt(10000, 100000)
                val deposit = (price * 0.3).toInt()
                guestDB.add(
                    Guest(
                        name!!, roomNumber!!, checkInDate, checkOutDate, price, deposit
                    )
                )

                println("호텔 예약이 완료되었습니다.")
            }

            2 -> {
                for ((i, g) in guestDB.withIndex()) {
                    println("${i + 1}. 사용자: ${g.name}, 방번호: ${g.roomNumber}호, 체크인: ${g.checkIn}, 체크아웃: ${g.checkOut}")
                }
            }

            3 -> {
                val sortedGuestList = guestDB.sortedBy { it.checkIn }
                for ((i, g) in sortedGuestList.withIndex()) {
                    println("${i + 1}. 사용자: ${g.name}, 방번호: ${g.roomNumber}호, 체크인: ${g.checkIn}, 체크아웃: ${g.checkOut}")
                }
            }

            4 -> {
                println("프로그램을 종료합니다.")
                break
            }

            5 -> {
                println("조회하실 사용자 이름을 입력하세요")
                val userName: String = readlnOrNull() ?: ""
                for (user in guestDB) {
                    if (user.name == userName) {
                        // Todo: 금액 변경
                        println("1. 초기 금액으로 ${user.price} 원 입금되었습니다.")
                        println("2. 예약금으로 ${user.deposit} 원 출금되었습니다.")
                    }
                }

            }

            6 -> {
                try {
                    println("예약을 변경할 사용자 이름을 입력하세요")
                    val userName: String = readlnOrNull() ?: ""
                    val bookingList = mutableListOf<Guest>()
                    for (guest in guestDB) {
                        if (guest.name == userName) {
                            bookingList.add(guest)
                        }
                    }
                    if (bookingList.isNotEmpty()) {
                        while (true) {
                            println("${userName}님이 예약한 목록입니다. 변경하실 예약번호를 입력해주세요 (탈출은 exit 입력)")
                            for ((i, g) in bookingList.withIndex()) {
                                println("${i + 1}. 방 번호: ${g.roomNumber}호, 체크인: ${g.checkIn}, 체크아웃: ${g.checkOut}")
                            }
                            val editCommand = readlnOrNull() ?: ""
                            if (editCommand == "exit") break

                            val selectedBookingNumber = editCommand?.toInt() ?: -1
                            if (!(selectedBookingNumber in 0..bookingList.size)) {
                                throw CustomException("범위에 없는 예약번호 입니다.")
                            }
                            println("해당 예약을 어떻게 하시겠어요? 1. 변경 2. 취소 / 이외 번호. 메뉴로 돌아가기")
                            val selectCommand = readlnOrNull()?.toInt() ?: -1
                            if (!(selectCommand in 1..2)) break
                            when (selectCommand) {
                                1 -> {
                                    // 변경
                                }

                                2 -> {
                                    // 취소
                                    println("[취소 유의사항]")
                                    println("체크인 3일 이전 취소 예약금 환불 불가")
                                    println("체크인 5일 이전 취소 예약금 30% 환불")
                                    println("체크인 7일 이전 취소 예약금 50% 환불")
                                    println("체크인 14일 이전 취소 예약금 80% 환불")
                                    println("체크인 30일 이전 취소 예약금 100% 환불")

                                    println("-------------------------------")
                                    val daysDifference =
                                        currentDate.until(bookingList[selectedBookingNumber - 1].checkIn).days
                                    println("체크인까지 $daysDifference 일 남았습니다")
                                    // 기간 별 보증금 가산 로직 (생략)
                                    guestDB.remove(bookingList[selectedBookingNumber - 1])
                                    bookingList.removeAt(selectedBookingNumber - 1)
                                    println("취소가 완료되었습니다")
                                }
                            }
                        }
                    } else {
                        throw CustomException("사용자 이름으로 예약된 목록을 찾을 수 없습니다.")
                    }
                } catch (error: Exception) {
                    println("\u001B[31m$error\u001B[0m")
                }
            }

            else -> {
                println("유효하지 않은 메뉴입니다. 다시 입력해주세요")
            }
        }
    }
}


