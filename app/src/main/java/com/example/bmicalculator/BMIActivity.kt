package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BMIActivity : AppCompatActivity() {
    var bmiValue: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculate)

        val personName = intent?.getStringExtra("personName")

        val name = findViewById<TextView>(R.id.txtName)
        name.setText(personName)

        if(savedInstanceState != null){
            bmiValue = savedInstanceState.getDouble("bmiValue")
            val status = findViewById<TextView>(R.id.txtStatus)
            status.setText(bmiStatus())
        }

        val status = findViewById<TextView>(R.id.txtStatus)

        val btn = findViewById<Button>(R.id.btnCalculate)

        btn.setOnClickListener {
            val weight = findViewById<TextView>(R.id.editTextWeight).text.toString().toDouble()
            val height = findViewById<TextView>(R.id.editTextHeight).text.toString().toDouble()

            bmiValue = weight / (height*height)

            status.setText(bmiStatus())

        }
    }

    override fun onSaveInstanceState(outState: Bundle){
        super.onSaveInstanceState(outState)

        outState.putDouble("bmiValue", bmiValue)
    }

    fun bmiStatus():String{
        if(bmiValue < 18.5){
            return "Underweight"
        }else if(bmiValue < 24.9){
            return "Normal Weight"
        }else if(bmiValue < 29.9) {
            return "OverWeight"
        }else if(bmiValue < 34.9) {
            return "Obesity Class 1"
        }else if(bmiValue < 34.9) {
            return "Obesity Class 2"
        }else
            return "Obesity Class 3"
    }

}