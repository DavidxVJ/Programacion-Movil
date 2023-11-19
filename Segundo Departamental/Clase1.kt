//Main
import Clases.Phone
import Clases.vehiculo
import Clases.animal

fun main() {
    //Clase telefono
    val myPhone = Phone()
    myPhone.getTurn()
    myPhone.turnOn()
    myPhone.getTurn()

    //Clase vehiculo
    val myCar = vehiculo()
    myCar.color = "amarillo"
    myCar.marca = "Ford"
    myCar.modelo = "X"
    myCar.placas = "REM 123"

    println("El coche esta prendido? ${myCar.encendido}")
    myCar.encender()
    println("El coche esta prendido? ${myCar.encendido}")
    println("El tanque tiene ${myCar.gasolina}")
    myCar.recargar(20.07f)
    println("El tanque tiene ${myCar.gasolina}")

    //Prueba animal
    val myAnimal = animal()
    println("Animal: ${myAnimal.especie}")
}

//Clase Phone
package Clases

class Phone {
    var isOn = false
    lateinit var model:String

    fun turnOn(){
        isOn = true
    }

    fun turnOff(){
        isOn = false
    }

    fun getTurn(){
        val turnMode = if(isOn) "Encendido" else "Apagado"
        println("el telefono esta $turnMode")
    }

}

//Clase vehículo
package Clases

class vehiculo {
    var color = ""
    var marca = ""
    var placas = ""
    var modelo = ""
    var gasolina = 0f
    var encendido = false

    fun encender(){
        encendido = true
    }

    fun apagar(){
        encendido = false
    }

    fun recargar(litros:Float){
        gasolina += litros
    }
}

//Clase Animal 
package Clases

class animal {
    var especie = "leon"
}






