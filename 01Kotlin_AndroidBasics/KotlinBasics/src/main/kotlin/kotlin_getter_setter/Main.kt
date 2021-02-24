package kotlin_getter_setter

import java.lang.IllegalArgumentException


/**
 *  GETTER and SETTER in Kotlin
 *  with examples
 */

const val SOME_MODIFICATION = "[No]"

class MyClass(){
    // Kotlin auto generates getters and setters
    var someString: String = "default"
    // EQUAL TO
    var someStringExplicitGetterSetter: String = "default"
        get() = field
        set(value) {
            field = value
        }

    // Auto generate Getter and Setter in Intellij:
    // click on variable and use Alt + Enter

    // immutable variables can only have getter
    val someImmutableString: String = "immutable"
        get() = field

    //only allow get() method on mutable variable
    var otherVar: String = "only get allowed"
        private set


    //example usages for getter and setter
    var lastname: String = ""
        get() {
            if(!field.isEmpty()){
                return field.trim() + "!"
            }
            return field
        }
        set(value) {
            if(value.length > 1){
                field = SOME_MODIFICATION + value
            }else{
                throw IllegalArgumentException("Lastname must have at least 2 characters")
            }
        }
}


fun main(){
    val test = MyClass()
    test.lastname = "Simpson      "

    println("Lastname: " + test.lastname)
    //throws Exception
    //test.lastname = "S"

    //get allowed
    println(test.otherVar)
    //not allowed to set because of private set
    //test.otherVar = "x"
}