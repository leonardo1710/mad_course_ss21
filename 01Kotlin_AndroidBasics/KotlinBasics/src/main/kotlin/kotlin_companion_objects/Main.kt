package kotlin_companion_objects

/**
 * Companion object is Kotlin's equivalent of static members in Java.
 */

//class to be used as companion object
//can be shared between classes eg.: use stateless code across several classes for internal purposes
open class Serializer {
    fun serialize(obj: Any): String{
        return "Fullname: $obj"
    }
}

class Student(val firstname: String = "Jane", val lastname: String = "Doe", semester: Int = 3) {
    companion object: Serializer()

    fun printFullName() {
        println(serialize(firstname + " " + lastname))
    }
}

class Lecturer(val firstname: String = "John", val lastname: String = "Doe") {
    //example of getter and setter in kotlin
    var courseCount: Int = 0
        get() = field
        set(value) {
            field = value
        }

    companion object {
        val serializer = Serializer()
    }

    fun printFullName() {
        println(serializer.serialize(firstname + " " + lastname))
    }
}

fun main(){
    val student = Student("Bart")
    val lecturer = Lecturer()


    Student().printFullName()
    student.printFullName()
    lecturer.printFullName()
}