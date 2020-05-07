package subtask1

import java.lang.StringBuilder
import kotlin.math.abs

class PolynomialConverter {
    fun convertToStringFrom(numbers: Array<Int>): String? {
        if (numbers.isEmpty()) return null
        val str = StringBuilder()
        val size = numbers.size - 1
        if (numbers[0] != 0) str.append(if (numbers[0] < 0) "-" else "" + numbers[0].toString() + "x" + if (size > 1) "^${size} " else " ")
        for (i in 1..size)
            if (numbers[i] != 0)
                str.append(
                    if (numbers[i] > 0) {
                        "+ "
                    } else {
                        "- "
                    }
                            + if (abs(numbers[i]) != 1) {
                        abs(numbers[i]).toString()
                    } else {
                        ""
                    }
                            + if (i != size) {
                        "x" + if (i != size - 1) "^${size - i} " else " "
                    } else ""
                )
        print(str)
        return str.toString()
    }
}
