package com.example.introkotlin_901

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin_901.cinepolis.CinepolisActivity
import com.example.introkotlin_901.diccionario.MenuDiccionarioActivity
import com.example.introkotlin_901.ejemplo01.SumaActivity
import com.example.introkotlin_901.ejemplo02.SaludoActivity


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnCalcular = findViewById<Button>(R.id.btn1)
        val btnCinepolis = findViewById<Button>(R.id.btn2)
        val btnSaludo = findViewById<Button>(R.id.btn3)
        val btnDiccionario = findViewById<Button>(R.id.btn4)

        btnCalcular.setOnClickListener { navegateToCalcular() }
        btnCinepolis.setOnClickListener { navegateToCinepolis() }
        btnSaludo.setOnClickListener { navegateToSaludo() }
        btnDiccionario.setOnClickListener { navegateToDiccionario() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

private fun MenuActivity.navegateToDiccionario() {
    val intent = Intent(this, MenuDiccionarioActivity::class.java)
    startActivity(intent)
}

private fun MenuActivity.navegateToSaludo() {
    val intent = Intent(this, SaludoActivity::class.java)
    startActivity(intent)
}

private fun MenuActivity.navegateToCinepolis() {
    val intent = Intent(this, CinepolisActivity::class.java)
    startActivity(intent)
}

private fun MenuActivity.navegateToCalcular() {
    val intent = Intent(this, SumaActivity::class.java)
    startActivity(intent)
}

