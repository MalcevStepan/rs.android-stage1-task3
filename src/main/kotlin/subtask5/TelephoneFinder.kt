package subtask5

import java.lang.StringBuilder

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        for (i in number) if (i !in '0'..'9') return null
        val arr = arrayOf("8", "24", "135", "26", "157", "2468", "359", "48", "0759", "68")
        var res = emptyArray<String>()
        val tmp = StringBuilder()
        var index: Int
        for (i in number) {
            index = number.indexOf(i)
            for (k in arr[i - '0']) {
                for (j in 0 until index) tmp.append(number[j])
                tmp.append(k)
                if (index != (number.length - 1))
                    for (j in (number.indexOf(i) + 1) until number.length) tmp.append(number[j])
                res += tmp.toString()
                tmp.clear()
            }
        }
        return res
    }
}
