fun main(args: Array<String>) {
    println("Start....")

    var u1=User("Parikshit")
    u1.empCode=10

    var u2=User("Parikshit")
    u2.empCode=20


   if(u1.equals(u2))
   {        
       print("Both object are same")
   }else{
        println("Both object are not same")
   }


   var u3=User2("Parikshit",10)
  

    var u4=User2("Parikshit",20)
  

   if(u3.equals(u4))
   {        
       println("Both object are same")
   }else{
        println("Both object are not same")
   }
}

/**
    We have only one argument in constructor hence we can only compare via name 
    If we pass empcode in constructor also than both will use for compare.

 */
data class User(var name:String){
    var empCode:Int=-1
}

data class User2(var name:String,var empCode:Int)