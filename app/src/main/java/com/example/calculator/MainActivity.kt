package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.TextureView
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.example.calculator.R
import kotlin.math.pow

class MainActivity : AppCompatActivity() {


    private lateinit var resultTextView: TextView
    private var operand  = 0.0
    private var operation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
        // credits to shavi cxeni

        resultTextView = findViewById(R.id.resultTextView)
    }

    fun numberClick(clickedView:View){
        if (clickedView is TextView){
            var text = resultTextView.text.toString()
            val number = clickedView.text.toString()
            if (text == "0"){
                text = ""
            }
            if (number == "."){
                if("." !in text){
                    resultTextView.text = text + number
                }
            }
            else{
                resultTextView.text = text + number
            }

        }
    }

    fun operationClick(clickedView:View){
        if (clickedView is TextView){
            if(resultTextView.text != ""){
                operand = resultTextView.text.toString().toDouble()
            }
            operation = clickedView.text.toString()
            resultTextView.text = ""
        }
    }


    fun equalsClick(clickedView: View) {
        if (resultTextView.text != "") {
            val secondOperand = resultTextView.text.toString().toDouble()
            when (operation) {
                "+" -> resultTextView.text = (operand + secondOperand).toString()
                "-" -> resultTextView.text = (operand - secondOperand).toString()
                "*" -> resultTextView.text = (operand * secondOperand).toString()
                "/" -> resultTextView.text = (operand / secondOperand).toString()
                "x^y" ->resultTextView.text = (operand.pow(secondOperand)).toString()
                "%" -> resultTextView.text = ((operand * secondOperand) / 100).toString()

            }
            if (resultTextView.text.toString().toDouble() % 1.0 == 0.0 ){
                resultTextView.text = resultTextView.text.toString().dropLast(2)

            }
        }
    }

    fun deleteClick(clickedView: View){
        val result = resultTextView.text.toString()
            resultTextView.text = result.dropLast(1)
        }

    fun clearClick(clickedView: View){
        if(resultTextView.text != ""){
            resultTextView.text = ""
            operand = 0.0
            operation = ""

        }
    }

}



