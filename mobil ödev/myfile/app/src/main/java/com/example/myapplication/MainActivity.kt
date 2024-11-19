package com.example.simplecalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val firstNumberEditText: EditText = findViewById(R.id.firstNumber)
        val secondNumberEditText: EditText = findViewById(R.id.secondNumber)
        val resultText: TextView = findViewById(R.id.resultText)


        val btnToplama: Button = findViewById(R.id.btnToplama)
        val btnCikarma: Button = findViewById(R.id.btnCikarma)
        val btnCarpma: Button = findViewById(R.id.btnCarpma)
        val btnBolme: Button = findViewById(R.id.btnBolme)


        btnToplama.setOnClickListener {
            val num1 = getNumber(firstNumberEditText)
            val num2 = getNumber(secondNumberEditText)
            if (num1 != null && num2 != null) {
                resultText.text = "Sonuç: ${topla(num1, num2)}"
            }
        }


        btnCikarma.setOnClickListener {
            val num1 = getNumber(firstNumberEditText)
            val num2 = getNumber(secondNumberEditText)
            if (num1 != null && num2 != null) {
                resultText.text = "Sonuç: ${cikarma(num1, num2)}"
            }
        }


        btnCarpma.setOnClickListener {
            val num1 = getNumber(firstNumberEditText)
            val num2 = getNumber(secondNumberEditText)
            if (num1 != null && num2 != null) {
                resultText.text = "Sonuç: ${carpma(num1, num2)}"
            }
        }


        btnBolme.setOnClickListener {
            val num1 = getNumber(firstNumberEditText)
            val num2 = getNumber(secondNumberEditText)
            if (num1 != null && num2 != null) {
                if (num2 != 0.0) {
                    resultText.text = "Sonuç: ${bolme(num1, num2)}"
                } else {
                    Toast.makeText(this, "Bir sayıyı sıfıra bölemezsiniz!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    private fun getNumber(editText: EditText): Double? {
        return try {
            editText.text.toString().toDouble()
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Lütfen geçerli bir sayı girin!", Toast.LENGTH_SHORT).show()
            null
        }
    }


    private fun topla(a: Double, b: Double): Double {
        return a + b
    }


    private fun cikarma(a: Double, b: Double): Double {
        return a - b
    }


    private fun carpma(a: Double, b: Double): Double {
        return a * b
    }


    private fun bolme(a: Double, b: Double): Double {
        return a / b
    }
}
