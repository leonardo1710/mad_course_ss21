package kotlin_extension_functions

/**
 * Kotlin Extension Functions
 *
 * In Koltin, you can use extension function to extend a class with new functionality.
 * Basically, an extension function is a member function of a class that is defined outside the class.
 *
 * For example, you need to use a method to the String class that returns a new string that escapes some characters - this method is not already available in String class.
 * You can use extension function to accomplish this task.
 */
fun main(){
    val list = mutableListOf<Int>(1, 3, 5, 0)

    println(list)
    list.swap(0, list.lastIndex)
    println(list)

    val xml =
        """
            <note>
                <to>Tove</to>
                <from>Jani</from>
                <heading>Reminder</heading>
                <body>Don't forget me this weekend!</body>
            </note>
        """

    val escapedXML = xml.escapeForXml()
    print(escapedXML)
}

// add a swap function to MutableList
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

// extension function that escapes string characters
fun String.escapeForXml() : String {
    return this
        .replace("&", "&amp;")
        .replace("<", "&lt;")
        .replace(">", "&gt;")
}