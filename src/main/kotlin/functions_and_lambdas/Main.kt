fun main(args: Array<String>) {
    println("Functions Starting....")

    foo(strings=*arrayOf("a","b","c"))

    printHello("Hi")

    singleExpressionFun()

    reformat("Named Arguments")

    reformat("Named Arguments", wordSeparator = '_')

    //inflix notation
    1 shl 2
    3.shl(4)
}
//Variable number of arguments (vararg) 
fun foo(vararg strings: String) { 
    for(str in strings){
        println(str)
    }
 }
    //If a function does not return any useful value,
 fun printHello(name: String?): Unit {
    if (name != null)
        println("Hello ${name}")
    else
        println("Hi there!")
    // `return Unit` or `return` is optional
}
//single - expression functions
fun singleExpressionFun()=println(10)

// Default Arguments
fun read(b: Array<Byte>, off: Int = 0, len: Int = b.size) {
    println("off: "+off+", len: "+len)
}

//Named Arguments   
fun reformat(str: String,
             normalizeCase: Boolean = true,
             upperCaseFirstLetter: Boolean = true,
             divideByCamelHumps: Boolean = false,
             wordSeparator: Char = ' ') {

                 println("String: $str, wordSeparator $wordSeparator")
                 //We could call this using default arguments:
                 //reformat(str)
                 //We can also call this method like below
                 //reformat(str, wordSeparator = '_')
}

//Inflix Notation
//1 shl 2 + 3 and 1 shl (2 + 3)
//Infix function calls have lower precedence than the arithmetic operators
infix fun Int.shl(x: Int) { 
    println(x)
    // return x
}
//Local Functions
// Kotlin supports local functions, i.e. a function inside another function:
// fun dfs(graph: Graph) {
//     fun dfs(current: Vertex, visited: Set<Vertex>) {
//         if (!visited.add(current)) return
//         for (v in current.neighbors)
//             dfs(v, visited)
//     }

//     dfs(graph.vertices[0], HashSet())
// }

// Tail recursive functions
// algorithms that would normally be written using loops to 
//instead be written using a recursive function, but without the risk of 
//stack overflow
val eps = 1E-10 // "good enough", could be 10^-15

tailrec fun findFixPoint(x: Double = 1.0): Double
        = if (Math.abs(x - Math.cos(x)) < eps) x else findFixPoint(Math.cos(x))
        

// val eps = 1E-10 // "good enough", could be 10^-15

// private fun findFixPoint(): Double {
//     var x = 1.0
//     while (true) {
//         val y = Math.cos(x)
//         if (Math.abs(x - y) < eps) return x
//         x = Math.cos(x)
//     }
// }