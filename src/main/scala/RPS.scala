import scala.collection.mutable.ListBuffer

abstract class RPS {

  def rock_paper_scissors(player_1: String, player_2: String): Int

  def run(): Unit
  def run_ai_ai(num:Int): Unit
  def get_Random(): String
  def ai_0(): String = {
    get_Random()
  }

  def ai_1(past_turns: ListBuffer[String]): String = {
    get_Random()
  }

  def ai_2(past_turns: ListBuffer[String]): String = {
    get_Random()
  }
}
