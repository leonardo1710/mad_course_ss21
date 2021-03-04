package Example_05

enum class PositionInString {
    RP,
    WP,
    NC;
}

fun main() {
    lateinit var userInput: String
    var givenUp: String? = null
//Liste mit einmal einer Liste von PositionInString in Kombi mit welcher Zahl probiert wurde
    val triedList: MutableList<Pair<List<PositionInString>, String>> = mutableListOf()
    lateinit var currentTry: List<PositionInString>
    val randomNumber: String
    val createUniqueFourDigitNumber = { (0..9).shuffled().take(4).joinToString("") }
//createUniqueFourDigitNumber.forEach {randomNumber +=it }
    randomNumber = createUniqueFourDigitNumber()
    do {
        println(
            if (givenUp != "n") "Guess the number (it has 4 digits and each digit exists only once): $randomNumber"
            else "Guess again"
        )
        userInput = readLine().toString()
//wenn nicht 4 unique chars
        if (howManyUniqueCharsInString(userInput) < 4)
            println("No repeating digits allowed and input must be 4 numbers")
        else if (userInput.length > 4)
            println("Only 4 numbers!")
        else {
            currentTry = checkWhichCharsAreInBothStrings(
                userInput,
                randomNumber
            )
            triedList.add(Pair(currentTry, userInput))
            println("$currentTry \nRP = Right position, WP = Wrong position, NC = Not contained \n")
            println("Tried so far: \n")
            triedList.forEach { println(it) }
            if (randomNumber != userInput) {
                println("\nDo you want to give up? (y/n) ")
                givenUp = readStringInput(mutableListOf("y", "n"))
                println(if (givenUp == "y") "Random number is $randomNumber" else continue)
            } else {
                println("Congratulations you have guessed the number")
            }
        }
    } while ((userInput != randomNumber) && givenUp != "y")
}

/**
 * Returns user input if it is in the list which is given as parameter
 */
fun readStringInput(allowed: MutableList<String>): String {
    var input: String
    do {
        println("Allowed inputs: $allowed")
        input = readLine().toString()
    } while (!allowed.contains(input))
    return input
}

/**
 * Returns a list of elements which state the correctnes of the char relativ to the randomNumber
 * RP = Right position, WP = contains but wrong position NC = not contained
 */
fun checkWhichCharsAreInBothStrings(userInput: String, randomNumber: String): List<PositionInString> {
    val positionRightList = mutableListOf<PositionInString>()
    userInput.forEachIndexed { index, c ->
        positionRightList.add(
            when {
                randomNumber[index] == c -> PositionInString.RP
                randomNumber.contains(c.toString()) -> PositionInString.WP
                else -> PositionInString.NC
            }
        )
    }
//oder einfach return positionRightList --> Dann ist RP, WP, NC den jeweiligen Ziffern zugeordnet-leichter zu gewinnen
    return positionRightList.sortedBy { it.ordinal }
}
/**
 * Returns how many unique chars there are in a string
 */
fun howManyUniqueCharsInString(input: String): Int {
    val set = mutableSetOf<Char>()
    input.forEach { set.add(it) }
    return set.size
}