package sri.nl.sample.basics

/**
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 */

fun main() {
    println("Prefix is " + LongestCommonPrefix().longestCommonPrefix(arrayOf("flower","flow","flight")))
    println("Prefix is " + LongestCommonPrefix().longestCommonPrefix(arrayOf("dog","racecar","car")))
    println("Prefix is " + LongestCommonPrefix().optimisedSolution(arrayOf("flower","flow","flight")))
    println("Prefix is " + LongestCommonPrefix().optimisedSolution(arrayOf("dog","racecar","car")))
}
class LongestCommonPrefix {

    fun longestCommonPrefix(strs: Array<String>): String {
        var prefixToCheck = ""
        var prefix = ""
        var allMatch: Boolean
        for(i in 0 until strs[0].length) {
            allMatch = true
            prefixToCheck = strs[0].substring(0,i+1)
            for(j in 1 until strs.size) {
                if( strs[j].length >= i+1 && prefixToCheck == strs[j].substring(0,i+1)){
                    continue
                } else {
                    allMatch = false
                    break
                }
            }
            if(allMatch) prefix = prefixToCheck
        }
        return prefix
    }

    fun optimisedSolution(strs: Array<String>) : String {
        var prefix = strs[0]
        for(i in 1 until strs.size) {
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length - 1)
            }
        }
        return prefix
    }

}