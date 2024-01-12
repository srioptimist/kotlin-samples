package sri.nl.sample.basics

// Java

class Utils {
    companion object {
        fun square(x: Int): Int  = x*x
    }
}

// Extension functions

fun Int.plus1() = this+1
infix fun Int.plusOther(a: Int) =  this+a

fun Int.square() = this * this

// Extension properties

val String.isLong: Boolean
    get() = this.length > 20


// Function type with a receiver

// Function type (T) -> R

val a:Int =1
val plusOne: (Int)-> Int = { i -> i+1} // (T) -> R

// Function type with a receiver S.(T) -> R

// Lambda version

val squareFunLambda: Int.()->Int = { this * this } // S.(T) -> R


//Anonymous function version

//val squareFunAnonymous: Int.()->Int = fun Int.() = this * this
val squareFunAnonymous = fun Int.(): Int = this * this


// Differences

// Extension functions

// -- Statements
// -- It is created by extension function declaration

// Function type with a receiver

// -- Expressions, you can assign it to a variable and pass it to other functions
// -- It is created by instantiating a function type with a receiver


// Both extension functions and function type with receiver are just syntactic sugar,
// they both compile to a regular functions with the receiver as the first argument.

// One difference is, you always need a receiver to call an extension function, you cannot pass receiver as a first argument

fun main() {
    println("Welcome")
    println(Utils.square(4))
    println(1.plus1())
    println(1.plusOther(2))
    println(1 plusOther 5)
    val i: Int? = null
    println(i?.plus1())
    println(3.square())
    println("Test".isLong)
    println("Test                   true".isLong)
    println(plusOne)
    println(plusOne.invoke(1))
    println(3.squareFunLambda())
    println(squareFunLambda(3))
    println(squareFunLambda.invoke(3))
    println(3.squareFunAnonymous())
    println(squareFunAnonymous(3))
    println(squareFunAnonymous.invoke(5))
}

// References
//
//https://medium.com/the-kotlin-primer/functions-with-receiver-28b71b11ddde
//
//https://blog.kotlin-academy.com/programmer-dictionary-function-literal-with-receiver-vs-function-type-with-receiver-cc21dba0f4ff
//
//https://www.geeksforgeeks.org/function-literals-with-receiver-in-kotlin/
//
//https://dev.to/frevib/kotlin-extension-function-vs-function-literal-with-receiver-411d
//https://typealias.com/start/kotlin-receivers-and-extensions/
//
//Context Receiver
//
//https://proandroiddev.com/exploring-kotlins-context-receivers-280ca45864d0
//
//https://pspdfkit.com/blog/2022/kotlin-context-receivers/
//
//https://medium.com/@alex.frank84/context-receivers-9265b29a6ff1
//
//https://blog.frankel.ch/kotlin-context-receivers/