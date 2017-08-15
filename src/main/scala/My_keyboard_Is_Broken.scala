import scala.collection.mutable.ListBuffer
import scala.io.Source

object My_keyboard_Is_Broken {


  def main(args: Array[String]): Unit = {
    val filename = "WordList.txt"

    var input = scala.io.StdIn.readLine()
    var a: ListBuffer[String] = new ListBuffer()
    println()
    var x: Int = 0
        for (x <- 1 to p_int(input)){
          a+= scala.io.StdIn.readLine()
        }
//    a += "edcf"
//    a += "bnik"
//    a += "poil"

    println("hi : " + run(a.toList, inport(filename)))


  }

  def p_int(a: Any): Int = a match {
    case a: Int => a
    case a: String => a.split("\n")(0).toInt
    case _ => 1
  }

  def inport(filename: String) = {
    var a: ListBuffer[String] = new ListBuffer()

    for (line <- Source.fromFile(filename).getLines) {
      a += line


    }

    a.toList
  }


  def run(l: List[String], w: List[String]): List[String] = {
    var e: ListBuffer[String] = new ListBuffer()
    for (a <- l) {
      var i = 0
      var l = ""
      //println("tr")
      for (b <- w) {

        if (comp(a, b) && i < b.length) {

          i = b.length
          l = b
        }
      }
      println("hi")

      e += l
    }
    e.toList
  }

  def comp(string_1: String, string_2: String): Boolean = {
    var x = true
    var s = string_2
    for (a <- string_1) {
      //println(a)
      //println(string_2.contains(a))
      if (string_2.contains(a)) {
        s = s.replace(a, '1')

      }
    }
    for (a <- s) {
      if (a != '1') {
        x = false
      }

    }
    x
  }


}
