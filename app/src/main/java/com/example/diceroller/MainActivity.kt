package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val luckyNumber = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollBtn : Button = findViewById(R.id.button)
        rollBtn.setOnClickListener{ rollDice() }
    }

    private fun rollDice(){
        val dice = Dice(6)
        val diceImage : ImageView = findViewById(R.id.imageView)
        val rollValue = dice.roll()

        when(rollValue){
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            else -> diceImage.setImageResource(R.drawable.dice_6)
        }

        diceImage.contentDescription = rollValue.toString()
    }
}

class Dice(private val numSide: Int){
    fun roll(): Int{
        return (1..numSide).random()
    }
}