package com.example.quchashi

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var button10: Button
    private lateinit var button11: Button
    private lateinit var button12: Button
    private lateinit var button13: Button
    private lateinit var button14: Button
    private lateinit var button15: Button
    private lateinit var button16: Button
    private lateinit var resetButton: Button
    private var random = mutableListOf<Int>()
    private var buttonCount = 0
    private var counter = 2
    private var returnTrueCounter = 0
    private lateinit var array: List<Button>
    private var saveButtonNumber = 0
    private var saveSymbol1 = ""
    private var saveNumber = mutableListOf<Int>()
    private var symbols = listOf(
        "X",
        "X",
        "M",
        "M",
        "Q",
        "Q",
        "W",
        "W",
        "T",
        "T",
        "R",
        "R",
        "Y",
        "Y",
        "U",
        "U"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val hideName: ActionBar? = supportActionBar
        hideName?.hide()
        init()
    }
    private fun init() {
        button1 = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        button10 = findViewById(R.id.button10)
        button11 = findViewById(R.id.button11)
        button12 = findViewById(R.id.button12)
        button13 = findViewById(R.id.button13)
        button14 = findViewById(R.id.button14)
        button15 = findViewById(R.id.button15)
        button16 = findViewById(R.id.button16)
        resetButton = findViewById(R.id.reset)
        array = listOf(
            button1, button2,button3,button4,button5,button6,button7,button8,
            button9,button10,button11,button12,button13,button14,button15,
            button16
        )

       for(i in 0..15){
           array[i].setOnClickListener(this)
       }
        resetButton.setOnClickListener {
            random.clear()
            saveNumber.clear()
            button1.text = ""
            for (i in 0..15) {
                array[i].isEnabled = true
                array[i].setBackgroundColor(Color.parseColor("#DFD0D0"))
                array[i].text = ""
            }
            counter = 2
            saveButtonNumber = 0
            saveSymbol1 = ""
            buttonCount = 0
            returnTrueCounter = 0
        }


    }

    private fun random() {
        buttonCount = Random.nextInt(16 - 0)
    }

    override fun onClick(clickedView: View?) {
        if (clickedView is Button) {
            if(counter == 2){
                defineRandom()
            }
            var buttonNumber = 0
            val handler = Handler()
            when (clickedView.id) {
                R.id.button -> {
                    button1.text = symbols[random[0]]
                    buttonNumber = 1
                }
                R.id.button2 -> {
                    button2.text = symbols[random[1]]
                    buttonNumber = 2
                }
                R.id.button3 -> {
                    buttonNumber = 3
                    button3.text = symbols[random[2]]
                }
                R.id.button4 -> {
                    buttonNumber = 4
                    button4.text = symbols[random[3]]
                }
                R.id.button5 -> {
                    buttonNumber = 5
                    button5.text = symbols[random[4]]
                }
                R.id.button6 -> {
                    buttonNumber = 6
                    button6.text = symbols[random[5]]
                }
                R.id.button7 -> {
                    buttonNumber = 7
                    button7.text = symbols[random[6]]
                }
                R.id.button8 -> {
                    buttonNumber = 8
                    button8.text = symbols[random[7]]
                }
                R.id.button9 -> {
                    buttonNumber = 9
                    button9.text = symbols[random[8]]
                }
                R.id.button10 -> {
                    buttonNumber = 10
                    button10.text = symbols[random[9]]
                }
                R.id.button11 -> {
                    buttonNumber = 11
                    button11.text = symbols[random[10]]
                }
                R.id.button12 -> {
                    buttonNumber = 12
                    button12.text = symbols[random[11]]
                }
                R.id.button13 -> {
                    buttonNumber = 13
                    button13.text = symbols[random[12]]
                }
                R.id.button14 -> {
                    buttonNumber = 14
                    button14.text = symbols[random[13]]
                }
                R.id.button15 -> {
                    buttonNumber = 15
                    button15.text = symbols[random[14]]
                }
                R.id.button16 -> {
                    buttonNumber = 16
                    button16.text = symbols[random[15]]
                }
            }

            clickedView.setBackgroundColor(Color.GRAY)
            clickedView.isEnabled = false
            counter++
            if (counter % 2 == 1) {
                saveButtonNumber = buttonNumber
                saveSymbol1 = clickedView.text.toString()
            }
            if(counter % 2 ==0 && !check(saveSymbol1, buttonNumber)) {
                turnOff()
                handler.postDelayed({
                    clickedView.isEnabled = true
                    array[saveButtonNumber - 1].isEnabled = true
                    clickedView.text = " "
                    clickedView.setBackgroundColor(Color.parseColor("#DFD0D0"))
                    array[saveButtonNumber - 1].text = " "
                    array[saveButtonNumber - 1].setBackgroundColor(Color.parseColor("#DFD0D0"))
                    turnOn()
                }, 500)
            }
            if(counter % 2 ==0 && check(saveSymbol1, buttonNumber)){
                returnTrueCounter++
            }

            if(returnTrueCounter == 8){
                Toast.makeText(this, "Finished", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun check(symbol: String, Number: Int):Boolean {
        var compare = ""
        when(Number){

            1 -> compare = button1.text.toString()
            2 -> compare = button2.text.toString()
            3 -> compare = button3.text.toString()
            4 -> compare = button4.text.toString()
            5 -> compare = button5.text.toString()
            6 -> compare = button6.text.toString()
            7 -> compare = button7.text.toString()
            8 -> compare = button8.text.toString()
            9 -> compare = button9.text.toString()
            10 -> compare = button10.text.toString()
            11 -> compare = button11.text.toString()
            12 -> compare = button12.text.toString()
            13 -> compare = button13.text.toString()
            14 -> compare = button14.text.toString()
            15 -> compare = button15.text.toString()
            16 -> compare = button16.text.toString()

        }
        return compare == symbol

    }
    private fun defineRandom(){
        for(k in 0..15){
            random()
            while (buttonCount in saveNumber) {
                random()
            }
            val temporary = buttonCount
            saveNumber.add(buttonCount)
            random.add(temporary)
        }
    }
    private fun turnOn(){
        for(i in 0..15){
            array[i].isClickable = true
        }
        resetButton.isClickable = true
    }
    private fun turnOff() {
        for(i in 0..15){
            array[i].isClickable = false
        }
        resetButton.isClickable = false
    }
}
