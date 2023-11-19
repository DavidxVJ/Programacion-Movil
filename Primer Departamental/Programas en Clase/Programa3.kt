//Ejercicio 3
fun CalcularArea(b: Float, h: Float):Float{
    return b*h
}
fun main() {
    val base: Float = 4f
    val altura: Float = 5f
    
    val resultado:Float = CalcularArea(base, altura)
    println("El area es $resultado")
}
