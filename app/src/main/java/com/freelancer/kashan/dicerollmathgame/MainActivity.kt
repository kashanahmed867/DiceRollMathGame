package com.freelancer.kashan.dicerollmathgame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import java.util.Random

class MainActivity : AppCompatActivity() {

    lateinit var diceImage1 : ImageView
    lateinit var diceImage2 : ImageView
    lateinit var diceImage3 : ImageView
    lateinit var diceImage4 : ImageView
    lateinit var sign_plus : ImageView
    lateinit var sign_plus2 : ImageView
    lateinit var sign_multiply : ImageView
    lateinit var sign_equal : ImageView
    lateinit var editText: EditText

    var totalCalc = 0
    var totalValue = -1
    var dice1_val = 0
    var dice2_val = 0
    var dice3_val = 0
    var dice4_val = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)
        diceImage3 = findViewById(R.id.dice_image3)
        diceImage4 = findViewById(R.id.dice_image4)
        sign_plus = findViewById(R.id.sign_image_plus)
        sign_plus2 = findViewById(R.id.sign_image_plus2)
        sign_multiply = findViewById(R.id.sign_image_multiply)
        sign_equal = findViewById(R.id.sign_image_equal)
        editText = findViewById(R.id.editText)
        rollButton.setOnClickListener { rollDice() }
        rollDice()
    }

    private fun rollDice(){
        if (totalValue != -1)
        {
            if (totalValue == totalCalc)
            {
                //Correct Answer

            }
            else
            {
                //Incorrect Answer

            }
        }

        diceImage1.setImageResource(getRandomDiceImage())
        diceImage2.setImageResource(getRandomDiceImage())
        diceImage3.setImageResource(getRandomDiceImage())
        diceImage4.setImageResource(getRandomDiceImage())
        sign_plus.setImageResource(R.drawable.plus_sign)
        sign_plus2.setImageResource(R.drawable.plus_sign)
        sign_multiply.setImageResource(R.drawable.mutiply_sign)
        sign_equal.setImageResource(R.drawable.equal_sign)
    }

    private fun getRandomDiceImage(): Int{
        fun IntRange.random() = Random().nextInt((endInclusive + 1) - start) + start
        val randomInt = (1..6).random()

        val drawelResource = when(randomInt){
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }
        return drawelResource
    }

}
