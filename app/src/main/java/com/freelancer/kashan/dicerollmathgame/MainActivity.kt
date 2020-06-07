package com.freelancer.kashan.dicerollmathgame

import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
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
    lateinit var txtScore : TextView
    lateinit var txtLife : TextView
    lateinit var editText: EditText
    lateinit var rootView : View

    var totalValue = -1
    var life = 3
    var score = 0
    var totalCalc = 0
    var dice1_val = 0
    var dice2_val = 0
    var dice3_val = 0
    var dice4_val = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)
        diceImage3 = findViewById(R.id.dice_image3)
        diceImage4 = findViewById(R.id.dice_image4)
        sign_plus = findViewById(R.id.sign_image_plus)
        sign_plus2 = findViewById(R.id.sign_image_plus2)
        sign_multiply = findViewById(R.id.sign_image_multiply)
        sign_equal = findViewById(R.id.sign_image_equal)
        txtScore = findViewById(R.id.textScore)
        txtLife = findViewById(R.id.textLife)
        editText = findViewById(R.id.editText)
        rootView = getWindow().getDecorView().getRootView()

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { checkAndRoll() }
        rollDice()
    }

    private fun checkAndRoll() {
        val isValidAnswer : Boolean = checkAnswer()

        if (isValidAnswer)
        {
            rollDice()
            findTotal()
        }
        else
        {
            Snackbar.make(rootView, "Valid Answer is Required", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun rollDice() {
        diceImage1.setImageResource(getRandomDiceImage(1))
        diceImage2.setImageResource(getRandomDiceImage(2))
        diceImage3.setImageResource(getRandomDiceImage(3))
        diceImage4.setImageResource(getRandomDiceImage(4))
        sign_plus.setImageResource(R.drawable.plus_sign)
        sign_plus2.setImageResource(R.drawable.plus_sign)
        sign_multiply.setImageResource(R.drawable.mutiply_sign)
        sign_equal.setImageResource(R.drawable.equal_sign)
    }

    private fun getRandomDiceImage(dice_var: Int): Int {
        fun IntRange.random() = Random().nextInt((endInclusive + 1) - start) + start
        val randomInt = (1..6).random()

        when(dice_var)
        {
            1 -> dice1_val = randomInt
            2 -> dice2_val = randomInt
            3 -> dice3_val = randomInt
            4 -> dice4_val = randomInt
        }

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

    private fun checkAnswer() : Boolean {
        try{
            totalValue = editText.text.toString().toInt()
        }
        catch (e: Exception)
        {
            return false
        }

        if (totalValue != -1)
        {
            if (totalValue == totalCalc)
            {
                //Correct Answer
                score++
                txtScore.setText(score.toString())
                Snackbar.make(rootView, "Correct Answer", Snackbar.LENGTH_LONG).show()
            }
            else
            {
                //Incorrect Answer
                if (life > 0)
                {
                    life--
                    txtLife.setText(life.toString())
                    Snackbar.make(rootView, "Incorrect Answer", Snackbar.LENGTH_LONG).show()
                }
                else
                {
                    finish()
                    moveTaskToBack(true)
                }
            }
        }
        editText.setText("")

        return true
    }

    private fun findTotal() {
        totalCalc = (dice1_val + dice2_val) * (dice3_val + dice4_val)
    }
}
