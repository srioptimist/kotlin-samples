package sri.nl.sample.basics

/**
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *  Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

fun main() {
    println(LongestSubstring().lengthOfLongestSubstring("abcabcbb"))
    println(LongestSubstring().lengthOfLongestSubstring("pwwkew"))
    println(LongestSubstring().lengthOfLongestSubstring("bbbbb"))
    println(LongestSubstring().lengthOfLongestSubstring("au"))
    println(LongestSubstring().lengthOfLongestSubstring("dvdf"))
}

class LongestSubstring {

    fun lengthOfLongestSubstring(s: String): Int {

        if(s.isEmpty()) return 0
        var longSubString = ""
        var l = 1
        for(i in s.indices){
            if(!longSubString.contains(s[i].toString())) {
                longSubString += s[i]
            } else {
                if(longSubString.length >l) l = longSubString.length
                longSubString = longSubString.substring(longSubString.indexOf(s[i].toString())+1, longSubString.length).plus(s[i].toString())
            }
        }
        return if(longSubString.length > l) longSubString.length else l
    }
}