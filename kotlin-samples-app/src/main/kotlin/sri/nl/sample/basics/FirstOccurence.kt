package sri.nl.sample.basics

/***
 *
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 *
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 *
 * Constraints:
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 *
 */

fun main() {
    println(FirstOccurence().strStr("hello","ll"))
}

class FirstOccurence {

    fun strStr(haystack: String, needle: String): Int {
        if(needle.length > haystack.length) {
            return -1
        }
        if(haystack.contains(needle)) {
            for(i in 0..haystack.length){
                if(i+needle.length > haystack.length){
                    return -1
                }
                if(haystack.substring(i, i+needle.length) == needle){
                    return i
                }
            }
        }
        return -1
    }
}
