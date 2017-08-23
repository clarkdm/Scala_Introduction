import scala.collection.mutable.ListBuffer

class Rock_paper_scissors_And_More extends RPS {

  def main(args: Array[String]): Unit = {
    //run_all_V_all(10)


  }

  var opticians: List[String] = List("gun", "lightning", "devil", "dragon", "water",
    "air", "paper", "sponge", "wolf", "tree", "human", "snake", "scissors", "fire", "rock")


  //  |opticians.indexOf(player_1)+7>opticians.indexOf(player_2)
  def rock_paper_scissors(player_1: String, player_2: String): Int = (player_1, player_2) match {
    case (a, b) if a == b => 0
    case (player_1, player_2) if ((opticians.indexOf(player_1) < opticians.indexOf(player_2) & !(opticians.indexOf(player_1) < opticians.indexOf(player_2) - 7))
      | !(opticians.indexOf(player_1) - 7 < opticians.indexOf(player_2))) => 1
    case (_, _) => 2

  }

  def run(): Unit = {
    var past_turns: ListBuffer[String] = new ListBuffer[String]
    var p1_score = 0
    var ai_score = 0
    while (true) {
      println("P1: " + p1_score + "  AI:" + ai_score)
      println("rock paper scissors lizard spock")

      println("g" + " : gun")
      println("l" + " : lightning")
      println("d" + " : devil")
      println("dr" + " : dragon")
      println("wa" + " : water")
      println("a" + " : air")
      println("p" + " : paper")
      println("sp" + " : sponge")
      println("w" + " : wolf")
      println("t" + " : tree")
      println("h" + " : human")
      println("sn" + " : snake")
      println("s" + " : scissors")
      println("f" + " : fire")
      println("r" + " : rock")
      past_turns += parse_char(scala.io.StdIn.readLine())
      val ai = ai_1()
      println(past_turns(past_turns.size - 1) + " V " + ai)
      val temp = rock_paper_scissors(past_turns(past_turns.size - 1), ai)

      if (temp == 1) p1_score += 1
      else if (temp == 2) ai_score += 1
    }
  }

  def ai_1(): String = {
    get_Random()
  }

  def get_Random(): String = scala.util.Random.nextInt(16) match {
    case 1 => "gun"
    case 2 => "lightning"
    case 3 => "devil"
    case 4 => "dragon"
    case 5 => "water"
    case 6 => "air"
    case 7 => "paper"
    case 8 => "sponge"
    case 9 => "wolf"
    case 10 => "tree"
    case 11 => "human"
    case 12 => "snake"
    case 13 => "scissors"
    case 14 => "fire"
    case 15 => "rock"
    case _ => get_Random()
  }

  def parse_char(a: Any): String = a match {

    case "1" | "g" | "G" | "gun" => "gun"
    case "2" | "l" | "L" | "lightning" => "lightning"
    case "3" | "d" | "D" | "devil" => "devil"
    case "4" | "dr" | "DR" | "dragon" => "dragon"
    case "5" | "wa" | "WA" | "water" => "water"
    case "6" | "a" | "A" | "air" => "air"
    case "7" | "p" | "P" | "paper" => "paper"
    case "8" | "sp" | "SP" | "sponge" => "sponge"
    case "9" | "w" | "W" | "wolf" => "wolf"
    case "10" | "t" | "T" | "tree" => "tree"
    case "11" | "h" | "H" | "human" => "human"
    case "12" | "sn" | "SN" | "snake" => "snake"
    case "13" | "s" | "S" | "scissors" => "scissors"
    case "14" | "f" | "f" | "fire" => "fire"
    case "15" | "r" | "R" | "rock" => "rock"

    case _ => "rock"
  }

  override def ai_0(): String = {
    get_Random()
  }

  override def run_ai_ai(num: Int): Unit = ???
}