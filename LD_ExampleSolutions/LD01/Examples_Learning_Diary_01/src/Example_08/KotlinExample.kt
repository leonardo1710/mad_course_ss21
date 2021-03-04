package Example_08

/**
 * Example of how to
 *
 * Split a String array
 *
 * Convert values to ints
 *
 * and add them to inArray
 */
fun main(){

    val myString = "1 2 3 4 5"

    val myStringValues = myString.split(" ")

    val myIntList = ArrayList<Int>()

    for(item in myStringValues){
        myIntList.add(item.toInt())
    }

    val mySecondIntArray = myStringValues.map { it.toInt() }

    for(item in mySecondIntArray){
        println(item)
    }

}