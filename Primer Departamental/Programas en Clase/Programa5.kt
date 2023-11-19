//Ejercicio 5
fun calcularArea(x1: Double, y1: Double): Double {
    return x1 * y1
}

fun calcularAreaP(x1: Double, y1: Double, h1: Double): Double {
    return 2 *(x1*y1 + x1*h1 + y1*h1)
}
fun main() {
    val x1 = 4.0
    val y1 = 3.0
    val h1 = 5.0

    val pendiente = calcularArea(x1, y1)
    println("El area es: $pendiente")

    val area = calcularAreaP(x1,y1,h1)
    println("El area es: $area")
}
