package sri.nl.sample.basics

/**
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 */
fun main() {

    fun lengthOfLastWord(s: String): Int {
        return s.trim().split(" ").last().length
    }

    println(lengthOfLastWord("   fly me   to   the moon  "))
}
