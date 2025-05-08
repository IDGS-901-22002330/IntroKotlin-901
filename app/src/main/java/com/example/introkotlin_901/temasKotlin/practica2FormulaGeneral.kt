package com.example.introkotlin_901.temasKotlin

// Practica 2
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    var a: Double? = null
    var b: Double? = null
    var c: Double? = null

    do {
        println("\nSolucionador de Ecuaciones Cuadraticas")
        println("(ax^2 + bx - c = 0)")

        while (a == null || a == 0.0) {
            print("Ingrese el valor de a (no puede ser 0): ")
            val inputA = readln()
            a = inputA.toDoubleOrNull()
            if (a == null) {
                println("Entrada invalida.")
            } else if (a == 0.0) {
                println("El valor de 'a' no puede ser 0.")
            }
        }

        while (b == null) {
            print("Ingrese el valor de b: ")
            val inputB = readln()
            b = inputB.toDoubleOrNull()
            if (b == null) {
                println("Entrada invalida.")
            }
        }

        while (c == null || c >= 0.0) {
            print("Ingrese el valor de c (no puede ser 0 o positivo): ")
            val inputC = readln()
            c = inputC.toDoubleOrNull()
            if (c == null) {
                println("Entrada invalida.")
            } else if (c >= 0.0) {
                println("El valor de 'c' no puede ser 0 o positivo.")
            }
        }

        calcularRaicesCuadraticas(a, b, c)

        println("Calcular otra? (s/n)")
        val respuesta = readln().lowercase()
        if (respuesta != "s") {
            break
        }

        a = null
        b = null
        c = null

    } while (true)
}

fun calcularRaicesCuadraticas(a: Double, b: Double, c: Double) {
    val discriminante = b * b - 4 * a * c
    if (discriminante >= 0) {
        val raiz1 = (-b + sqrt(discriminante)) / (2 * a)
        val raiz2 = (-b - sqrt(discriminante)) / (2 * a)
        println("Las raíces son: x1 = $raiz1, x2 = $raiz2")
    } else {
        println("La ecuación no tiene raíces reales.")
    }
}