import scala.collection.mutable.ListBuffer
import scala.io.Source

object Hangman {


  val words: List[String] = inport("WordList.txt")

  
  def main(args: Array[String]): Unit = {
    start()
  }

  def start(): Unit = {
    println("choose a difficulty")
    val w = chooses_word(parse_char(scala.io.StdIn.readLine()))
    run(w, "", new Hangman_Board())

  }

  def run(word: String, guesses: String, board: Hangman_Board): Unit = {

    println(board)
    println(print_hidden_word(word, guesses))
    println(guesses)
    val guess_char = parse_char(scala.io.StdIn.readLine())

    if (word.toUpperCase.contains(guess_char)) {
      if (guesses.concat(guess_char.toString).toUpperCase.contains(word)) println(s"win\n\n$word\n$guesses$guess_char")
      else run(word, guesses.concat(guess_char.toString), board)
    } else {
      board.add()
      if (!board.game_O()) run(word, guesses.concat(guess_char.toString), board)
      else println(s"$board\ngame over")
    }


  }


  def print_hidden_word(word: String, guesses: String) = {
    var str: StringBuilder = new StringBuilder("")
    for (c <- word) {
      if (guesses.contains(c.toString)) str += c
      else str += '_'
    }
    str.toString()
  }

  def parse_char(a: Any): Char = a match {
    case a: Char => a.toUpper
    case a: String => a(0).toUpper
    case _ => 'E'
  }

  def chooses_word(difficulty: Char): String = difficulty match {
    case 'E' => word(1, 6)
    case 'M' => word(6, 7)
    case 'H' => word(7, 20)
    case _ => word(1, 20)
  }

  def word(min: Int, max: Int): String = {
    val r = scala.util.Random
    val i = r.nextInt(words.size)
    if (words(i).length <= min && words(i).length >= max) words(i).toUpperCase
    else word(min, max).toUpperCase
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
    val initWordList = for (line <- Source.fromFile("C:/Users/tadas/Desktop/words.txt").getLines) yield (line)
    initWordList.toList
  }
}
