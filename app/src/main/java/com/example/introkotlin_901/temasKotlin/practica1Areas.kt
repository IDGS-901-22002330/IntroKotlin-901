package com.example.introkotlin_901.temasKotlin

// Practica 1
import kotlin.math.PI
import kotlin.math.pow

fun main() {
    var opcion: Int
    do {
        println("\nSeleccione una figura para calcular su area:")
        println("1. Circulo")
        println("2. Cuadrado")
        println("3. Pentagono")
        println("4. Triangulo")
        println("5. Salir")
        print("Ingrese su opcion: ")

        opcion = readln().toInt()

        when (opcion) {
            1 -> calcularAreaCirculo()
            2 -> calcularAreaCuadrado()
            3 -> calcularAreaPentagono()
            4 -> calcularAreaTriangulo()
            5 -> println("Saliendo...")
            else -> println("Opción invalida.")
        }
    } while (opcion != 5)
}

fun calcularAreaCirculo() {
    print("Ingrese el radio del circulo: ")
    val radio = readln().toDouble()
    if (radio != null && radio >= 0) {
        val area = PI * radio.pow(2)
        println("El area del circulo es: $area")
    } else {
        println("Entrada invalida.")
    }
}

fun calcularAreaCuadrado() {
    print("Ingrese el lado del cuadrado: ")
    val lado = readln().toDouble()
    if (lado != null && lado >= 0) {
        val area = lado.pow(2)
        println("El area del cuadrado es: $area")
    } else {
        println("Entrada invalida.")
    }
}

fun calcularAreaPentagono() {
    print("Ingrese el lado del pentagono: ")
    val lado = readln().toDouble()
    if (lado != null && lado >= 0) {
        print("Ingrese la apotema del pentagono: ")
        val apotema = readLine()?.toDouble()
        if (apotema != null && apotema >= 0) {
            val area = (5 * lado * apotema) / 2
            println("El area del pentagono es: $area")
        } else {
            println("Entrada invalida.")
        }
    } else {
        println("Entrada invalida.")
    }
}

fun calcularAreaTriangulo() {
    print("Ingrese la base del triangulo: ")
    val base = readln().toDouble()
    if (base != null && base >= 0) {
        print("Ingrese la altura del triangulo: ")
        val altura = readLine()?.toDouble()
        if (altura != null && altura >= 0) {
            val area = (base * altura) / 2
            println("El area del triangulo es: $area")
        } else {
            println("Entrada invalida.")
        }
    } else {
        println("Entrada invalida.")
    }
}
