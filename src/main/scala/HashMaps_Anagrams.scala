
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.io.Source

object HashMaps_Anagrams {

  def main(args: Array[String]): Unit = {
    add_all(inport(filename))
    println(most_anagrams())
  }

  val filename = "WordList.txt"
  var map = new mutable.HashMap[String, ListBuffer[String]]


  def most_anagrams(): String = {
    var max: Int = 0
    var most: ListBuffer[String] = new ListBuffer[String]()
    for (key <- map.keySet) {
      if (max < map(key).size) {
        max = map(key).size
        most = new ListBuffer[String]() += key
      }
      else if (max == map(key).size) most += key
    }
    print_most(most.toList, get_most(most.toList))
  }

  def get_most(temp: List[String], max: Int = 0): Int = temp match {
    case f :: rest if f.length > max => get_most(rest, f.length)
    case _ :: rest => get_most(rest, max)
    case Nil => max
  }

  def print_most(temp: List[String], max: Int = 0): String = (temp, max) match {
    case (_, 0) => "No anagrams"
    case (f :: rest, max) if f.length == max => f + " " + print_most(rest, max)
    case (_ :: rest, max) => print_most(rest, max)
    case (Nil, _) => ""
  }

  def sort_word(word: String): String = {
    word.sorted.toLowerCase
  }

  def add_all(word_list: List[String]): Unit = {
    word_list.foreach(word => add(word))
  }

  def add(word: String): Unit = {
    val sort = sort_word(word)
    if (map.keySet.contains(sort)) {
      map(sort) += word
    }
    else map += (sort -> (ListBuffer().+=(word)))
  }

  def inport(filename: String): List[String] = {
    val initWordList = for (line <- Source.fromFile(filename).getLines) yield (line)
    initWordList.toList
  }

}
