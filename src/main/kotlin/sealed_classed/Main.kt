fun main(args: Array<String>) {

    var circle = Shape.Circle(4.5f)
    var square = Shape.Square(4)
    var rectangle = Shape.Rectangle(4,5)

    eval(circle)
    eval(square)
    eval(rectangle)
    //eval(x) //compile-time error.

}
sealed class Shape{
    class Circle(var radius: Float): Shape()
    class Square(var length: Int): Shape()
    class Rectangle(var length: Int, var breadth: Int): Shape()
}

fun eval(e: Shape) =
        when (e) {
            is Shape.Circle -> println("Circle area is ${3.14*e.radius*e.radius}")
            is Shape.Square -> println("Square area is ${e.length*e.length}")
            is Shape.Rectangle -> println("Rectagle area is ${e.length*e.breadth}")
        }