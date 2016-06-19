// a simple stage-agent model
// Ref http://www.scala-lang.org/old/node/242


import scala.actors._  // Actor
import scala.actors.Actor._  // actions
import scala.collection.immutable.{Map => _, Set => _, _}  // Import Vector, List, Range; excludes Map, Set
import scala.collection.mutable._  // ArrayBuffer, StringBuilder, HashMap or HashSet
import scala.collection.JavaConversions._  // Java ops
import scala.io.Source._  // file ops
import scala.language._  // postfixOps
import scala.math._  // the math
import scala.reflect.runtime.universe._  // reflection
import scala.sys.process._  // work with shell
import scala.util.continuations._  // cont...
import scala.util.control.Breaks._  // break loops
import scala.util.matching.Regex._  // regex
import scala.util.parsing._  // parsing toolbox
import scala.util.Random._  // random numbers
import scala.util.Sorting._  // quickSort etc


case class Msg1(i: Long)
case class Msg2(i: Long)
case class Msg3()
case class Msg4()
case class Init()
case class Stop()


class Agent(id: Long, stage: Actor) extends Actor {
  def act() {
    var state: Long = 0
    var upper: Long = 10
    var lower: Long = -10
    // ...
    while (true) {
      receive {
        case Init =>
          state = 0
          Console.println("Agent["+id+"] is ready. State: "+state)
        case Msg3 =>
          state += 1
          if (state >= upper) {
            Console.println("Agent["+id+"] hyperpolarized. State: "+state)
            upper += 10
            lower = -10
            stage ! Msg1(id)
            }
        case Msg4 =>
          state -= 1
          if (state <= lower) {
            Console.println("Agent["+id+"] depolarized. State: "+state)
            lower -= 10
            upper = 10
            stage ! Msg2(id)
            }
        case Stop =>
          Console.println("Agent["+id+"] stop")
          exit()
      }
    }
  }
}


class Stage() extends Actor {
  def act() {
    while (true) {
      receive {
        case Init =>
          Console.println("Stage is ready.")
        case Msg1(id) =>
          Console.println("Checking Agent["+id+"] hyperpolarization.")
        case Msg2(id) =>
          Console.println("Checking Agent["+id+"] depolarization.")
        case Stop =>
          Console.println("Stage stop")
          exit()
      }
    }
  }
}


object drama extends App {
  val stg = new Stage()
  val agt = new Agent(1, stg)

  stg.start
  stg ! Init

  agt.start
  agt ! Init

  for (i <- (1 to 1000)) { agt ! (if (nextFloat >0.5) Msg3 else Msg4) }

  agt ! Stop
  stg ! Stop
}
