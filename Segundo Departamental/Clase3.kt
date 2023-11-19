//Main
import Clases.Goomba
import Clases.Koopa
import Clases.Mario

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
    val enemy = Goomba()
    enemy.collision("Enemy")
    enemy.collision("Weapon")
    val koopa = Koopa()
    koopa.collision("Weapon")
}

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

//Clase Koopa
package Clases

class Koopa:
    Enemy("Koopa", 2){
    override fun collision(collider: String) {
        //super.collision(collider)
        when(collider){
            "Weapon" -> {
                var state = "Shell"
                println("El estado ahora es $state")
            }
            "Enemy" -> changeDirection()
        }
        println("Usando la colisión de la clase Enemy")
        }
}

//Clase Goomba
package Clases

class Goomba: Enemy("Goomba", 1){
    //(name: String, strength: Int):
    //Enemy(name,strength) {
    //Enemy("Goomba",1) {
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
    open fun collision(collider: String){
        when (collider){
            "Weapon" -> die()
            "Enemy" -> changeDirection()
        }
    }
}
