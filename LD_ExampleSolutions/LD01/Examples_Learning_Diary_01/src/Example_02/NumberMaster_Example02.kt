package Example_02

fun main(){
    // for y, o, x
    var userArray=arrayOf(' ', ' ', ' ', ' ')
    var userInputString: String?
    var count=1
    var countRandom=0

    // RANDOM DIGITS
    var chosen2=IntArray(4)

    println("\nNUMBER MASTER")
    println( "\nThe object of the game is guessing the hidden 4 digit number. " +
            "\nThere are no repeated digits in the number. " +
            "\nOnce you have guessed, a code will be shown that " +
            "indicates how successful your guess was." )
    println("\ny = correct digit in the right place\no = correct digit " +
            "in the wrong place\nx = incorrect digit")

    // get a random number for DIGITS TO BE GUESSED and store in IntArray
    while (countRandom < 4) {
        var randomNr=(0 until 10).random()
        // no doubles
        if ((randomNr != chosen2[0]) && (randomNr != chosen2[1])
            && randomNr != chosen2[2] && randomNr != chosen2[3]) {
            chosen2[countRandom]=randomNr
            // print(chosen2[countRandom])
            countRandom++
        }
    }

    // works - puts out 4 DIGITS TO BE GUESSED
    for (number in chosen2) {
        // print(number)
    }

    // the user can keep guessing as long as he/she likes.
    while (!userArray.contentEquals(arrayOf('y', 'y', 'y', 'y'))) {
        println("\n---------------------------------------")
        println("\nTake your guess and enter 4 digits!")
        userInputString = readLine()

        // check if actually 4 digits and nothing else
        var numeric= userInputString!!.matches("-?\\d+(\\.\\d+)?".toRegex())
                && userInputString.length == 4
                && checkDigits(userInputString)

        if (numeric) {
            println("GUESS $count:")

            // String to IntArray
            val size: Int = userInputString.length
            val userInputArray = IntArray(size)

            for (i in userInputArray.indices) {
                userInputArray[i] = Integer.parseInt(userInputString[i].toString())
            }

            // Compare input with 4 chosen digits + save y/o/x in userArray
            for (number in userInputArray.indices) {
                // DIGIT CORR. AT CORR. POSITION: checks value at [0,1,2,3]
                // position in String and checks if equal to AusgangsArray
                // at position [0,1,2,3]
                if (userInputArray[number] == chosen2[number]) {
                    userArray[number] = 'y'
                }
                // DIGIT CORRECT AT WRONG POSITION: check other positions
                // for correct digits userString[number]+1
                // --> VALUE at position 1
                else if ((userInputArray[number]) == chosen2[0] ||
                    userInputArray[number] == chosen2[1] ||
                    userInputArray[number] == chosen2[2] ||
                    userInputArray[number] == chosen2[3]
                ) {
                    userArray[number] = 'o'
                }
                // if none of the digits is correct, there will be an x
                else {
                    userArray[number] = 'x'
                }
            }

            // SEQUENCE is important: print userArray starting with y,
            // then o, then x. Compare the value at each position
            // with y, o and x.
            for (number in userArray.indices) {
                if (userArray[number] == 'y') {
                    print('y')
                }
            }
            for (number in userArray.indices) {
                if (userArray[number] == 'o') {
                    print('o')
                }
            }
            for (number in userArray.indices) {
                if (userArray[number] == 'x') {
                    print('x')
                }
            }

            println()

            // check if all y's.
            if (userArray.contentEquals(arrayOf('y', 'y', 'y', 'y'))) {
                println("\n\n---------------------------------------")
                println(" YOU WON! IT TOOK YOU $count GUESS(ES) ")
                println("---------------------------------------")
                println()
            }
            count++
        }else{
            println("Invalid input. Try again!")
        }

    }

}

operator fun String?.set(countRandom: Int, value: String?) { }

// no double digits can be entered by user
fun checkDigits(str: String): Boolean {
    // get length
    val size: Int = str.length

    // length is size of new array
    val userInputArray = IntArray(size)

    // String to IntArray
    for (i in userInputArray.indices) {
        userInputArray[i]= Integer.parseInt(str[i].toString())
    }

    // check occurrence only once:
    // if #[1] - #[0] == 0 --> same number
    if (userInputArray[0] - userInputArray[1] == 0 ||
        userInputArray[0] - userInputArray[2] == 0 ||
        userInputArray[0] - userInputArray[3] == 0 ||
        userInputArray[1] - userInputArray[0] == 0 ||
        userInputArray[1] - userInputArray[2] == 0 ||
        userInputArray[1] - userInputArray[3] == 0 ||
        userInputArray[2] - userInputArray[0] == 0 ||
        userInputArray[2] - userInputArray[1] == 0 ||
        userInputArray[2] - userInputArray[3] == 0 ||
        userInputArray[3] - userInputArray[0] == 0 ||
        userInputArray[3] - userInputArray[1] == 0 ||
        userInputArray[3] - userInputArray[2] == 0){
        return false
    }
    return true
}