//Ejercicio 6
fun gradoEscolar(){
   print("Ingresa edad")
   
   val age = readLine()?.toInt()
   
   when(age){
       0 -> println("Eres recien nacido")
       1 -> println("Solo tienes 1 año")
       if( age<=10){
           println("Eres un niño")
       }
       if (age>10 || age<18){
           println("Eres un adolescente")
       }
       if(age>=18 || age<60){
           println("Eres un adulto mayor")
       }
   
   }
}
