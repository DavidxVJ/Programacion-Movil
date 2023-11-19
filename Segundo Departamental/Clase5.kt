//Main
fun main(args: Array<String>) {
    //Ejercicio Movie (Clases: Movie)
    val scaryMovie = Movie("Scary Movie", "Comedia", 83.80)
    println(scaryMovie)
    scaryMovie.createdAt = "2000"
    println(scaryMovie.component2())

    val scaryMovie2 = scaryMovie.copy(name="Scary Movie 2", duration=83.0)
    println("""
        Scary movie: $scaryMovie
        Scary movie 2: $scaryMovie2
    """.trimIndent())

    //Ejercicio Vehicle (Clase vehicle)
    val vehiculoInstance = Vehicle.create()

    //Funciones literales
    var saludo = { println("Hola, esta en una funcion literal")}()

    //Expresiones lambda
    val f: (Int, Int) -> Double
    //val suma = {a:Int, b:Int -> a+b}
    //println(suma(4,5))
    val presentarse = {name:String, age:Int -> "Me llamo $name y tengo $age años"}
    println(presentarse("David", 22))

    //Ejemplo complejo exp. lambda
    val saverGrade: (Double, Double) -> String = { expected: Double, saved:Double ->
        val percentage = saved / expected

        when{
            percentage > 1 -> "Ahorrador pro"
            percentage == 1.0 -> "Buen ahorrador"
            percentage < 1.0 && percentage >= 0.8 -> "Almost"
            else -> "Aprendiz saver"
        }
    }
    println(saverGrade(180.0,90.0))

    //Higher order functions
    //fun sumaOrdenSuperior(a:Int, b:Int, suma:(Int,Int) -> Int):Int{
    //    return suma(a,b)
    //}

    fun calculadora(a:Int, b:Int, operacion:(Int,Int) -> Int):Int{
        return operacion(a,b)
    }
    fun suma(a:Int, b:Int) = a+b
    fun resta(a:Int, b:Int) = a-b
    fun multiplica(a:Int, b:Int) = a*b

    val suma = calculadora(5,6,::suma)
    println(suma)
    val resta = calculadora(5,6,::resta)
    println(resta)
    val multiplica = calculadora(5,6,::multiplica)
    println(multiplica)
}

//Data class Movie
data class Movie(
    val name: String,
    val gender: String,
    val duration: Double){
    var createdAt=""
}

//Clase Vehiculo
class Vehicle {
    init{
        println("Vehiculo creado")
    }
    companion object Factory{
        fun create(): Vehicle = Vehicle()
    }
}
