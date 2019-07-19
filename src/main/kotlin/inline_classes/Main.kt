fun main(args: Array<String>) {
    println("Inline Classes Starting...")

    val name = Name("Kotlin")
    name.greet() // method `greet` is called as a static method
    println(name.length) // property getter is called as a static method

}

// However, there are some restrictions for inline class members:
// inline classes cannot have init blocks
// inline class properties cannot have backing fields
// it follows that inline classes can only have simple computable properties (no lateinit/delegated properties)
inline class Name(val s: String) {
    val length: Int
        get() = s.length

    fun greet() {
        println("Hello, $s")
    }
}  
//Inheritance
// Inline classes are allowed to inherit from interfaces:
interface Printable {
    fun prettyPrint(): String
}

inline class Name2(val s: String) : Printable {
    override fun prettyPrint(): String = "Let's $s!"
}   

// Inline classes vs type aliases
// the crucial difference is that type aliases are assignment-compatible with their 
// underlying type (and with other type aliases with the same underlying type),
//  while inline classes are not.
// In other words, inline classes introduce a truly new type, contrary to type aliases 
// which only introduce an alternative name (alias) for an existing type:

typealias NameTypeAlias = String
inline class NameInlineClass(val s: String)

fun acceptString(s: String) {}
fun acceptNameTypeAlias(n: NameTypeAlias) {}
fun acceptNameInlineClass(p: NameInlineClass) {}

fun main() {
    val nameAlias: NameTypeAlias = ""
    val nameInlineClass: NameInlineClass = NameInlineClass("")
    val string: String = ""

    acceptString(nameAlias) // OK: pass alias instead of underlying type
    // acceptString(nameInlineClass) // Not OK: can't pass inline class instead of underlying type

    // And vice versa:
    acceptNameTypeAlias(string) // OK: pass underlying type instead of alias
    // acceptNameInlineClass(string) // Not OK: can't pass underlying type instead of inline class
}