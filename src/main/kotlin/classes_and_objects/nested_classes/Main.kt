fun main(args: Array<String>) {

    println("Nested Classes Starting.... ")
    val demo1=Outer1.Nested1().foo()
    println("Outer1.Nested1().foo(): "+demo1);
    val demo2=Outer2().Nested2().foo()
    println("Outer2().Nested2().foo(): "+demo2);
    
   //Anonymouse inner classes with abstract class object creation
    var printerContainer1=PrinterContainer()
    printerContainer1.show(object : AbstractClass(){
        override fun print(command:String){
                println(command)
        }
    })
   
   //Anonymouse inner classes with abstract class object creation
    var printerContainer2=PrinterContainer()
    var printer=object: Printer{
        override fun print(command:String){
                println(command)
        }
    }
    printerContainer2.show(printer)
  
}

class Outer1 {
    private val bar:Int=1
   class Nested1{
           fun foo() = 2
    }
}

class Outer2 {
    private val bar:Int=1
    inner class Nested2{
        //we can not access bar in Nested class till we used "inner" keyword before "class Nested"
            fun foo() =bar
    }
 
}

//Anonymous inner classes
interface Printer{
    fun print(command:String)
}

abstract class AbstractClass{
    abstract fun print(command:String);
}
class PrinterContainer{

    fun show(printer : Printer){
            printer.print("Executing your interface command")
    }
 fun show(abstractClass : AbstractClass){
            abstractClass.print("Executing your abstract class command")
    }

    // override fun print(command: var){
    //     println("Please wait executing your command: "+command);
    // }

}