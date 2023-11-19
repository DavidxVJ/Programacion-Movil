//Ejercicio 7
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    println("Ingresa un valor cualquiera")

    when {
        scanner.hasNextInt() -> {
            val valor = scanner.nextInt()
            println("Has ingresado un entero (int)")
        }
        scanner.hasNextFloat() -> {
            val valor = scanner.nextFloat()
            println("Has ingresado un número en coma flotante (float)")
        }
        scanner.hasNextDouble() -> {
            val valor = scanner.nextDouble()
            println("Has ingresado un número en coma flotante doble (double)")
        }
        scanner.hasNext() -> {
            val valor = scanner.next()
            println("Has ingresado una cadena de caracteres")
        }
    }
    scanner.close()
}
