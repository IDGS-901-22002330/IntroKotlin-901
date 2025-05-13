package com.example.introkotlin_901.temasKotlin

import kotlin.math.PI
import kotlin.math.pow

interface Figura {
    fun area(): Double
}

class Circulo(private val radio: Double) : Figura {
    override fun area() = PI * radio.pow(2)
}

class Cuadrado(private val lado: Double) : Figura {
    override fun area() = lado.pow(2)
}

class Pentagono(private val lado: Double, private val apotema: Double) : Figura {
    override fun area() = (5 * lado * apotema) / 2
}

class Triangulo(private val base: Double, private val altura: Double) : Figura {
    override fun area() = (base * altura) / 2
}

fun main() {
    var opcion: Int
    do {
        println("\n1.Circulo  2.Cuadrado  3.Pentagono  4.Triangulo  5.Salir")
        print("Opcion: ")
        opcion = readLine()?.toIntOrNull() ?: 0
        when (opcion) {
            1 -> {
                print("Radio: ")
                val r = readLine()?.toDoubleOrNull() ?: -1.0
                if (r >= 0) println("Area: ${Circulo(r).area()}") else println("Entrada invalida")
            }
            2 -> {
                print("Lado: ")
                val l = readLine()?.toDoubleOrNull() ?: -1.0
                if (l >= 0) println("Area: ${Cuadrado(l).area()}") else println("Entrada invalida")
            }
            3 -> {
                print("Lado: ")
                val l = readLine()?.toDoubleOrNull() ?: -1.0
                print("Apotema: ")
                val a = readLine()?.toDoubleOrNull() ?: -1.0
                if (l >= 0 && a >= 0) println("Area: ${Pentagono(l, a).area()}") else println("Entrada invalida")
            }
            4 -> {
                print("Base: ")
                val b = readLine()?.toDoubleOrNull() ?: -1.0
                print("Altura: ")
                val h = readLine()?.toDoubleOrNull() ?: -1.0
                if (b >= 0 && h >= 0) println("Area: ${Triangulo(b, h).area()}") else println("Entrada invalida")
            }
            5 -> println("Saliendo...")
            else -> println("Opcion invalida")
        }
    } while (opcion != 5)
}