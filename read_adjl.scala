import scala.io._
// https://github.com/OXCA/read_adjl

object read_adjl extends App {
  val sources = Source.fromFile(args(0))
  Console.println("init: " + args(0))

  sources.getLines foreach ( line => {
    line.length match {
      case 0 => { Console.println("empty line") }
      case _ => {
        line(0) match {
           case '#' => { Console.println("comment line: " + line) }
           case '=' => { Console.println("command line: " + line) }
           case _   => {
             Console.println(line + " --- processing ...")
             val pp = line.split('#')(0).split(':') // remove comment at line end, and split at ':'
             val prev = pp(0).trim.split('~')
             val post = pp(1).trim.split('~')
             val prevArr = { prev.length match {
                 case 1 => {Integer.parseInt(prev(0).trim) to Integer.parseInt(prev(0).trim)}
                 case _ => {Integer.parseInt(prev(0).trim) to Integer.parseInt(prev(1).trim)}
               }}
             val postArr = { post.length match {
               case 1 => {Integer.parseInt(post(0).trim) to Integer.parseInt(post(0).trim)}
               case _ => {Integer.parseInt(post(0).trim) to Integer.parseInt(post(1).trim)}
               }}
             prevArr foreach(x => { postArr foreach(y => Console.println(x+" -> "+y)) })
        }}}}})

  Console.println("done!")
}
