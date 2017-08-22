import scala.collection.mutable.ListBuffer

object RockPaperScissors {


  def main(args: Array[String]): Unit = {
    run_ai_ai()
  }


  def rock_paper_scissors(player_1: Char, player_2: Char): Int = (player_1, player_2) match {
    case ('r', 'r') => 0
    case ('p', 'p') => 0
    case ('s', 's') => 0
    case ('s', 'p') => 1
    case ('s', 'r') => 2
    case ('p', 'r') => 1
    case ('p', 's') => 2
    case ('r', 's') => 1
    case ('r', 'p') => 2
    case (_, _) => -1

  }

  def run(): Unit = {
    var past_turns: ListBuffer[Char] = new ListBuffer[Char]
    var p1_score = 0
    var ai_score = 0
    while (true) {
      println("P1: " + p1_score + "  AI:" + ai_score)
      println("rock paper scissors")
      println("r = rock")
      println("p = paper")
      println("s = scissors")
      past_turns += parse_char(scala.io.StdIn.readLine())
      val temp = rock_paper_scissors(past_turns(past_turns.size - 1), ai_2(past_turns))
      if (temp == 1) p1_score += 1
      else if (temp == 2) ai_score += 1
    }
  }

  def run_ai_ai(): Unit = {
    var past_turns_1: ListBuffer[Char] = new ListBuffer[Char]
    var past_turns_2: ListBuffer[Char] = new ListBuffer[Char]
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

  def ai_1(past_turns: ListBuffer[Char]): Char = {
    if (past_turns.size > 1) past_turns(past_turns.size - 2)
    else 'p'
  }

  def ai_2(past_turns: ListBuffer[Char]): Char = {
    get_most_comen(get_total(past_turns.toList))
  }

  def get_total(past_turns: List[Char], sub_total: (Int, Int, Int) = (0, 0, 0)): (Int, Int, Int) = past_turns match {
    case 'r' :: rest => get_total(rest, (sub_total._1+1,sub_total._2,sub_total._3))
    case 'p' :: rest => get_total(rest, (sub_total._1,sub_total._2+1,sub_total._3))
    case 's' :: rest => get_total(rest, (sub_total._1,sub_total._2,sub_total._3+1))
    case Nil => sub_total
  }

  def get_Random(): Char = scala.util.Random.nextInt(3) match {
    case 1 => 'p'
    case 2 => 'r'
    case 3 => 's'
    case _ => get_Random()
  }

  def get_most_comen(total: (Int, Int, Int)): Char = total match {
    case (0, 0, 0) => get_Random()
    case (r, p, s) if (r > p & r > s) => 'p'
    case (r, p, s) if (s > r & s > p) => 'r'
    case (r, p, s) if (p > s & p > r) => 's'
    case (_, _, _) => get_Random()
  }

  def parse_char(a: Any): Char = a match {
    case a: Char => a.toLower
    case a: String => a(0).toLower
    case _ => 'E'
  }
}
