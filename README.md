# ocala
principles for a simpler Scala

------

- Use `Predef.scala`.


- Use `Long` for integer number, use `Double` for real number, use `null` for no op, use `Unit` for empty value data type.


- Declare data type and initial value for simple typed standalone `var/val`:

```scala
    val x :Long = 5
    var y :String = "hi!"
```


- Define named function through anonymous function with all types declared:

```scala
    val triple = (x:Long) => 3*x :Double
    val fn = (x:Long) =>  {x match { case 0 => 0; case _ => "OK!";}} :Any
```


- Use the `case _` branching in `match` structure:

```scala
    Console.println( x%2 match { case 0 => "even"; case 1 => "odd!"; case _ => "WTF!";})
```
