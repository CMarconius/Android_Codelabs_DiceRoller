package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.superMegaButton4000)

        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val diceSizeInput : TextInputEditText = findViewById(R.id.diceSizeInput)
        var diceSize = 20
        if (!diceSizeInput.text.toString().isNullOrBlank()) {
            diceSize = Integer.parseInt(diceSizeInput.text.toString())
        }
        val dice = Dice(diceSize)

        val diceRoll = dice.roll()

        // Update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.superMegaDiceRollText)

        resultTextView.text = diceRoll.toString()

        when(diceRoll) {
            20 -> println("Holy potatoes! NAT 20!!!")
        }
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {

        return (1..numSides).random()
    }
}