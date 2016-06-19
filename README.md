# ocala
towards a simpler Scala


------


- Use [ScalaDoc](http://scala-lang.org/api/)


- Use `Predef.scala`.


- Use `Long` for integer number, use `Double` for real number, use `null` or `()` for no op, use `Unit` for empty value data type.


- Declare data type and initial value for simple typed standalone `var/val`:

```scala
    val x :Long = 5
    var y :String = "hi!"
```


- Use `toTyp` to do data type conversion:

```scala
val d:Double = 1.9
val l:Long = d.toLong
val s:String = 4.56.toString
val c:Char = 97.toChar

// d: Double = 1.9
// l: Long = 1
// s: String = 4.56
// c: Char = a
```


- Use the `Kernighan & Ritchie` style:

```scala
    if (x > 0) {
      x
    } else if (x == 0) {
      0
    } else {
      -x
    }
```


- Use the `case _` branching in `match` structure, and try to avoid standalone `variable match` and `pattern guard`:

```scala
    println( x%2 match { case 0 => "even"; case 1 => "odd"; case _ => "WTF!";})
```


- The `for` loop is great, but try to avoid `intermediate variable` and `pattern guard`:

```scala
    for (i <- 1 to 3; for j <- (4-i) to 3) println(i + " ： " + j）
    for (i <- 1 to 3; for j <- 1 to 3) {if (i != j) println(i + " ： " + j)}
```


- Define `procedure` as:

```scala
    def (x :Any):Unit = {  ...  }
```


- The `_*` operator is useful when using `Range` as `parameter`:

```scala
    def total(x :Long*):Long = { if (x.length ==0) 0 else x.head+total(x.tail : _*) }
    total(1 to 10 map(_ toLong) : _*)
```


- `class` and `object` are awesome, but try to avoid `trait` and `abstract` things.


- Use only `override` or `final` and the normal `inheritance`, when a `class` `extends` another.


- Use `public` or `private` in `class` and `object`? Just use the default.


- Use only `declaration` without `parameter` in defining a class. Call the `primary constructor`, everytime an `auxiliary constructor` is being defined:
 
```scala
    class Person () {
              //  \---primary constructor (no parameter)

      var id :Long = 0
      
      def this(i :Long) { // auxiliary constructor
        this() // call the primary, which runs every line (only declaration) in the class.
        id = i
      }
    }
```


- The `Uniform Access Principle` and the auto defined `getter` and `setter` functions are great. Get familiar with them.


- `object` is only used to pack `main`, or the `var` and `val` things.


- `Array` with its methods work for most cases, use the `Uniform creation Principle` to creat it. Or creat a mutable `ArrayBuffer` first, and use `toArray` to convert it to an immutable `Array` when it is ready to do so. Multidimensional `Array`:

```scala
    val x = Array(1, 3, 5) // also works for all `Iterable`, including `Seq`, `Set`, and `Map`.
    val m = Array.ofDim[Double](3, 5) // m(1)(3)=5 still works!
    val v = (1 to 10) map(_ toLong) toArray
```
