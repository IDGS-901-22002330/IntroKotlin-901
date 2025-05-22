package com.example.introkotlin_901.cinepolis

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.introkotlin_901.R

class CinepolisActivity : AppCompatActivity() {
private val precioUnitario = 12
private val descuentoTarjeta = 0.1

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_cinepolis)

    val etNombre = findViewById<EditText>(R.id.etNombre)
    val etPersonas = findViewById<EditText>(R.id.etCantPersonas)
    val etBoletos = findViewById<EditText>(R.id.etCantBoletos)
    val rgTarjeta = findViewById<RadioGroup>(R.id.rgTarjeta)
    val tvResultado = findViewById<TextView>(R.id.tvResultado)
    val btnCalcular = findViewById<Button>(R.id.btnCalcular)

    btnCalcular.setOnClickListener {
        val nombre = etNombre.text.toString().trim()
        val numPersonas = etPersonas.text.toString().toIntOrNull() ?: 0
        var numBoletos = etBoletos.text.toString().toIntOrNull() ?: 0
        val usaTarjeta = rgTarjeta.checkedRadioButtonId == R.id.rbSi
        val maxBoletos = numPersonas * 7

        if (nombre.isEmpty()) {
            etNombre.error = "Ingrese su nombre"
            return@setOnClickListener
        }
        if (numPersonas !in 1..maxBoletos) {
            etPersonas.error = "1 a $maxBoletos"
            return@setOnClickListener
        }
        if (numBoletos !in 1..maxBoletos) {
            etBoletos.error = "1 a $maxBoletos"
            return@setOnClickListener
        }

        // Cálculo
        val subtotal = numBoletos * precioUnitario
        val descuento = calcularDescuento(numBoletos, subtotal, usaTarjeta)
        val total = subtotal - descuento

        tvResultado.text = "$ ${"%.2f".format(total)}"
    }
}

private fun calcularDescuento(totalBoletos: Int, precioTotal: Int, usaTarjeta: Boolean): Double {
    var desc = 0.0
    if (totalBoletos > 5) desc += precioTotal * 0.15
    else if (totalBoletos in 3..5) desc += precioTotal * 0.10
    if (usaTarjeta) desc += (precioTotal - desc) * descuentoTarjeta
    return desc
}
}