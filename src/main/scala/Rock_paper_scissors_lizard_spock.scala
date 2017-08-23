import scala.collection.mutable.ListBuffer

object Rock_paper_scissors_lizard_spock {

  def main(args: Array[String]): Unit = {
    run_ai_ai()
  }


  def rock_paper_scissors(player_1: String, player_2: String): Int = (player_1, player_2) match {
    case (a, b) if a == b => 0

    case ("scissors", "paper") => 1
    case ("scissors", "rock") => 2
    case ("scissors", "lizard") => 1
    case ("scissors", "spock") => 2

    case ("paper", "rock") => 1
    case ("paper", "scissors") => 2
    case ("paper", "lizard") => 2
    case ("paper", "spock") => 1

    case ("rock", "scissors") => 1
    case ("rock", "paper") => 2
    case ("rock", "lizard") => 1
    case ("rock", "spock") => 2

    case ("spock", "paper") => 2
    case ("spock", "rock") => 1
    case ("spock", "lizard") => 2
    case ("spock", "scissors") => 1

    case ("lizard", "paper") => 1
    case ("lizard", "rock") => 2
    case ("lizard", "scissors") => 2
    case ("lizard", "spock") => 1


    case (_, _) => -1

  }

  def run(): Unit = {
    var past_turns: ListBuffer[String] = new ListBuffer[String]
    var p1_score = 0
    var ai_score = 0
    while (true) {
      println("P1: " + p1_score + "  AI:" + ai_score)
      println("rock paper scissors lizard spock")
      println("r = rock")
      println("p = paper")
      println("s = scissors")
      println("l = lizard")
      println("k = spock")
      past_turns += parse_char(scala.io.StdIn.readLine())
      val temp = rock_paper_scissors(past_turns(past_turns.size - 1), ai_1(past_turns))
      println(temp + " " + past_turns + " : AI : " + ai_1(past_turns))
      if (temp == 1) p1_score += 1
      else if (temp == 2) ai_score += 1
    }
  }

  def run_ai_ai(): Unit = {
    var past_turns_1: ListBuffer[String] = new ListBuffer[String]
    var past_turns_2: ListBuffer[String] = new ListBuffer[String]
    var ai_1_score = 0
    var ai_2_score = 0
    for (x <- 0 to 10000) {
      println("AI_1: " + ai_1_score + "  AI_2:" + ai_2_score)

      past_turns_1 += ai_1(past_turns_2)
      past_turns_2 += ai_2(past_turns_1)
      val temp = rock_paper_scissors(past_turns_1(past_turns_1.size - 1), past_turns_2(past_turns_2.size - 1))
      if (temp == 1) ai_1_score += 1
      else if (temp == 2) ai_2_score += 1
    }
  }

  def ai_1(past_turns: ListBuffer[String]): String = {
    if (past_turns.size > 1) past_turns(past_turns.size - 2)
    else "paper"
  }

  def ai_2(past_turns: ListBuffer[String]): String = {
    get_most_comen(get_total(past_turns.toList))
  }

  def get_total(past_turns: List[String], sub_total: (Int, Int, Int, Int, Int) = (0, 0, 0, 0, 0)): (Int, Int, Int, Int, Int) = past_turns match {
    case "rock" :: rest => get_total(rest, (sub_total._1 + 1, sub_total._2, sub_total._3, sub_total._4, sub_total._5))
    case "paper" :: rest => get_total(rest, (sub_total._1, sub_total._2 + 1, sub_total._3, sub_total._4, sub_total._5))
    case "scissors" :: rest => get_total(rest, (sub_total._1, sub_total._2, sub_total._3 + 1, sub_total._4, sub_total._5))
    case "lizard" :: rest => get_total(rest, (sub_total._1, sub_total._2, sub_total._3, sub_total._4 + 1, sub_total._5))
    case "spock" :: rest => get_total(rest, (sub_total._1, sub_total._2, sub_total._3, sub_total._4, sub_total._5 + 1))
    case Nil => sub_total
  }

  def get_Random(): String = scala.util.Random.nextInt(5) match {
    case 1 => "paper"
    case 2 => "rock"
    case 3 => "scissors"
    case 4 => "lizard"
    case 5 => "spock"
    case _ => get_Random()
  }

  def get_most_comen(total: (Int, Int, Int, Int, Int)): String = total match {
    case (0, 0, 0, 0, 0) => get_Random()
    case (r, p, s, l, k) if (r > p & r > s & r > l & r > k) => "paper"
    case (r, p, s, l, k) if (s > r & s > p & s > l & s > k) => "rock"
    case (r, p, s, l, k) if (p > s & p > r & p > l & p > k) => "scissors"
    case (r, p, s, l, k) if (l > s & l > r & l > p & l > k) => "lizard"
    case (r, p, s, l, k) if (k > s & k > r & k > p & k > l) => "spock"
    case (_, _, _, _, _) => get_Random()
  }

  def parse_char(a: Any): String = a match {

    case "r" | "R" | "rock" => "rock"
    case "p" | "P" | "paper" => "paper"
    case "s" | "S" | "scissors" => "scissors"
    case "l" | "L" | "lizard" => "lizard"
    case "k" | "K" | "spock" => "spock"
    case _ => "rock"
  }


}
