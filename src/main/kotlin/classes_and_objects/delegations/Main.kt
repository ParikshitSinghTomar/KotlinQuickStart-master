fun main(args: Array<String>) {
    println("Delegations Starting...")

    val b = BaseImpl(10)
    Derived(b).print()
println()
 println("Delegations2 Starting...")
  


    val b2 = BaseImpl2(10)
    Derived2(b2).printMessage()
    Derived2(b2).printMessageLine()
}
interface Base {
    fun print()
}
//A class Derived can implement an interface Base by delegating all 
//of its public members to a specified object:
class BaseImpl(val x: Int) : Base {
    override fun print() { print(x) }
}

class Derived(b: Base) : Base by b

interface Base2 {
    fun printMessage()
    fun printMessageLine()
}

class BaseImpl2(val x: Int) : Base2 {
    override fun printMessage() { print(x) }
    override fun printMessageLine() { println(x) }
}

class Derived2(b: Base2) : Base2 by b {
    override fun printMessage() { print("abc") }
}