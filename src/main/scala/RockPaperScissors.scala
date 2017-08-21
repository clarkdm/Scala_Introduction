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
    for (x <- 0 to 1000000) {
      println("AI_1: " + ai_1_score + "  AI_2:" + ai_2_score)

      past_turns_1 += ai_2(past_turns_2)
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
    var r = 0
    var p = 0
    var s = 0
    for (turn <- past_turns) {
      if (turn == 'r') r += 1
      if (turn == 'p') p += 1
      if (turn == 's') s += 1
    }

    if (r > p & r > s) 'p'
    else if (s > r & s > p) 'r'
    else if (p > s & p > r) 's'
    else {
      val num = scala.util.Random
      val temp = num.nextInt(3)
      if (temp==1) 'p'
      else if (temp==2) 'r'
      else if (temp==3) 's'
      else 's'


    }
  }

  def parse_char(a: Any): Char = a match {
    case a: Char => a.toLower
    case a: String => a(0).toLower
    case _ => 'E'
  }
}
