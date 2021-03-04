package Example_01

import java.lang.Double.parseDouble
import java.util.*

enum class Status(val value: Int) {
    WRONG(0), RNWP(1), CORRECT(2),
}

val random = Random()
var numberFound: Boolean = false

fun main(args: Array<String>) {
    println("The object of the game is to guess the hidden four digit number. There are no repeated digits in the number. \n" + "Once you have guessed, a code will be shown that indicates how successful your guess was.")
    println("Legend:\n \u2705 = right number & right place\n \u25A1 = right number & wrong place\n \u2716 = wrong number & wrong place\n")
    println("Enter the four digit Number:")

    val randomNumber = generateNumber()
    println(randomNumber)

    while(!numberFound){
        try {
            val inputNumber = readLine().toString()
            parseDouble(inputNumber)
            numberFound = checkNumber(inputNumber, randomNumber)
        } catch (e: NumberFormatException) {
            println("Not a number!") }
    }
}

fun generateNumber():String {
    var randomNumber = ""

    while (randomNumber.length < 4) {
        val number = random.nextInt(10).toString()
        if (!randomNumber.contains(number)) randomNumber += number
    }
    return randomNumber
}

fun checkNumber(input: String, random: String): Boolean {
    return if(input.length == 4) {
        if (input == random) {
            println("Gratulation, $input is the correct number")
            true
        } else {
            checkStatus(input, random)
            false
        }
    } else {
        println("STUPIDO!!!, Enter a number with exactly 4 digits!")
        false
    }
}

fun checkStatus(input: String, random: String) {
    val checkedIndex: IntArray = intArrayOf(0, 0, 0, 0)
    var count = 0

    for (digit in input) {
        if (digit == random[count])
            checkedIndex[count] = Status.CORRECT.value
        count++
    }
    count = 0

    for (digit1 in input) {
        for (digit2 in random) {
            if (digit1 == digit2 && checkedIndex[count] != 2)
                checkedIndex[count] = Status.RNWP.value
            count++
        }
        count = 0
    }

    val status = drawStatus(checkedIndex)
    println(status)
}

fun drawStatus(checkedIndex: IntArray): String {
    var status = ""
    for(digit in checkedIndex){
        if(digit == Status.CORRECT.value)
            status += "\u2705"
    }
    for(digit in checkedIndex){
        if(digit == Status.RNWP.value)
            status += "\u25A1"
    }
    for(digit in checkedIndex){
        if(digit == Status.WRONG.value)
            status += "\u2716"
    }
    return status
}