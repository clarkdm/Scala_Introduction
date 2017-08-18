import scala.collection.mutable.ListBuffer
import scala.io.Source

object Hangman {


  val words: List[String] = inport("WordList.txt")

  //  var input = scala.io.StdIn.readLine()
  //  val x = scala.io.StdIn.readLine()
  def main(args: Array[String]): Unit = {
    start()
  }

  def start(): Unit = {
    println("choose a difficulty")
    val w = chooses_word(p_char(scala.io.StdIn.readLine()))
    run(w, "", new Hangman_Board())

  }

  def run(w: String, g: String, b: Hangman_Board): Unit = {

    println(b)
    println(print_w(w, g))
    println(g)
    val c = p_char(scala.io.StdIn.readLine())

    if (w.toUpperCase.contains(c)) {
      if (g.concat(c.toString).toUpperCase.contains(w)) println(s"win\n\n$w\n$g$c")
      else run(w, g.concat(c.toString), b)
    } else {
      b.add()
      if (!b.game_O()) run(w, g.concat(c.toString), b)
      else println(s"$b\ngame over")
    }


  }


  def print_w(w: String, g: String) = {
    var str: StringBuilder = new StringBuilder("")
    for (c <- w) {
      if (g.contains(c.toString)) str += c
      else str += '_'
    }
    str.toString()
  }

  def p_char(a: Any): Char = a match {
    case a: Char => a.toUpper
    case a: String => a(0).toUpper
    case _ => 'E'
  }

  def chooses_word(d: Char): String = d match {
    case 'E' => word(1, 6)
    case 'M' => word(6, 7)
    case 'H' => word(7, 20)
    case _ => word(1, 20)
  }

  def word(x: Int, y: Int): String = {
    val r = scala.util.Random
    val i = r.nextInt(words.size)
    if (words(i).length <= y && words(i).length >= x) words(i).toUpperCase
    else word(x, y).toUpperCase
  }


  //
  //
  //
  //
  //
  //
  //
  //
  //

  def inport(filename: String): List[String] = {
    var a: ListBuffer[String] = new ListBuffer()
    for (line <- Source.fromFile(filename).getLines) {
      a += line
    }
    a.toList
  }
}
