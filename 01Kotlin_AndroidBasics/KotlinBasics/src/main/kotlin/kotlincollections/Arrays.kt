package kotlincollections

fun main(){
    //create arrays
    val arrayOfNumbers = arrayOf(1, 8, 3, 9, 5)     //inherent type
    var arrayOfNumbers2 = arrayOf<Int>(2, 4, 6)     //specific type declaration
    var emptyArray = emptyArray<String>()           //create empty array type of string
    var defaultValueArray = Array(5) { 0 }     //create array of size 5 with default values set to 0
    var defaultValueArray2 = IntArray(5)       //will be like array from before [0, 0, 0, 0, 0]

    //looping arrays
    arrayOfNumbers.forEach { number -> println(number) }

    for(number in arrayOfNumbers) {
        println(number)
    }

    //access array elements
    val firstVal = arrayOfNumbers[0]

    //overwrite value on specific index
    arrayOfNumbers[2] = 4

    //get array size
    val arraySize = arrayOfNumbers.size

    //get last index of array
    val lastIndex = arrayOfNumbers.lastIndex

    //sort array
    val sortedArray = arrayOfNumbers.sort()

}