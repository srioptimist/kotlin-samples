package sri.nl.sample.basics

/***
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 * Constraints:
 *
 * 1 <= n <= 45
 */
fun main() {
    println(ClimbingStairs().climbStairs(5))
}
class ClimbingStairs {

    // n = 1 -> 1 -> 1
    // n = 2 -> 1+1 or 2 -> 2
    // n = 3 -> 1+1+1 or 2+1 or 1+2 -> 3
    // n = 4 -> 1+1+1+1 or 2+2 or 1+2+1 or 2+1+1 or 1+1+2 -> 5
    // n = 5 -> 1*5 or 2+2+1 or 1+2+2 or 2+1+2 or 1+1+1+2 or 1+1+2+1 or 1+2+1+1 or 2+1+1+1 -> 8


    // F(5) = F(4) + F(3)
    // F(n) = F(n-1) + F(n-2)


    fun climbStairs(n: Int): Int {
       val map = IntArray(n+1)
        if(n<4){
            return n
        }
        map[1] = 1
        map[2] = 2
        map[3] = 3
        for(i in 4..n) {
            map[i] = map[i-1] + map[i-2]
        }
        return map[n]
    }
}