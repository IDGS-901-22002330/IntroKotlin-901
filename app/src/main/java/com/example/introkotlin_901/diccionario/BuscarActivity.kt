package com.example.introkotlin_901.diccionario

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.introkotlin_901.R
import java.io.BufferedReader
import java.io.InputStreamReader

class BuscarActivity : AppCompatActivity() {

    private lateinit var campoBuscarPalabra: EditText
    private lateinit var grupoOpcionesBusqueda: RadioGroup
    private lateinit var radioBuscarEspanol: RadioButton
    private lateinit var radioBuscarIngles: RadioButton
    private lateinit var botonBuscarPalabra: Button
    private lateinit var botonRegresarMenuBuscar: Button
    private lateinit var textoResultadoBusqueda: TextView

    private val NOMBRE_ARCHIVO = "palabras.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar)

        campoBuscarPalabra = findViewById(R.id.campo_buscar_palabra)
        grupoOpcionesBusqueda = findViewById(R.id.grupo_opciones_busqueda)
        radioBuscarEspanol = findViewById(R.id.radio_buscar_espanol)
        radioBuscarIngles = findViewById(R.id.radio_buscar_ingles)
        botonBuscarPalabra = findViewById(R.id.boton_buscar_palabra)
        botonRegresarMenuBuscar = findViewById(R.id.boton_regresar_menu_buscar)
        textoResultadoBusqueda = findViewById(R.id.texto_resultado_busqueda)


        botonBuscarPalabra.setOnClickListener {
            buscarPalabra()
        }

        botonRegresarMenuBuscar.setOnClickListener {
            finish()
        }
    }

    private fun buscarPalabra() {
        val palabraABuscar = campoBuscarPalabra.text.toString().trim()

        if (palabraABuscar.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa una palabra para buscar.", Toast.LENGTH_SHORT).show()
            return
        }

        val idOpcionSeleccionada = grupoOpcionesBusqueda.checkedRadioButtonId
        if (idOpcionSeleccionada == -1) {
            Toast.makeText(this, "Por favor, selecciona una opción de búsqueda.", Toast.LENGTH_SHORT).show()
            return
        }

        val buscarEnIngles = (idOpcionSeleccionada == radioBuscarEspanol.id)

        var resultado = "Palabra no encontrada."

        try {
            openFileInput(NOMBRE_ARCHIVO).use { fileInputStream ->
                InputStreamReader(fileInputStream).use { inputStreamReader ->
                    BufferedReader(inputStreamReader).use { bufferedReader ->
                        var linea: String?
                        while (bufferedReader.readLine().also { linea = it } != null) {
                            val partes = linea?.split(",")
                            if (partes != null && partes.size == 2) {
                                val palabraGuardadaIngles = partes[0].trim()
                                val palabraGuardadaEspanol = partes[1].trim()

                                if (buscarEnIngles) {
                                    if (palabraGuardadaIngles.equals(palabraABuscar, ignoreCase = true)) {
                                        resultado = "Español: $palabraGuardadaEspanol"
                                        break
                                    }
                                } else {
                                    if (palabraGuardadaEspanol.equals(palabraABuscar, ignoreCase = true)) {
                                        resultado = "Inglés: $palabraGuardadaIngles"
                                        break
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (e: Exception) {
            resultado = "Error al leer el archivo de palabras."
        }
        textoResultadoBusqueda.text = resultado
    }
}