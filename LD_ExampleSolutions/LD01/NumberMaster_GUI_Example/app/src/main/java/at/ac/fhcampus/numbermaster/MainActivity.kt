package at.ac.fhcampus.numbermaster

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private val randomNumbers: MutableList<String> = ArrayList()
    private val guesses: MutableList<GuessItem> = ArrayList()
    private val adapter = CustomAdapter(guesses as ArrayList<GuessItem>)
    private lateinit var userGuessesRecycler: RecyclerView
    private lateinit var myDialog: Dialog
    private lateinit var restartOrGiveUp: Button
    private lateinit var exitOrContinue: Button
    private lateinit var dialogParagraph: TextView
    private lateinit var dialogHeader: TextView
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userGuessesRecycler = findViewById(R.id.userGuesses)
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, true)
        layoutManager.stackFromEnd = true
        userGuessesRecycler.layoutManager = layoutManager
        userGuessesRecycler.adapter = adapter

        generateRandomNumber()
    }



    /**Method that is called when the give up button is pressed*/
    fun giveUp(view: View){
        gameOver(false)
    }

    /**Method that calls when the guess button is pressed
     * count: keeps track of the user guesses
     * the guess is further processed by processGuess()
     * */
    fun submitGuess(view: View) {
        count++
        val guessTextView = findViewById<EditText>(R.id.user_input)
        val guess = guessTextView.text.toString()
        processGuess(guess)
        guessTextView.text.clear()
        checkWinner(guess)
    }

    private fun processGuess(guess: String) {
        if (guess.length == 4){
            mapDigitToSymbol(guess)
        }
        else
            Toast.makeText(this, "Guess should has 4 Digits!", Toast.LENGTH_SHORT).show()
    }

    /**
     * method that examines each digit and bind it with the right symbol (check mark, square, cross )
     * The algorithm examines each digit. If the digit is correct it will be bind with a check mark symbol
     * and the digit will be replaced with and "-" so it does not get checked again.
     * If the digit is correct but in the wrong place it will get a square symbol and will also be replaced
     * otherwise -> cross symbol
     * */
    private fun mapDigitToSymbol(guess: String){
        var guessClone = guess
        val symbolsArray: MutableList<Int> = ArrayList()// holds the symbols for each guess
        val numbers: String = randomNumbers.joinToString("")
        println("\n\n$numbers")
        for (i in 0..3) {
            if (numbers[i] == guessClone[i]) {
                guessClone = guessClone.replaceFirst("${guessClone[i]}", "-")
                symbolsArray.add(R.drawable.symbol_1hakerl)
            }
            /*if the user's guess contains the i digit of the right number
            * i get the index of this digit in the guess and check that
            * the guess[index] != the rightNumber[index] because otherwise it should be a correct
            * digit -> check mark. if its not the same, than the digits get square symbol*/
            else if (guessClone.contains(numbers[i])) {
                val index = guessClone.indexOf(numbers[i])

                if (guessClone[index] == numbers[index]) {
                    guessClone = guessClone.replaceFirst("${guessClone[index]}", "-")
                    symbolsArray.add(R.drawable.symbol_1hakerl)
                }else{
                    guessClone = guessClone.replaceFirst("${guessClone[index]}", "-")
                    symbolsArray.add(R.drawable.symbol_2square)
                }
            }
        }
        while (symbolsArray.size < 4)
            symbolsArray.add(R.drawable.symbol_3kreuz)

        /*the array is sorted in order to always have the check mark first, after that the square
        * and the cross in the End.*/
        symbolsArray.sort()
        addGuessToList(guess, symbolsArray)
    }


    private fun checkWinner(guess: String){
        if (verifyGuess(guess))
            gameOver(true)
    }

    /**adds the guess with the symbols the recycler list*/
    private fun addGuessToList(guess: String, symbolsArray: MutableList<Int>){
        guesses.add(
            GuessItem(
                "${count}.",
                guess,
                symbolsArray[0],
                symbolsArray[1],
                symbolsArray[2],
                symbolsArray[3]
            )
        )
        adapter.notifyDataSetChanged()
        userGuessesRecycler.smoothScrollToPosition(adapter.itemCount)
    }

    /**reset the components to start a new game*/
    private fun restartGame(){
        count = 0
        generateRandomNumber()
        guesses.clear()
        adapter.notifyDataSetChanged()
    }

    /**Initializes the dialog and it's components */
    private fun initializeDialog(){

        myDialog = Dialog(this)
        myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        myDialog.setContentView(R.layout.dialog_custom)
        myDialog.setCancelable(false)
        myDialog.show()
        restartOrGiveUp = myDialog.findViewById(R.id.restart_button)
        exitOrContinue = myDialog.findViewById(R.id.exit_button)
        dialogParagraph = myDialog.findViewById(R.id.custom_dialog_paragraph)
        dialogHeader = myDialog.findViewById(R.id.custom_dialog_header)
    }

    /**responsible for the dialog that pops up if the user wins or gives up*/
    private fun gameOver(winner: Boolean) {
        initializeDialog()
        /*if the user won!*/
        if (winner){
            myDialog.setTitle("WINNER!")
            restartOrGiveUp.text = getString(R.string.restart_button)
            exitOrContinue.text = getString(R.string.exit_button)
            dialogHeader.text = getString(R.string.winner_header)
            dialogParagraph.text = "You won! .. after $count guesses"
            //dialogImage.setImageResource(R.drawable.person_winning)
        }
        /*if the user gave up!!*/
        else{
            myDialog.setTitle("Giving Up!")
            restartOrGiveUp.text = getString(R.string.dialog_giveup_button)
            exitOrContinue.text = getString(R.string.dialog_continue_button)
            dialogHeader.text = getString(R.string.give_up_header)
            dialogParagraph.text = getString(R.string.give_up_text)
        }

        restartOrGiveUp.setOnClickListener(View.OnClickListener {
            run {
                if (!winner)
                    Toast.makeText(this, "The Number was: ${randomNumbers.joinToString("")}", Toast.LENGTH_SHORT).show()
                myDialog.dismiss()
                restartGame()
            }
        })
        exitOrContinue.setOnClickListener(View.OnClickListener {
            run {
                myDialog.dismiss()
                if (winner)
                    finish()
            }
        })

    }

    /**Generates one random number from 0 - 9*/
    private fun generateRandomNumber() {
        var randomNum: Int
        randomNumbers.clear()
        for (i in 0..3) {
            randomNum = (0..9).random()
            randomNumbers.add(randomNum.toString())
        }
    }

    /**Returns true if user's guess matches our generated number*/
    private fun verifyGuess(guess: String): Boolean {
        if (randomNumbers.size == 4) {
            val numbers = randomNumbers.joinToString("")
            return numbers == guess
        }
        return false
    }
}

