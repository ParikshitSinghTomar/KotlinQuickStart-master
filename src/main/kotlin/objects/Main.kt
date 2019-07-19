fun main(args: Array<String>) {
    println("Object Declarations Starting...")
    DataProviderManager.registerDataProvider(DataProvider())

//Companion Objects
   var myClass1=MyClass1.create()
   var myClass2=MyClass2.hello
}
class DataProvider{

}
//work like a singleton and also thread safe
object DataProviderManager{
    fun registerDataProvider(provider:DataProvider){
        allDataProviders.add(provider)
    }
    val allDataProviders=arrayListOf<DataProvider>()
}
class MyClass1 {
    companion object Factory {
        fun create(): MyClass1 = MyClass1()
    }
}

class MyClass2 {
    companion object {
            val hello="Hello"
     }
}
// Only one companion object is allowed per class
class MyClass3 {
    companion object Factory1 {
        fun create(): MyClass1 = MyClass1()
    }
    // companion object Factory2 {
    //     fun create(): MyClass1 = MyClass1()
    // }
}
// Semantic difference between object expressions and declarations
// There is one important semantic difference between object expressions and object declarations:

// object expressions are executed (and initialized) immediately, where they are used;
// object declarations are initialized lazily, when accessed for the first time;
// a companion object is initialized when the corresponding class is loaded (resolved), matching the semantics of a Java static initializer.