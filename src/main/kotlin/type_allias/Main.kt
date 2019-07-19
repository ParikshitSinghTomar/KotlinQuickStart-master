// Type aliases provide alternative names for existing types. If the type name 
// is too long you can introduce a different shorter name and use the new one instead.
fun main(args: Array<String>) {
    println("Type Alias Starting...")

    //cr

    val aInner:AInner?=null
    val bInner:BInner?=null


     val f: (Int) -> Boolean = { it > 0 }
    println(foo(f)) // prints "true"

    val p: Predicate<Int> = { it > 0 }
    println(listOf(1, -2).filter(p)) // prints "[1]"

}

typealias Predicate<T> = (T) -> Boolean

fun foo(p: Predicate<Int>) = p(0)

typealias NodeSet = Set<Network.Node>
typealias FileTable<K> = MutableMap<K, MutableList<File>>


class Network{
    class Node{

    }
}
class File{
    
}
class A {
    inner class Inner
}
class B {
    inner class Inner
}

typealias AInner = A.Inner
typealias BInner = B.Inner
