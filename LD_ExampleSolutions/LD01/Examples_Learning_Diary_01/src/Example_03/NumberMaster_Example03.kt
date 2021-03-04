package Example_03

fun main(){
    var arr = arrayOf(" "," "," "," ")
    var randomNumber: String = ""

    do {
        arr = arrayOf((0..9).random().toString(), (0..9).random().toString(), (0..9).random().toString(), (0..9).random().toString())
    } while (arr[0] == arr[1] || arr[0] == arr[2] || arr[0] == arr[3] || arr[1] == arr[2] || arr[2] == arr[3])

    for(char in arr) randomNumber = randomNumber + char

    var solved: Boolean = false
    var rightDigit: Int = 0
    var rightPlace: Int = 0
    var counter: Int = 1
    // uncommend this for easier testing
    // println(randomNumber)

    while(!solved) {
        println("Enter your four digit guess")
        var userInput = readLine()!!

        if (userInput == randomNumber) {
            solved = true
            println("Congrats, you guessed right! You needed $counter guesses")
        } else {
            for(digit in randomNumber) {
                for(guessed in userInput) {
                    if(digit == guessed) rightDigit++
                    if(digit == guessed && randomNumber.indexOf(digit) == userInput.indexOf(guessed)) rightPlace++
                }
            }
            var falsePlace: Int = rightDigit-rightPlace
            println("$falsePlace digit(s) are correct but on the false position" +
                    " & $rightPlace digit(s) are on the right position")
            rightDigit = 0
            rightPlace = 0
        }
        counter++
    }
}