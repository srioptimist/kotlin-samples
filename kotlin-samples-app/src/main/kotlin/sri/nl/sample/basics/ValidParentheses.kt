package sri.nl.sample.basics

/**
 * Input: s = "()"
 * Output: true
 *
 * Input: s = "()[]{}"
 * Output: true
 *
 * Input: s = "(]"
 * Output: false
 */

fun main() {
//    println(ValidParentheses().isValid1("()[]{}"))
//    println(ValidParentheses().isValid1("(]"))
//    println(ValidParentheses().isValid1("{[]}"))
//    println(ValidParentheses().isValid1("([)]"))
//    println(ValidParentheses().isValid1("(("))
    println(ValidParentheses().isValid("[({(())}[()])]"))
    println(ValidParentheses().optimizedSolution("[({(())}[()])]"))
}

class ValidParentheses {

    fun  isValid(s: String): Boolean {
        val parenthesis = mapOf('(' to ')', '{' to '}', '[' to ']')
        if(s.length % 2 != 0) return false
        var i = 0
        var l = listOf<Char>()
        while(i < s.length){
            if(i+1 < s.length && s[i+1] == parenthesis[s[i]]) {
                i+=2
            } else if(parenthesis[s[i]] !=null){
                l = l.plus(s[i])
                i++
            } else {
                if(l.isNotEmpty() && parenthesis[l.last()] == s[i]) {
                    l = l.subList(0, l.size-1)
                    i++
                } else {
                    return false
                }
            }
        }
        return l.isEmpty()
    }

    fun optimizedSolution(s: String): Boolean  {
        val c = ArrayDeque<Char>()
        if(s.length % 2 != 0) return false
        for(i in s) {
            when (i) {
                '(', '[', '{' -> c.addLast(i)
                ')' -> if(c.isEmpty() || c.removeLast() != '(') return false
                ']' -> if(c.isEmpty() || c.removeLast() != '[') return false
                '}' -> if(c.isEmpty() || c.removeLast() != '{') return false
            }
        }
        return c.isEmpty()
    }
}