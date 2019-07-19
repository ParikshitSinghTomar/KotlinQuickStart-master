fun main(args: Array<String>) {

    println("Welcome Generics")
    

//Contravariance in Java and Kotlin
// For Object contravariant
//     val parent: Parent = GrandParent()
// val babyChild: BabyChild = Parent()
//can not have parent object in child references
var grandParent:GrandParent=BabyChild()



//2. Same for Array Contravariant
// val parents: Array<Parent> = arrayOfNulls<GrandParent>(10)
// val children: Array<BabyChild> = arrayOfNulls<GrandParent>(10)
// val children2: Array<BabyChild> = arrayOfNulls<Parent>(10)



//**********************************************************************
// This will not compile. The parameterised types of collections
// are invariant by default.
//List<Parent> willNotCompileParents = new ArrayList<GrandParent>();
// Turn on the contravariant behaviour through use-site variance.
// This list can accept (or consumes) `Parent` and anything that is 
// a supertype of `Parent`.
//List<? super Parent> okayParents = new ArrayList<GrandParent>();
//Kotlin
var okayParents:List<GrandParent> = arrayListOf<Parent>()

//************************************************************ */

}
/// need to understand invariant, covariant and contravariant concepts  than can 
//easily understand kotlin generic concepts easily. Can also approach to Java generics with T, 
fun demo(strs:Source<String>){
    val objects:Source<Any> = strs
}

interface Source<out T>{
    fun nextT():T
}

open class GrandParent { }

open class Parent : GrandParent() { }

class BabyChild : Parent() { }


//Given this base interface.
interface MyInterface {

  fun doStuff(babyChild: BabyChild): BabyChild
}

//3. Same for method overriding
// This will NOT compile. Return type and parameter type isn't 
// contravariant.
// class MyInterfaceImpl : MyInterface {

//   override fun doStuff(grandParent: GrandParent): Parent {
//       return Parent()
//   }
// }


// This will NOT compile, same reason as above.
// class MyInterfaceImpl3 : MyInterface {

//   override fun doStuff(parent: Parent): GrandParent {
//       return GrandParent()
//   }
// }


// Arrays are where the two languages behave differently. Java arrays are covariant, 
//while Kotlin arrays are invariant.



// This is called declaration-site variance: we can annotate the type parameter T of 
// Source to make sure that it is only returned (produced) from members of Source<T>, 
// and never consumed. To do this we provide the out modifier:
interface Source2<out T> {
    fun nextT(): T
}

fun demo(strs: Source2<String>) {
    val objects: Source2<Any> = strs // This is OK, since T is an out-parameter
    
}

// "in". It makes a type parameter contravariant: it can only be consumed and never 
// produced. A good example of a contravariant type is Comparable:
interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun demo(x: Comparable<Number>) {
    x.compareTo(1.0) // 1.0 has type Double, which is a subtype of Number
    // Thus, we can assign x to a variable of type Comparable<Double>
    val y: Comparable<Double> = x // OK!
}