package sri.nl.sample.basics

import kotlin.math.absoluteValue

/**
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 *
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 *
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 */

fun main(){
    println(ReverseInteger().reverse(123))
    println(ReverseInteger().reverse(-123))
    println(ReverseInteger().reverse(120))
    println(ReverseInteger().reverse(9))
}

class ReverseInteger {

    fun reverse(x: Int): Int {
        var n = x
        var r:Long = 0
        if(x<0){
            n = x.absoluteValue
        }
        while(n!=0) {
            r += n%10
            n /= 10
            r *= 10
        }
        r /= 10 // remove the last zero
        if(x<0){
            r *= -1
        }
        if( r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
            return 0
        }
        return r.toInt()

    }
}