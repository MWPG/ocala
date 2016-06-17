# ocala
seeking original Scala practices

------

- Use `Predef.scala`.


- Use `Long` for integer number, use `Double` for real number, use `null` for no op, use `Unit` for empty value data type.


- Always declare data type and initial value for simple typed standalone `var/val`:

```scala
    val x :Long = 5
    var y :String = "hi!"
```


- Read/write/print from explicit source, including `Console`:

```scala
    y = Console.readLine
    Console.println(y+": "+x)
```


- Define named function through anonymous function with all types declared:

```scala
    val triple = (x:Long) => 3*x :Double
    val fn = (x:Long) =>  {x match { case 0 => 0; case _ => "OK!";}} :Any
```


- Use `match` with `case _` for the branching structure:

```scala
    Console.println( x%2 match { case 0 => "even"; case 1 => "odd!"; case _ => "WTF!";})
```


- Use `foreach`, `map`, `filter`, `reduce` etc for loop structures:

```scala
    List(1, 4, 22, 7, 9, 3, 12) filter(x => x>8) foreach(Console.println)
```

UPDATE:
    Just implemented `read_adjl` with the above principles. Not that cheerful.
