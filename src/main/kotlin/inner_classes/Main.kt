class OuterClass{
    class NestedClass{

var message="Nested Class in Outer Class"

fun display(){
    print(message)
}

    }

var message="Outer Classs message"
    fun display(){
        println(message)
    }

    interface InnerInterface{
       fun display()
    }
}



fun main(args: Array<String>) {
    println(OuterClass().display())

    println(OuterClass.NestedClass().display())

    println("Nested anonymous inner classes")

    OuterClass.InnerInterface anonymousObject=object:Outer.InnerInterface{
        fun display(){
            println("Printing Anonymous Interface Object")
        }
    }

    anonymous.display()
}