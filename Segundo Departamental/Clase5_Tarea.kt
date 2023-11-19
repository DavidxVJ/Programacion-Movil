fun main(args: Array<String>) {
    fun calcularPrecioConCupon(precio: Double, cupon: String): Double {
        when (cupon) {
            "NOIVA" -> return precio
            "HALFIVA" -> return precio * 1.08
            "MINUS100" -> return precio - 100.0
            "PROMO2020" -> {
                return when {
                    precio <= 1000 -> precio * 1.12
                    precio <= 2000 -> precio * 1.04
                    precio <= 4000 -> precio * 0.5
                    else -> precio * 2.0 / 3.0
                }
            }
            else -> return precio * 1.16
        }
    }

    fun imprimirPrecioConMensaje(precio: Double, cupon: String, calcularPrecio: (Double, String) -> Double) {
        val precioCalculado = calcularPrecio(precio, cupon)
        println("El precio total a pagar es: $$precioCalculado")
    }

	imprimirPrecioConMensaje(1500.0, "LOL", ::calcularPrecioConCupon)
        imprimirPrecioConMensaje(2500.0, "PROMO2020", ::calcularPrecioConCupon)
}
