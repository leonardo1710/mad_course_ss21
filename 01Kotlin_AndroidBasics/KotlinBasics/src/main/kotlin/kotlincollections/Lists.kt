package kotlincollections

import models.User

fun main(){
    val immutableList = listOf<Int>(2, 4, 5, 1, 6)
    val mutableList = mutableListOf<Int>(3, 5, 1, 6, 8)
    val list = listOf<String>("Bart", "Lisa", "Marge", "Homer", "Maggie")
    val userList = listOf(User(1, "Marge", "Simpson"), User(2,"Homer", "Simpson"), User(3,"Bart", "Simpson"))

    //changing values does not work with normal list
    //immutableList[0] = 100

    //List operations
    val cnt = immutableList.count()
    val max = immutableList.max()
    val min = immutableList.min()
    val sum = immutableList.sum()
    val avg = immutableList.average()

    println(immutableList.contains(2))

    println("First word in list " + list.first())

    //searching in list
    val w1 = list.first { w -> w.startsWith('M')}       //gets first list element that starts with "M"
    val w2 = list.findLast { w -> w.startsWith('M') }   //gets last list element starting with "M"

    //find first element in list where element > 3
    println(immutableList.find { x -> x > 3 })

    //list iterations
    list.forEach{ word -> println("$word")}

    for(word in list){
        println(word)
    }

    //iteration with index
    for(i in 0 until list.size){
        println("$i : ${list[i]}")
    }

    //sorting
    val sortASC = immutableList.sorted()
    val sortDESC = immutableList.sortedDescending()
    val reversedList = list.reversed()


    val sortedObjectList = userList.sortedBy { user -> user.firstname }

    sortedObjectList.forEach{ user -> println(user.firstname) }

    //mutable operations
    mutableList.add(10)
    mutableList.removeAt(0)
    mutableList.addAll(listOf(1, 2, 3)) //add a list to list

    mutableList.addAll(immutableList)   //add immutable list to list

    println(mutableList)

    mutableList.clear()     //remove all elements


    //filtering lists
    val highNumbers = immutableList.filter { x -> x > 5}
    println(highNumbers)

    val exclusiveFilter = immutableList.filterNot { x -> x == 5 }
    println(exclusiveFilter)
}