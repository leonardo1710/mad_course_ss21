package kotlincollections

import models.User

fun main(){
    //typical usage
    val httpHeaders = mapOf<String, String>(
        "Authorization" to "your-api-key",
        "ContentType" to "application/json",
        "UserLocale" to "AT"
    )

    val map = mapOf<Int, String>(
        1 to  "Marge",
        2 to "Homer",
        3 to "Bart"
    )

    val mixedMap = mutableMapOf<Int, Any>(
        1 to "Marge",
        2 to User(2, "Homer", "Simpsom"),
        3 to 66
    )

    //print all keys
    println("All keys: ${mixedMap.keys}")
    //print all values
    println("All values: ${mixedMap.values}")


    //mutable operations
    mixedMap.put(4, "Lisa")
    mixedMap[1] = "Not Marge anymore"

    println(mixedMap)


    //iterating maps
    httpHeaders.forEach { key, value -> println("Value for key $key is $value") }
}