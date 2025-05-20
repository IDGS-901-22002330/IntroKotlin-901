package com.example.introkotlin_901.ejemplo01

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin_901.R

class SumaActivity : AppCompatActivity() {
    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var tv1: TextView
    private lateinit var radioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_suma)

        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        tv1 = findViewById(R.id.tv1)
        radioGroup = findViewById(R.id.radioGroupOperations)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcular(view: View?) {
        val str1 = et1.text.toString()
        val str2 = et2.text.toString()

        if (str1.isEmpty() || str2.isEmpty()) {
            tv1.text = "Por favor, introduce ambos números"
            return
        }

        val num1 = str1.toDouble()
        val num2 = str2.toDouble()

        when (radioGroup.checkedRadioButtonId) {
            R.id.rb1 -> {
                val suma = num1 + num2
                tv1.text = "Resultado = $suma"
            }
            R.id.rb2 -> {
                val resta = num1 - num2
                tv1.text = "Resultado = $resta"
            }
            R.id.rb3 -> {
                val multiplicacion = num1 * num2
                tv1.text = "Resultado = $multiplicacion"
            }
            R.id.rb4 -> {
                if (num2 != 0.0) {
                    val division = num1 / num2
                    tv1.text = "Resultado = $division"
                } else {
                    tv1.text = "No se puede dividir entre 0"
                }
            }
            else -> {
                tv1.text = "Selecciona una operación"
            }
        }
    }
}
