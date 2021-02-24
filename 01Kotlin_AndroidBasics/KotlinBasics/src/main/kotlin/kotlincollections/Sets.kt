package kotlincollections

import models.User

fun main(){
    val numbers = mutableSetOf<Int>(1, 2, 3, 4)
    val users = setOf(
        User(1, "Marge", "Simpson"),
        User(2,"Homer", "Simpson"),
        User(3,"Bart", "Simpson"))

    val mutableSet = mutableSetOf<User>(
        User(1, "Marge", "Simpson"),
        User(2,"Homer", "Simpson"),
        User(3,"Bart", "Simpson"),
        User(4, "Lisa", "Simpson")
    )

    val userToRemove = User(2,"Homer", "Simpson")

    //remove from set - only works with MutableSet
    mutableSet.remove(userToRemove)
    mutableSet.add(User(5, "Maggie", "Simpson"))

    //iterating sets
    mutableSet.forEach{
        println(it.firstname + " " + it.lastname)
    }

    //adding not unique value wont affect set
    println(numbers)
    numbers.add(1)
    println(numbers)
    numbers.add(5)  //unique value is added
    println(numbers)
}