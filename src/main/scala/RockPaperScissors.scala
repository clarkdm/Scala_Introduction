import scala.collection.mutable.ListBuffer

class RockPaperScissors extends RPS {


  def rock_paper_scissors(player_1: String, player_2: String): Int = (player_1, player_2) match {
    case ("r", "r") => 0
    case ("p", "p") => 0
    case ("s", "s") => 0
    case ("s", "p") => 1
    case ("s", "r") => 2
    case ("p", "r") => 1
    case ("p", "s") => 2
    case ("r", "s") => 1
    case ("r", "p") => 2
    case (_, _) => -1
  }

  def run(): Unit = {
    var past_turns: ListBuffer[String] = new ListBuffer[String]
    var p1_score = 0
    var ai_score = 0
    while (true) {
      println("P1: " + p1_score + "  AI:" + ai_score)
      println("rock paper scissors")
      println("r = rock")
      println("p = paper")
      println("s = scissors")
      past_turns += parse_String(scala.io.StdIn.readLine())
      val temp = rock_paper_scissors(past_turns(past_turns.size - 1), ai_2(past_turns))
      if (temp == 1) p1_score += 1
      else if (temp == 2) ai_score += 1
    }
  }

  def run_ai_ai(num: Int): Unit = {
    var past_turns_1: ListBuffer[String] = new ListBuffer[String]
    var past_turns_2: ListBuffer[String] = new ListBuffer[String]
    var ai_1_score = 0
    var ai_2_score = 0
    for (x <- 0 to num) {
      println("AI_1: " + ai_1_score + "  AI_2:" + ai_2_score)
      past_turns_1 += ai_1(past_turns_2)
      past_turns_2 += ai_2(past_turns_1)
      val temp = rock_paper_scissors(past_turns_1(past_turns_1.size - 1), past_turns_2(past_turns_2.size - 1))
      if (temp == 1) ai_1_score += 1
      else if (temp == 2) ai_2_score += 1
    }
  }

  override def ai_0(): String = {
    get_Random()
  }

  override def ai_1(past_turns: ListBuffer[String]): String = {
    if (past_turns.size > 1) past_turns(past_turns.size - 2)
    else "p"
  }

  override def ai_2(past_turns: ListBuffer[String]): String = {
    get_most_comen(get_total(past_turns.toList))
  }

  def get_total(past_turns: List[String], sub_total: (Int, Int, Int) = (0, 0, 0)): (Int, Int, Int) = past_turns match {
    case "r" :: rest => get_total(rest, (sub_total._1 + 1, sub_total._2, sub_total._3))
    case "p" :: rest => get_total(rest, (sub_total._1, sub_total._2 + 1, sub_total._3))
    case "s" :: rest => get_total(rest, (sub_total._1, sub_total._2, sub_total._3 + 1))
    case Nil => sub_total
  }

  def get_Random(): String = scala.util.Random.nextInt(4) match {
    case 1 => "p"
    case 2 => "r"
    case 3 => "s"
    case _ => get_Random()
  }

  def get_most_comen(total: (Int, Int, Int)): String = total match {
    case (0, 0, 0) => get_Random()
    case (r, p, s) if (r > p & r > s) => "p"
    case (r, p, s) if (s > r & s > p) => "r"
    case (r, p, s) if (p > s & p > r) => "s"
    case (_, _, _) => get_Random()
  }

  def parse_String(a: Any): String = a match {
    case "r" | "R" | "rock" => "r"
    case "p" | "P" | "paper" => "p"
    case "s" | "S" | "scissors" => "s"
    case _ => "rock"
  }
}
