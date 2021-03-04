package Example_04

import java.util.*

var randomNumber: Int = 1111
var counterAttempts: Int = 0

fun main(){
    initRandomNumber()
    var numberNotFound: Boolean = true

    println("How it works:\n" + "The object of the game is to guess the hidden four digit number. \n" +
            "There are no repeated digits in the number. \n" +
            "Once you have guessed, a code will be shown that indicates how successful your guess was.")
    println("Legend: \u2705 = right number & right place, \u25A1 = right number & wrong place, \u2716 = wrong number & wrong place")

    println("Please enter a number:")

    while (numberNotFound) {
        val scan = Scanner(System.`in`)
        try {
            val number = scan.nextInt()
            numberNotFound = checkNumber(number, randomNumber)
        } catch (e: InputMismatchException) {
            println("Not a number!")
        }
    }
}

fun initRandomNumber() {
    randomNumber = (1000..9999).random()
    val randomArray: IntArray = convertToArray(randomNumber)
    var counter: Int = 0
    for (digit1 in randomArray)
        for(digit2 in randomArray)
            if(digit1 == digit2) counter++
    if (counter>4)
        initRandomNumber()
}

fun checkNumber(guessedNumber: Int, randomNumber: Int): Boolean {
    val digits: String = guessedNumber.toString()
    if(digits.length == 4) {
        if (guessedNumber == randomNumber) {
            showStatus(guessedNumber,randomNumber)
            println("Congrats, you found the number. You needed $counterAttempts attempt(s).")
            return false
        } else {
            showStatus(guessedNumber,randomNumber)
            return true
        }
    } else {
        println("You must enter a number with exactly 4 digits!")
        return true
    }
}

fun showStatus(guessedNumber: Int, randomNumber: Int) {
    // 0 == wrong number and wrong place, 1 == right number and wrong place, 2 == right number and right place
    val guessedArray: IntArray = convertToArray(guessedNumber)
    val randomArray: IntArray = convertToArray(Example_04.randomNumber)
    var checkedIndexes: IntArray = rightPlace(guessedArray, randomArray)
    checkedIndexes = onlyRightNumber(checkedIndexes, guessedArray, randomArray)

    val status = formatStatus(checkedIndexes)
    println(status)

    counterAttempts++
}

fun rightPlace(guessedArray: IntArray, randomArray: IntArray): IntArray{
    val checkedIndexes: IntArray = intArrayOf(0, 0, 0, 0)
    var counter: Int = 0

    for(digit in guessedArray) {
        if (digit == randomArray[counter]) checkedIndexes[counter] = 2
        counter++
    }
    return checkedIndexes
}

fun onlyRightNumber(checkedIndexes: IntArray, guessedArray: IntArray, randomArray: IntArray): IntArray {
    var counter: Int = 0
    for(digit1 in guessedArray) {
        for(digit2 in randomArray){
            if(digit1 == digit2 && checkedIndexes[counter] != 2)
                checkedIndexes[counter] = 1
            counter++
        }
        counter = 0
    }
    return checkedIndexes
}

fun convertToArray(number: Int): IntArray{
    var usedNumber: Int = number
    val numberArray: IntArray = intArrayOf(0, 0, 0, 0)
    var counter: Int = 3

    for(digit in numberArray){
        numberArray[counter] = usedNumber%10
        usedNumber = (usedNumber - usedNumber%10)/10
        counter--
    }
    return numberArray
}

fun formatStatus(checkedIndexes: IntArray): String {
    var formatedStatus:String = ""
    var counter: Int = 0

    for(digit in checkedIndexes){
        if(digit == 2) formatedStatus += "\u2705"
    }

    for(digit in checkedIndexes){
        if(digit == 1) formatedStatus += "\u25A1"
    }

    for(digit in checkedIndexes){
        if(digit == 0) formatedStatus += "\u2716"
    }
    return formatedStatus
}

