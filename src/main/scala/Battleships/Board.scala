package Battleships

import scala.collection.mutable.ListBuffer


class Board(size: Int = 12, available_ships: List[Char]) {

  var ships: ListBuffer[Ship] = new ListBuffer[Ship]


  def take_Shot(x_y: (Int, Int)): Boolean = {
    var hit = false
    for (s <- ships) if (s.hit(x_y)) hit = true
    hit
  }

  def is_Alive(): Boolean = {
    var alive = false
    for (s <- ships) if (s.is_Alive()) alive = true
    alive
  }

  def getSize(): Int = {
    size
  }

  def add_Boat(str: String): Boolean = str.split(" ").toList match {
    case "c" :: x :: y :: "v" :: _ if can_plas_Ship('c', parse_Int(x), parse_Int(y), 'v') => ships += new Ship('c', Tuple3(parse_Int(x), parse_Int(y), 'v')); true
    case "c" :: x :: y :: "h" :: _ if can_plas_Ship('c', parse_Int(x), parse_Int(y), 'h') => ships += new Ship('c', Tuple3(parse_Int(x), parse_Int(y), 'h')); true
    case "b" :: x :: y :: "v" :: _ if can_plas_Ship('b', parse_Int(x), parse_Int(y), 'v') => ships += new Ship('b', Tuple3(parse_Int(x), parse_Int(y), 'v')); true
    case "b" :: x :: y :: "h" :: _ if can_plas_Ship('b', parse_Int(x), parse_Int(y), 'h') => ships += new Ship('b', Tuple3(parse_Int(x), parse_Int(y), 'h')); true
    case "d" :: x :: y :: "v" :: _ if can_plas_Ship('d', parse_Int(x), parse_Int(y), 'v') => ships += new Ship('d', Tuple3(parse_Int(x), parse_Int(y), 'v')); true
    case "d" :: x :: y :: "h" :: _ if can_plas_Ship('d', parse_Int(x), parse_Int(y), 'h') => ships += new Ship('d', Tuple3(parse_Int(x), parse_Int(y), 'h')); true
    case "s" :: x :: y :: "v" :: _ if can_plas_Ship('s', parse_Int(x), parse_Int(y), 'v') => ships += new Ship('s', Tuple3(parse_Int(x), parse_Int(y), 'v')); true
    case "s" :: x :: y :: "h" :: _ if can_plas_Ship('s', parse_Int(x), parse_Int(y), 'h') => ships += new Ship('s', Tuple3(parse_Int(x), parse_Int(y), 'h')); true
    case "p" :: x :: y :: "v" :: _ if can_plas_Ship('p', parse_Int(x), parse_Int(y), 'v') => ships += new Ship('p', Tuple3(parse_Int(x), parse_Int(y), 'v')); true
    case "p" :: x :: y :: "h" :: _ if can_plas_Ship('p', parse_Int(x), parse_Int(y), 'h') => ships += new Ship('p', Tuple3(parse_Int(x), parse_Int(y), 'h')); true
    case _ => false
    case Nil => false
  }

  def can_plas_Ship(s_type: Char, x: Int, y: Int, d: Char, n: Int = -1): Boolean = (s_type, n) match {
    case ('c', -1) => can_plas_Ship(s_type, x, y, d, 5)
    case ('b', -1) => can_plas_Ship(s_type, x, y, d, 4)
    case ('d', -1) => can_plas_Ship(s_type, x, y, d, 3)
    case ('s', -1) => can_plas_Ship(s_type, x, y, d, 3)
    case ('p', -1) => can_plas_Ship(s_type, x, y, d, 2)
    case (_, 0) => true
    case (_, n) => can_plas(x, y, d, n) & can_plas_Ship(s_type, x, y, d, n - 1)
  }

  def can_plas(x: Int, y: Int, d: Char, num: Int): Boolean = d match {

    case 'v' => is_empte((x, y + num))
    case 'h' => is_empte((x + num, y))
    case _ => false
  }

  def is_empte(x_y: (Int, Int)): Boolean = {
    var hit = false
    for (s <- ships) if (s.will_hit(x_y)) hit = true
    !hit
  }


  def get_not_plas_Boats(): List[Char] = {
    available_ships
  }

  def print_available_ships(ships: List[Char]): String = ships match {
    case 'c' :: rest => "carrier of size 5 " + print_available_ships(rest)
    case 'b' :: rest => "battleships of size 4 " + print_available_ships(rest)
    case 'd' :: rest => "destroyer of size 3 " + print_available_ships(rest)
    case 's' :: rest => "submarine of size 3 " + print_available_ships(rest)
    case 'p' :: rest => "patrol boat of size 2 " + print_available_ships(rest)
    case _ => ""
  }

  def parse_Int(str: String) = str.toInt match {
    case x => x
    case _ => 0
  }
def print(x:Int,y:Int):String = (x, y)match {
case a => ???

}
//   override def toString = {
//    for (x<-size;y<-size){
//
//    }
//
//
//
//  }
}
