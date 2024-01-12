package sri.nl.sample.basics

/**
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */

fun main() {
    println(LongestPalindromicSubstring().longestPalindrome("babad"))
    println(LongestPalindromicSubstring().longestPalindrome("cbbd"))
    println(LongestPalindromicSubstring().longestPalindrome("ac"))
    println(LongestPalindromicSubstring().longestPalindrome("ccd"))
    println(LongestPalindromicSubstring().longestPalindrome("abb"))
    println(LongestPalindromicSubstring().longestPalindrome("caba"))
    println(LongestPalindromicSubstring().longestPalindrome("aacabdkacaa"))
}
class LongestPalindromicSubstring {

    fun longestPalindrome(s: String): String {
        var res = ""; var resLen = 0

        fun findLongest(l: Int, r: Int) {
            var l = l; var r = r;
            while (l >= 0 && r < s.length && s[l] == s[r]) {
                if (r - l + 1 > resLen) {
                    resLen = r - l + 1;
                    res = s.substring(l, r + 1)
                }
                l --; r++
            }
        }

        for (i in 0 until s.length) {
            findLongest(i, i) // odd
            findLongest(i, i + 1) // even
        }
        return res
    }
}