package sri.nl.sample.basics

class iSPalindrome {

    fun isPalindrome(x: Int): Boolean {
      // return x.toString() ==  x.toString().reversed()
        if(x < 0 || (x%10 == 0 && x!=0)) {
            return false
        }
        var input = x
        var reversed = 0
        while(input!=0) {
            val remainder: Int = x % 10
            reversed = reversed * 10 + remainder
            input /= 10
        }
        return reversed == x
    }
}