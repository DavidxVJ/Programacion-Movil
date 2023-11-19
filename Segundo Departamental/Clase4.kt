//Main
import clases.National
import clases.NationalLowSeason

fun main(args: Array<String>) {
    val viajeMonterrey = National("Monterrey")
    viajeMonterrey.quotePrice(2)
    viajeMonterrey.reserve(4)

    val viajeBajaMonterrey = NationalLowSeason("Monterrey")
    viajeBajaMonterrey.reserve(4)
}

//Clase National
package clases

open class National(override val city:String):Travel(){
    override val country = "Mexico"

    protected val fees = mapOf(
        "Monterrey" to 400,
        "Guadalajara" to 350,
        "CDMX" to 360,
        "San Cristóbal de las casas" to 240,
        "San Miguel de Allende" to 320
    )

    override fun getPrice(numDays: Int): Int {
        val fee = fees[city]
        return if(fee==null) 0 else fee*numDays
    }

    override fun quotePrice(numDays: Int) {
        val price = getPrice(numDays)
        if(price==0){
            println("Los sentimos, no hacemos viajes a esta ciudad")
        } else{
            println("Tu viaje a $city cuesta \$$price")
        }
    }
}

//Clase Travel
package clases

abstract class Travel {

    abstract val country: String
    abstract val city: String
    protected val serviceType = "Viaje"
    protected var reserved = false
    protected var paidAmount = 0

    abstract fun quotePrice(numDays:Int)
    protected abstract fun getPrice(numDays:Int):Int

    fun reserve(numDays: Int) {
        if (reserved) {
            println(
                """Ya reservaste tu viaje!
                Pais: $country
                Ciudad: $city
                Precio: $paidAmount""".trimMargin()
            )
            return
        }

        val amount = getPrice(numDays)

        if (amount == 0) {
            return
        }

        reserved = true
        paidAmount = amount

        println(
            """Viaje reservado exitosamente!
        Pais: $country
        Ciudad: $city
        Precio: $paidAmount""".trimMargin()
        )

    }
}

//Clase NationalLowSeason
package clases

import interfaces.IPromotion

class NationalLowSeason(city: String): National(city), IPromotion {
    override val discount = 10 //es porcentaje, o sea 10%
    override val typeDiscount = 0 //0 para porcentaje, 1 para cantidad

    override fun getPrice(numDays: Int): Int {
    val amount = super.getPrice(numDays)
    return if (amount == 0) 0 else getDiscountPrice(amount)
    }

}

//Interface IPromotion
package interfaces

interface IPromotion {

    val discount: Int //el descuento en porcentaje o en cantidad
    val typeDiscount: Int //porcentaje o cantidad

    fun getDiscountPrice(amount: Int): Int { //obtener el precio real ya con el descuento
        return if (typeDiscount == 0) { //0 es porcentaje
            (amount * (100 - discount)) / 100
        } else { //cantidad especifica
            amount - discount
        }
    }
}
