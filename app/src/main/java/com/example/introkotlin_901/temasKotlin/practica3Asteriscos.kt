package com.example.introkotlin_901.temasKotlin

fun main() {
    var numero: Int

    do {
        print("Ingrese un numero (0 o menor para terminar): ")
        numero = readln().toInt()

        if (numero > 0) {
            for (i in 0..numero) {
                for (j in 0..numero - i) {
                    print(" ")
                }
                for (k in 0..(i - 1)) {
                    print("*")
                }
                println()
            }
        } else if (numero <= 0 ){
            println("Fin del programa.")
        }
    } while (numero > 0)
}