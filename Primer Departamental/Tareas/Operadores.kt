fun Pendiente(x1: Float, y1: Float, x2: Float, y2: Float): Float{
    var pendiente: Float = 0f
    pendiente = (y2-y1)/(x2-x1)
    return pendiente
}

fun main(){
    val x1: Float = 4f
    val y1: Float = 3f
    val x2: Float = -3f
    val y2: Float = -2f

    val resultado: Float = Pendiente(x1, y1, x2, y2)
    print("La pendiente, tomando en cuenta que: P1(4,3), P2(-3,-2) es igual a = $resultado")
}
