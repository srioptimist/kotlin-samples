package sri.nl.sample.basics

interface Animal {
    fun name() : String
}

class Dog: Animal {
    override fun name() : String = "A dog"
}

class Cat: Animal {
    override fun name() : String = "A cat"
}

class Cow: Animal {
    override fun name() : String = "A cow"
}

inline fun <reified T: Animal> callAnimal(animal: T): String  {
    println("".toDouble())
    println("Type of T -> ${T::class.java}")
    return animal.name()
}

fun main() {
    println(callAnimal(Dog()))
    println(callAnimal(Cat()))
    println(callAnimal(Cow()))
}