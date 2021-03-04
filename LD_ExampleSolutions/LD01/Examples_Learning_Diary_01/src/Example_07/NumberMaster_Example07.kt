package Example_07

import java.util.*

fun main(){
    val randomNumber = getRandomNumber()
    var attempts = 1

    //println(randomNumber)

    printInstructions()
    var userGuess = getUserGuess()
    while(!checkGuess(randomNumber, userGuess)){
        userGuess = getUserGuess()
        attempts++
    }

    println("You won!")
    println("Total number of attempts: $attempts")
}

fun printInstructions(){
    println("------------------------------------------------------------------")
    println(" Try to guess a 4-digit number. No digit is repeated within the number.\n")
    println(" A \u2713 will be displayed for correct digits in the correct place, \n" +
            " a \u25A1 will be displayed for correct digits in the wrong place and \n" +
            " a \u2716 will be displayed for wrong digits.\n")
    println("If less than 4 digits are entered, each missing leading digit will be set to 0.")
    println("If more than 4 digits are entered, each extra trailing digit will be ignored.")
    println("------------------------------------------------------------------\n")
}

fun getUserGuess(): String {
    var userNumber = false
    var userInput: String? = "0000"
    while (!userNumber){
        print("Please enter your guess (4-digit number): ")
        userInput = readLine()
        try {
            Integer.valueOf(userInput)
            userNumber = true
        }catch (e: NumberFormatException){
            println("Invalid input! Please enter a four digit number.")
        }
    }
    if(userInput!!.length > 4){
        userInput = userInput.slice(0..3)
    }
    while(userInput!!.length<4){
        userInput = "0$userInput"
    }
    return userInput.toString()
}

fun getRandomNumber(): String {
    val digitList:Array<String> = arrayOf("0","1","2","3","4","5","6","7","8","9")
    var randomNumber = ""
    for(i in 0..3) {
        var randomDigit:String = digitList[Random().nextInt(digitList.size)]
        while(randomNumber.contains(randomDigit)) {
            randomDigit = digitList[Random().nextInt(digitList.size)]
        }
        randomNumber += randomDigit
    }
    return randomNumber
}

fun checkGuess(randomNumber: String, userGuess: String): Boolean {
    var rightDigits = 0
    var otherDigits = 0
    if(userGuess.contentEquals(randomNumber)){
        return true
    }
    for (i in 0..3){
        if(userGuess[i] == randomNumber[i]){
            rightDigits++
        } else if(randomNumber.contains(userGuess[i])){
            otherDigits++
        }
    }
    printGuessResult(userGuess, rightDigits, otherDigits)
    return false
}

fun printGuessResult(userGuess: String, rightAnswer: Int, otherAnswer: Int) {
    var rightAnswers = rightAnswer
    var otherAnswers = otherAnswer
    var wrongAnswers = 4-rightAnswers-otherAnswers
    println("Your guess: $userGuess")
    print("Result: ")
    while(rightAnswers > 0){
        print("✓")
        rightAnswers--
    }
    while(otherAnswers > 0){
        print("□")
        otherAnswers--
    }
    while(wrongAnswers > 0){
        print("✖")
        wrongAnswers--
    }
    println("\n")
}