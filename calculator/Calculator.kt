abstract class AbstractOperation {
    abstract fun operate(a: Int, b: Int): Double
}

class AddOperation() : AbstractOperation() {
    override fun operate(a: Int, b: Int): Double {
        return (a + b).toDouble()
    }
}

class SubtractOperation() : AbstractOperation() {
    override fun operate(a: Int, b: Int): Double {
        return (a - b).toDouble()
    }
}

class MultiplyOperation() : AbstractOperation() {
    override fun operate(a: Int, b: Int): Double {
        return (a * b).toDouble()
    }
}

class DivideOperation() : AbstractOperation() {
    override fun operate(a: Int, b: Int): Double {
        return (a / b).toDouble()
    }
}

class Calculator(private val operation: AbstractOperation) {
    fun operate(num1:Int, num2: Int): Double {
        return operation.operate(num1, num2)
    }
}

fun main() {
    val addCalc = Calculator(AddOperation()).operate(1, 3)  // 4
    val subtractCalc = Calculator(SubtractOperation()).operate(5, 3)    // 2
    val multiplyCalc = Calculator(MultiplyOperation()).operate(2, 5)    // 10
    val divideCalc = Calculator(DivideOperation()).operate(10, 5)   // 2

    println("add: $addCalc, sub: $subtractCalc, multi: $multiplyCalc, div: $divideCalc")
}