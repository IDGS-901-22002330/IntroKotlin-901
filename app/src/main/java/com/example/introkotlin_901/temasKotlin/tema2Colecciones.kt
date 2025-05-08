package com.example.introkotlin_901.temasKotlin

fun main (){
    /*
    List, MutableList
    Set, MutableSet
    Map, MutableMap
     */

    var readOnlyList: List<String> = listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
    println(readOnlyList)
    println("el primer dia de la semana es ${readOnlyList[0]}")
    println("el primer dia de la semana es ${readOnlyList.first()}")

    println("el numero de dias es ${readOnlyList.count()}")
    println("el numero de dias es ${readOnlyList.size}")

    println("Martes" in readOnlyList)

    var figuras:MutableList<String> = mutableListOf("Circulo", "Cuadrado", "Triangulo")
    println(figuras)
    figuras.add("Pentagono")
    println(figuras)
    figuras.removeAt(0)
    println(figuras)
    figuras.remove("Cuadrado")

    // ---------------------------------------------------------

    val readOnlyFrutas = mapOf("manzana" to 1500, "platano" to 2000, "sandia" to 2500)
    println(readOnlyFrutas)
    println(readOnlyFrutas["manzana"])
    println(readOnlyFrutas.keys)
    println(readOnlyFrutas.values)


}