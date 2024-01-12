import java.math.BigInteger

/**
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 *
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 */

fun main() {
    fun plusOne(digits: IntArray): IntArray {
        var s = ""
        digits.forEach { d -> s = s.plus(d.toString()) }
        val n = s.toBigInteger().plus(BigInteger.ONE)
        var result = intArrayOf()
        n.toString().forEach { r -> result += r.toString().toInt() }
        return result
    }

    fun optimizedSolution(digits: IntArray): IntArray {
        for(i in digits.indices.reversed()){
            if(digits[i]<9){
                digits[i] = digits[i] + 1
                return digits
            } else {
                digits[i] = 0
            }
        }

        val newDigits = IntArray(digits.size+1)
        newDigits[0] = 1

        return newDigits
    }

//    plusOne(intArrayOf(9)).forEach { i -> println(i) }
//    plusOne(intArrayOf(4,3,2,1)).forEach { i -> println(i) }
//    plusOne(intArrayOf(9,8,7,6,5,4,3,2,1,0)).forEach { i -> println(i) }
      optimizedSolution(intArrayOf(9,8,7,6,5,4,3,2,1,0)).forEach { i -> println(i) }
    optimizedSolution(intArrayOf(9)).forEach { i -> println(i) }
}