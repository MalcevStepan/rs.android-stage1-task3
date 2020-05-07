package subtask3

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        var arr = itemsFromArray.filterIsInstance<Int>()
        var mul = 1
        var num = numberOfItems
        if (numberOfItems >= arr.size && arr.isNotEmpty()) {
            for (i in arr) mul *= i
            return mul
        } else if (arr.isEmpty()) return 0
        var neg = arr.filter { it < 0 }
        var pos = arr.filter { it > 0 }
        neg = neg.sorted()
        pos = pos.sortedDescending()
        var i = 0
        var k = 0
        var mul1: Int
        var mul2: Int
        if (neg.size == 1) {
            for (j in 0 until num) mul *= pos[j]
            return mul
        }
        while (num > 0) {
            if ((k + 1) == neg.size) {
                for (j in i until (i + num)) mul *= pos[j]
                return mul
            }
            if (num >= 2) {
                mul1 = pos[i] * pos[i + 1]
                mul2 = neg[k] * neg[k + 1]
                if (num == numberOfItems)
                    if (mul1 > mul2) {
                        mul = mul1
                        i += 2
                    } else {
                        mul = mul2
                        k += 2
                    }
                else
                    if (mul1 > mul2) {
                        mul *= mul1
                        i += 2
                    } else {
                        mul *= mul2
                        k += 2
                    }
                num -= 2
                if (num == 0) return mul
            } else if (num == 1) {
                mul *= pos[i]
                return mul
            }
        }
        return 0
    }
}
