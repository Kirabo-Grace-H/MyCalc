package com.kotlin.mycalc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var plus :Button
    private lateinit var minus:Button
    private lateinit var multi:Button
    private lateinit var divide :Button
    private lateinit var firstnum:EditText
    private lateinit var secondnum:EditText
    private lateinit var answer:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        plus = findViewById(R.id.buttonplus)
        minus = findViewById(R.id.buttonminus)
        multi = findViewById(R.id.buttonmulti)
        divide = findViewById(R.id.buttondiv)
        firstnum = findViewById(R.id.etfirst)
        secondnum = findViewById(R.id.etsecond)
        answer = findViewById(R.id.tvanswer)

        plus.setOnClickListener {
           calculate("+")
        }
        minus.setOnClickListener {
            calculate("-")
        }
        divide.setOnClickListener {
            calculate("/")
        }
        multi.setOnClickListener {
            calculate("*")
        }

    }
    fun calculate(operator:String){
        val first= firstnum.text.toString().toDouble()
        val second= secondnum.text.toString().toDouble()
        if (first==null&&second==null){
            answer.text="Invalid Input"
            return
        }
        val result= when(operator){
            "+"->first + second
            "-"-> first - second
            "/"-> first / second
            "*"-> first * second
            else-> {
                answer.text = "Invalid operator"
                return
            }
        }

        answer.text= "Result:$result"

    }

}