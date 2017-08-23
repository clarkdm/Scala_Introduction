import scala.collection.mutable.ListBuffer

object RPS_all {


  def main(args: Array[String]): Unit = {
    start()
  }

  var game: RPS = new RockPaperScissors()
def start(): Unit ={

  println("rps   = rock paper scissors")
  println("rpsls = Rock_paper_scissors_lizard_spock")
  println("rps15 = Rock_paper_scissors_And_More")

  run(scala.io.StdIn.readLine())


}
  def run(run: String): Unit = run.split(" ").toList match {
    case "rps" :: Nil => game = new RockPaperScissors(); game.run()
    case "rps" :: "all" :: x :: Nil => game = new RockPaperScissors(); run_all_V_all(parse_Int(x), game)
    case "rpsls" :: Nil => game = new Rock_paper_scissors_lizard_spock; game.run()
    case "rpsls" :: "all" :: x :: Nil => game = new Rock_paper_scissors_lizard_spock; run_all_V_all(parse_Int(x), game)
    case "rps15" :: Nil => game = new Rock_paper_scissors_And_More; game.run()
    case "rps15" :: "all" :: x :: Nil => game = new Rock_paper_scissors_And_More; run_all_V_all(parse_Int(x), game)
    case Nil => game = new RockPaperScissors(); run_all_V_all(10, game)
  }

  def parse_Int(str: String) = str.toInt match {
    case x: Int if x > 1 => x
    case _ => 3
  }

  def run_all_V_all(num: Int, rps: RPS): Unit = {
    var alive = num
    var game_num = 0
    var players: ListBuffer[(Int, String, Boolean, Boolean, Boolean)] = new ListBuffer[(Int, String, Boolean, Boolean, Boolean)]
    for (x <- 1 to alive) players += Tuple5(x, rps.ai_0(), true, false, false)
    while (alive > 1) {
      game_num += 1
      for (x <- 0 to alive - 1) players(x) = Tuple5(players(x)._1, rps.ai_0(), true, false, false)
      var tie: Boolean = false
      for (x <- 0 to alive - 2; y <- x + 1 to alive - 1) {
        if (!tie) {
          val temp = all_rock_paper_scissors(players(x), players(y))
          val p1 = temp._1
          val p2 = temp._2
          if (p1._4 & p1._5 | p2._4 & p2._5) tie = true
          players(x) = is_alive(p1)
          players(y) = is_alive(p2)
        }
      }
      if (tie) for (x <- 0 to alive - 1) players(x) = Tuple5(players(x)._1, players(x)._2, true, false, false)
      else players = players.filter(_._3 == true)
      alive = players.size
      println(game_num+ " alive : "+alive)
    }
    println(players)
    println(game_num)
  }

  def is_alive(player: (Int, String, Boolean, Boolean, Boolean)): (Int, String, Boolean, Boolean, Boolean) = player match {
    case (p1, x, _, win1, true) => (p1, x, false, win1, true)
    case (p1, x, a1, win1, lose1) => (p1, x, a1, win1, lose1)
  }

  def all_rock_paper_scissors(player_1: (Int, String, Boolean, Boolean, Boolean), player_2: (Int, String, Boolean, Boolean, Boolean)): ((Int, String, Boolean, Boolean, Boolean), (Int, String, Boolean, Boolean, Boolean)) = (player_1, player_2) match {
    case ((p1, x, a1, true, true), (p2, y, a2, _, _)) => ((p1, x, a1, true, true), (p2, y, a2, true, true))
    case ((p1, x, a1, _, _), (p2, y, a2, true, true)) => ((p1, x, a1, true, true), (p2, y, a2, true, true))
    case ((p1, x, a1, win1, lose1), (p2, y, a2, win2, lose2)) if game.rock_paper_scissors(x, y) == 0 => ((p1, x, a1, win1, lose1), (p2, y, a2, win2, lose2))
    case ((p1, x, a1, _, lose1), (p2, y, a2, win2, _)) if game.rock_paper_scissors(x, y) == 1 => ((p1, x, a1, true, lose1), (p2, y, a2, win2, true))
    case ((p1, x, a1, win1, _), (p2, y, a2, _, lose2)) if game.rock_paper_scissors(x, y) == 2 => ((p1, x, a1, win1, true), (p2, y, a2, true, lose2))
    case ((p1, x, a1, win1, lose1), (p2, y, a2, win2, lose2)) => ((p1, x, a1, win1, lose1), (p2, y, a2, win2, lose2))
  }

}