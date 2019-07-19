fun main(args: Array<String>) {
    println("Enum Classes Starting....")

    
}
enum class Direction{
    EAST,WEST, NORTH,SOUTH
}
enum class Color(var rgb:Int){

        RED(0xFF0000),
        GREEN(0x00FF00),
        BLUE(0x0000FF)

}
/////////////Anonymous Class with Classes
enum class ProtocolState{
    WAITING{
            override fun signal()=TALKING
    },
    TALKING{
            override fun signal()=WAITING
    }
    abstract fun signal():ProtocolState
}

//Implementing interface in enum classes
enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };

    override fun applyAsInt(t: Int, u: Int) = apply(t, u)
}