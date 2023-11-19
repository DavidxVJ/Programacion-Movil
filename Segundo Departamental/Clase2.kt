//Main
import Clases.Goomba
import Clases.Mario

//Modificadores de acceso
// private: Que es accesible solo dentro de la clase que lo contiene
// protected: Solo se tiene acceso dentro de la claase y por medio de las clases que heredan de este
// internal: Accesible entre modulos una serie de archivos compilados en conjunto
// public: Como su nombre lo indica, da un acceso global

// Definiremos dos atributos: State, lives

fun main(){
    var mario = Mario()
    /*for (i in 1..5){
            if(mario.isAlive){
                    mario.collision("Goomba")
                    println("Te quedan ${mario.getLives()}")
            }
            println("Te quedan ${mario.getLives()}")
    }*/
    mario.collision("star")
    /*val enemy = Enemy("Un enemigo",2)
    enemy.collision("Enemy")
    enemy.collision("Weapon")*/
    val enemy = Goomba("Un enemigo", 2)
}

//Getters y Setters
// Los atributos de una clase pueden ser leidos y escritos. Como mencionamos,
// el modificador private impidee que fuera de la clase se pueda interactuar con un metodo o atributo,
// pero si un agente externo requiere poder sumar algun valor a un numero sin tener acceso al valor
// actual o a modificarlo directamente, necesitamos usar un setter.
// Get y Set desde Kotlin

//Herencia
//Permite la creación de las clases "hijo" o subclases a partir de una clase "padre" o super clase,
//esta superclase hereda los atributos y metodos que esten permitidos por encapsulamiento
//(Dependiendo de modificador de acceso asignado a cada propiedad) a sus subclases. Pueden existir varias subclases de
// una superclase, pero no una subclase con varias superclases

//Clase Mario
package Clases
import kotlin.concurrent.schedule
import java.util.*

class Mario(var vidas: Int = 3) {   //Setear el numero de vidas por defecto en el contructor
    init {
        println("It's a me! Mario!")
    }
    private var state = "small"
        set(value){
            val before = field
            field = value
            println("Tu estado ahora es $field")
            if(value=="Star"){
                Timer("SettingUp", false).schedule(10000){
                    field = before
                    println("tu estado ahora es $field")
                }
            }
        }
    private var lives = 3
        set(value){
            if(field == 1){
                field = 0
                gameOver()
            }
            else if (field == 0){
                println("Necesitas volver a jugar")
            }
            else{
                field = value
            }
        }
    val isAlive: Boolean
        get(){
            return lives >=1
        }
    /*private fun die(){
        lives--
        println("Has perdido una vida!")
    }*/
    fun collision(collisionObj: String){
        when (collisionObj){
            "Goomba" -> lives--
            "Super Mushroom" -> state = "Super Mario"
            "Fire flower" -> state = "Fire Mario"
            "Star" -> state = "Star"

            else -> println("Objeto desconocido, ¡No pasa nada!")
        }
    }
    fun getLives(): String{
        return "$lives vidas"
    }
    private fun gameOver(){
        println("Juego Terminado")
    }
}

//Clase Goomba
package Clases

class Goomba(name: String, strength: Int): Enemy(name,strength) {
    init {
        println("Iniciando subclase de $name")
    }
}

//Clase Enemy
package Clases

open class Enemy (val name: String, val strength:Int){
    init {
        println("Iniciando superclase")
    }
    protected var direction: String = "Left"
    protected fun changeDirection(){
        direction = if (direction=="Right") "Left" else "Right"
        println("$name va en dirección $direction")
    }
    protected fun die(){
        println("$name ha muerto")
    }
    fun collision(collider: String){
        when (collider){
            "Weapon" -> die()
            "Enemy" -> changeDirection()
        }
    }
}
