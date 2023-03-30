package sri.nl.sample.basics

data class Item(val price: Int) {
    operator fun plus(anotherItem: Item) = anotherItem.price + price
    operator fun minus(anotherItem: Int) = price - anotherItem
    operator fun times(noOfTimes: Int) = price * noOfTimes
}



fun main() {

    operator fun Item.get(index: Int): Int = this.price

    val item1 = Item(2)
    val item2 = Item(3)


    println("Total price -> ${item1 + item2}")
    println("Difference in price -> ${item2 - 2}")
    println("Item price times -> ${item1 * 2}")
    println("Price of the item ${item2[10]}")
}