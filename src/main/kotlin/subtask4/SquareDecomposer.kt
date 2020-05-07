package subtask4

import kotlin.math.pow
import kotlin.math.sqrt

class SquareDecomposer {
    fun decomposeNumber(number: Int): Array<Int>? {
        return decompose(number.toDouble().pow(2.0), number - 1)
    }

    private fun decompose(value: Double, number: Int): Array<Int>? {
        for (i in number downTo 1) {
            val diff = value - i.toDouble().pow(2.0)
            when {
                diff == 0.0 -> return arrayOf(i)
                diff < 0.0 -> return null
            }
            val s = sqrt(diff).toInt()
            val res = decompose(diff, if (s >= i) i - 1 else s)
            if (res != null) return res + arrayOf(i)
        }
        return null
    }
}