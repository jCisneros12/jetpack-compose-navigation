package com.jcisneros12.composenavigation.data

data class Fruit(
    val id: Int,
    val name: String
)

val fruitList = listOf(
    Fruit(id = 0, name = "Orange"),
    Fruit(id = 1, name = "Pear"),
    Fruit(id = 2, name = "Banana"),
    Fruit(id = 3, name = "Grape")
)

fun findFruit(id: Int) = fruitList.find { it.id == id }