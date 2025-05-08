package com.example.introkotlin_901.temasKotlin

fun main(){
    println("Hola mundo!!!")

    val nombre ="Daniel"
    val apellido: String ="Cabrera"   //Se establece el tipo de variable

    println(nombre + " " + apellido)  //imprimir
    println("Hola $nombre $apellido") //Para imprimir contenido de la variable


    var num1 = 10
    println("La suma de num1 + 2 es ${num1 + 2}")  // para hacer operaciones en la misma linea

    num1 = num1 + 3
    num1+=4
    num1++
    println(num1)

    val sueldo: Float=12.25f
    val precio: Double=20.5
    val mayorEdad:Boolean=true
    val estadoCivil:Char = 'S'
}