package Example_06



fun main(args: Array<String>) {
    // Random-Number erstellen:
    val randomNumber: String
    // take - gibt eine Liste zurück
    val createNumber = (1..9).shuffled().take(4).joinToString("")
    randomNumber = createNumber
    // for testing purposes
    println(randomNumber)
    println("Please enter four unique digit numbers between 1 and 9: - for example 1234")

    var guessedNumber: String = readLine()!!

    var init = true

    fun checkValue() {
        while (init) {

            if (guessedNumber == randomNumber) {
                println("You guessed the number correctly!")
                init = false
                return
            }

            else {
                var positions: MutableList<String> = mutableListOf()
                for(i in randomNumber.indices) {

                    // Numbers in correct position (C)
                    if (guessedNumber[i] == randomNumber[i]) {
                        positions.add("C")
                    }

                    // Numbers correct - but not right position (P)
                    else if (randomNumber.contains(guessedNumber[i])) {
                        positions.add("P")
                    }
                    else positions.add("X")
                }
                // Sort the list – alphabetical as default
                println(positions.sorted())
            }
            println("Try again:")
            guessedNumber = readLine()!!
        }
    }
    checkValue()
}