package sri.nl.sample.basics

import kotlin.concurrent.thread

// Example with function as an argument

fun numberOperations(a: Int, b: Int, operation: (Int,Int) -> Int) = operation(a,b)

fun add(a: Int, b: Int) = a+b

val add: (Int, Int) -> Int = { a,b -> a+b }

// Example with function as a return value

fun concat(a: String, b: String) = a.plus(b)

fun stringConcat(): (String, String) -> String = ::concat
fun stringReverse(): (String, String) -> String = { a,b -> b.plus(a) }

val result = stringConcat()

// Example with function as an argument and as a return value

fun square(a: Int, b: Int, operation: (Int,Int) -> Int): () -> Int = { operation(a,b)*operation(a,b) }

// Example with a use case

fun doSomething(a: Int, b: Int, successCallbackMessage: String, errorCallbackMessage: String, successCallback:  (String) -> Unit, errorCallback:  (String) -> Unit): Int {
   val result = backend(a,b)
    if(result > 0 ){
        successCallback(successCallbackMessage)
    } else {
        errorCallback(errorCallbackMessage)
    }
    return result
}

fun backend(a: Int, b: Int) = a.minus(b)

fun main() {
    println("Hi")



    println(add(1,2))
    println(numberOperations(1,2, ::add))
    println(numberOperations(1,2, add))
    println(numberOperations(1,2, {a,b -> a+b}))
    println(numberOperations(1,2) { a, b -> a + b })
    println(numberOperations(1,2) { a, b -> a - b })
    println(numberOperations(1,2) { a, b -> a * b })
    println(numberOperations(1,2) { a, b -> a / b })

    println(concat("Hello","World"))

    println(result("Hello","World"))
    println(stringConcat().invoke("Hello", "World"))
    println(stringConcat()("Hello", "World"))
    println(stringReverse().invoke("Hello", "World"))



    println(square(1,2) { a, b -> a + b }.invoke())
    println(square(1,2) { a, b -> a - b }.invoke())
    println(square(1,2) { a, b -> a * b }.invoke())
    println(square(1,2) { a, b -> a / b }.invoke())

    val result = doSomething(1, 2, "Success", "Error", { msg ->
        thread {
            Thread.sleep(3000)
            println(msg)
        }
    }) { msg ->
        thread {
            Thread.sleep(3000)
            println(msg)
        }
    }

    println(result)

   (1..100).toList().filter { it > 50 }.forEach { println(it) }

}
