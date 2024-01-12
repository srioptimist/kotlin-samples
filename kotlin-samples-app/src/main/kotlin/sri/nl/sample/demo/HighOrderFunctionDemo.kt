import kotlin.concurrent.thread

fun add(a: Int, b: Int) = a.plus(b)

// Example of HOF with function as an argument

fun numberOperations(a: Int, b: Int, operation: ((Int, Int) -> Int)?) = operation?.let { it(a,b) }

val add: (Int, Int) -> Int = { a,b -> a.plus(b) }

// Example of HOF with function as a return type

fun concat(a: String, b: String) = a.plus(b)

fun stringConcat(): (String, String) -> String = { a,b -> a.plus(b) }

fun stringReverse(): (String, String) -> String = { a,b -> b.plus(a) }

val result = stringConcat()

// Example of HOF with function as an argument and as a return type

fun square(a: Int, b: Int, operation: (Int, Int) -> Int) : () -> (Int) = {  operation(a,b) * operation(a,b) }

// Use case

fun backend(a: Int, b: Int) = a-b

fun doSomething(a: Int, b: Int, successMessage: String, errorMessage: String, successCallback: (String) -> Unit, errorCallback: (String) -> Unit): Int {
    val result = backend(a,b)
    if(result>0){
        successCallback(successMessage)
    } else {
        errorCallback(errorMessage)
    }
    return result
}

val successCallback: (String) -> Unit = { msg ->
    thread {
        Thread.sleep(2000)
        println(msg)
    }
}

val errorCallback: (String) -> Unit = { msg ->
    thread {
        Thread.sleep(2000)
        println(msg)
    }
}

fun main(){
//    println("Welcome to Ignite")
//    println(add(1,2))
//    println(numberOperations(1,2, ::add))
//    println(numberOperations(1,2, add))
//    println(numberOperations(1,2, { a,b -> a.plus(b) }))
//    println(numberOperations(1,2) { a, b -> a.plus(b) })
//    println(numberOperations(1,2) { a, b -> a.minus(b) })
//    println(numberOperations(1,2) { a, b -> a.times(b) })
//    println(numberOperations(1,2) { a, b -> a.div(b) })

//    println(concat("Hello", "World"))
//    println(stringConcat().invoke("Hello","World"))
//    println(stringConcat()("Hello","World"))
//    println(result("Hello", "World"))
//    println(stringReverse()("Hello","World"))

//    println(square(1,2) { a, b -> a.plus(b) }.invoke())
//    println(square(1,2) { a, b -> a.minus(b) }())
//    println(square(1,2) { a, b -> a.times(b) }.invoke())
//    println(square(1,2) { a, b -> a.div(b) }())

    //println(doSomething(1,2,"Success", "Error", successCallback, errorCallback))

    (0..100).toList().filter { it>50 }.forEach { println(it) }
}