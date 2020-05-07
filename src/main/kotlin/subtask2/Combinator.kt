package subtask2

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        val f = fac(array[1].toLong())
        for (i in 0..array[1])
            if (f / ((fac((array[1] - i).toLong())) * fac(i.toLong())) == array[0].toLong()) return i
        return null
    }

    private fun fac(x: Long): Long {
        return if (x == 1L || x == 0L) 1 else fac(x - 1) * x
    }
}
