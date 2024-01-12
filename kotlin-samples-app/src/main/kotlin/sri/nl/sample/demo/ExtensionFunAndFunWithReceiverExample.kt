class Utility {
    companion object {
        fun appendWorld(input: String) =   input + "World!"
    }
}

// Extension function

fun String.appendWorld() = this + "World!"

fun Int?.plusOne() = this?.plus(1) ?: 0

infix fun Int.plusOther(b: Int) = this + b

// Extension properties

val String.isLengthy : Boolean
    get() = this.length > 20

// Function type with receiver

val d = 20

val cube: (Int) -> Int = { i -> i*i*i } // (T) -> O

// Lambda

val cubeLambda: Int.() -> Int = { this*this*this }

// Anonymous function

//val cubeAnonymous: Int.() -> Int = fun Int.(): Int = this * this * this
val cubeAnonymous = fun Int.(): Int = this * this * this

// Extension function

// --- Statements
// -- Created by extending a class
// --- You always need a receiver to invoke it

// Function type with receiver

// --- Expressions
// --- Created by instantiating a function type with a receiver
// -- We can receiver as a 1st argument



fun main() {
    println("Welcome to Engineer's week!")
    println(Utility.appendWorld("Hello "))
    println("Hello ".appendWorld())
    println(2.plusOne())
    val b: Int = 4
    println(b.plusOne())
    println(5.plusOther(6))
    println(6 plusOther 9)
    println(6.plusOther(9) )
    val c: Int? = null
    println(c.plusOne())
    println("test".isLengthy)
    println("test                                  ".isLengthy)
    println(cube)
    println(cube(3))
    println(cube.invoke(3))
    println(cubeLambda)
    println(4.cubeLambda())
    println(cubeLambda(4))
    println(cubeLambda.invoke(4))
    println(cubeAnonymous)
    println(6.cubeAnonymous())
    println(cubeAnonymous(6))
    println(cubeAnonymous.invoke(6))

}