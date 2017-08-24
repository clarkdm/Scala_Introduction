package Battleships

import scala.collection.mutable.ListBuffer

class Ship(s_type: Char, x_y_d: (Int, Int, Char)) {
  var hp = 0
  s_type match {
    case 'c' => hp = 5
    case 'b' => hp = 4
    case 'd' => hp = 3
    case 's' => hp = 3
    case 'p' => hp = 2
  }
  var x_y_alive: ListBuffer[(Int, Int, Boolean)] = new ListBuffer[(Int, Int, Boolean)]
  for (n <- hp) {
    x_y_d._3 match {
      case 'v' => x_y_alive += Tuple3(x_y_d._1 + n, x_y_d._2, true)
      case 'h' => x_y_alive += Tuple3(x_y_d._1, x_y_d._2 + n, true)
    }

  }
def is_Alive():Boolean=hp match {
  case 0 => true
  case _ => false
}
  def getType(): Char = {
    s_type
  }

  def hit(x_y: (Int, Int)): Boolean ={
if(x_y_alive.contains(Tuple3(x_y._1,x_y._2,true))) {hp-=1;true}
else false

  }


}
