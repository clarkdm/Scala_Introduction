
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object HashMaps_Anagrams {

  def main(args: Array[String]): Unit = {


    add_all(inport(filename))
    println(most_anagrams())
  }

  val filename = "WordList.txt"
  var map = new mutable.HashMap[String, ArrayBuffer[String]]


  def most_anagrams(): String = {
    var max: Int = 0
    var most: ArrayBuffer[String] = new ArrayBuffer[String]()
    for (key <- map.keySet) {
      if (max < map(key).size) {
        max = map(key).size
        most = new ArrayBuffer[String]() += key

      }
      else if (max == map(key).size) most += key
    }
    if (most.size == 0) "No anagrams"
    else if (most.size == 1) most(0)
    else {
      max = 0
      var most_Char: ArrayBuffer[String] = new ArrayBuffer[String]()
      for (word <- most) {
        if (max < word.size) {
          max = word.size
          most_Char = new ArrayBuffer[String]() += word
        }
        else if (max == word.size) most_Char += word
      }
      if (most_Char.size == 0) "No anagrams"
      else if (most_Char.size == 1) most(0)
      else {
        var temp = ""
        most_Char.foreach(word => temp + word)
        temp
      }
    }
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
    else map += (sort -> (ArrayBuffer().+=(word)))
  }

  def inport(filename: String): List[String] = {
    val initWordList = for (line <- Source.fromFile(filename).getLines) yield (line)
    initWordList.toList
  }

}
