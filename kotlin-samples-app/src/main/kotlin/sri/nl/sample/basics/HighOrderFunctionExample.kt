package sri.nl.sample.basics

fun main() {

    fun stringActions(firstWord: String, secondWord: String, action: (String, String) -> String) : String = action(firstWord, secondWord)

    fun concat(firstWord: String, secondWord: String) = firstWord.plus(secondWord)

    val reverse: (String, String) -> String = { a,b -> b.plus(a)}

    val firstWord = "Hello"
    val secondWord = "World"

    println(stringActions(firstWord, secondWord, { a, b -> a + b}))
    println(stringActions(firstWord, secondWord) { a, b -> a + b })
    println(stringActions(firstWord, secondWord, ::concat))
    println(stringActions(firstWord, secondWord, reverse))

    fun square(x: Int) = x * x

    fun operation(): (Int) -> Int {
        return ::square
    }

    val func = operation()
    println("Example of HOF returning function ${func(2)}")

    fun decorateString(decorate: () -> String) : (String) -> String =  {a -> decorate().plus(a)}

    val aString = "Hello"
    val returnedFunction = decorateString {aString}
    println("Invoke the returned function with World ${returnedFunction.invoke("World")}")
    println("Invoke the returned function with Hello ${returnedFunction(aString)}")

}