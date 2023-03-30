package sri.nl.sample.basics

/**
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */

fun main() {
    println(RomanNumerals().romanToInt("DCXXI"))
    println(RomanNumerals().optimizedRomanToInt("DCXXI"))
}
class RomanNumerals {

    fun romanToInt(s: String): Int {

        val symbolToValue = mapOf("I" to 1, "IV" to 4, "V" to 5, "IX" to 9, "X" to 10, "XL" to 40, "L" to 50, "XC" to 90, "C" to 100, "CD" to 400, "D" to 500, "CM" to 900, "M" to 1000)
        val checkCharacters = mapOf("I" to "VX","X" to "LC","C" to "DM")
        var result = IntArray(s.length)
        var i = 0
        while(i < s.length) {
            if (checkCharacters.contains(s[i].toString()) && i+1 < s.length) {
              if (s[i + 1].toString() == "I" || !checkCharacters.getValue(s[i].toString()).contains(s[i + 1])) {
                  result = result.plus(symbolToValue.getValue(s[i].toString()))
                    i++
                } else {
                  result = result.plus(symbolToValue.getValue(s[i].toString().plus(s[i + 1].toString())))
                    i +=2
                }
            } else {
                result = result.plus(symbolToValue.getValue(s[i].toString()))
                i++
            }
        }
        return result.sum()
    }

    fun optimizedRomanToInt(s: String): Int {
        val symbolToValue = hashMapOf("I" to 1, "V" to 5, "X" to 10, "L" to 50, "C" to 100, "D" to 500, "M" to 1000)
        var result = 0
        for(i in s.indices) {
            if(i+1 < s.length && symbolToValue.getValue(s[i].toString()) < symbolToValue.getValue(s[i+1].toString())) {
                result -= symbolToValue.getValue(s[i].toString())
            } else {
                result += symbolToValue.getValue(s[i].toString())
            }
        }
        return result
    }
}