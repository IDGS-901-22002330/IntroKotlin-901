package com.example.introkotlin_901.diccionario

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.introkotlin_901.R
import java.io.OutputStreamWriter

class CapturarActivity : AppCompatActivity() {

    private lateinit var campoPalabraIngles: EditText
    private lateinit var campoPalabraEspanol: EditText
    private lateinit var botonGuardarPalabras: Button
    private lateinit var botonRegresarMenuAgregar: Button

    private val NOMBRE_ARCHIVO = "palabras.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capturar)

        campoPalabraIngles = findViewById(R.id.campo_palabra_ingles)
        campoPalabraEspanol = findViewById(R.id.campo_palabra_espanol)
        botonGuardarPalabras = findViewById(R.id.boton_guardar_palabras)
        botonRegresarMenuAgregar = findViewById(R.id.boton_regresar_menu_agregar)

        botonGuardarPalabras.setOnClickListener {
            guardarPalabra()
        }

        botonRegresarMenuAgregar.setOnClickListener {
            finish()
        }
    }

    private fun guardarPalabra() {
        val palabraIngles = campoPalabraIngles.text.toString().trim()
        val palabraEspanol = campoPalabraEspanol.text.toString().trim()

        if (palabraIngles.isEmpty() || palabraEspanol.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa ambas palabras.", Toast.LENGTH_SHORT).show()
            return
        }

        val lineaAGuardar = "$palabraIngles,$palabraEspanol\n"

        try {
            openFileOutput(NOMBRE_ARCHIVO, Context.MODE_APPEND).use { fileOutputStream ->
                OutputStreamWriter(fileOutputStream).use { outputStreamWriter ->
                    outputStreamWriter.write(lineaAGuardar)
                }
            }
            Toast.makeText(this, "Palabras almacenadas correctamente!", Toast.LENGTH_SHORT).show()
            campoPalabraIngles.text.clear()
            campoPalabraEspanol.text.clear()
        } catch (e: Exception) {
            Toast.makeText(this, "Error al almacenar las palabras.", Toast.LENGTH_SHORT).show()
        }
    }
}