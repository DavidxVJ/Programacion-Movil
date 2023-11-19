//Ejercicio 2
import kotlin.math.pow
const val  PI = 3.1416f

fun main(args: Array<String>) {
    val radio= 4f
    val area = CirculoArea(radio)
    println("El área del círculo es: $area")
}
fun CirculoArea(radio:Float): Float {
    return PI*radio.pow(2)
}
