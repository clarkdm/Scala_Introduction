class Hangman_Board {

  var str: StringBuilder = new StringBuilder("")
  var i: Int = 0


  def add(): Unit = i match {
    case 0 => str.append("    |"); i += 1
    case 1 => str.append("    |"); i += 1
    case 2 => str.insert(0, "    __|___" + "\n"); i += 1
    case 3 => str.insert(0, "      |    " + "\n"); i += 1
    case 4 => str.insert(0, "      |       " + "\n"); i += 1
    case 5 => str.insert(0, "      |       " + "\n"); i += 1
    case 6 => str.insert(0, "      |      " + "\n"); i += 1
    case 7 => str.insert(0, "      _______" + "\n"); i += 1
    case 8=> str.insert(26, '|'); i += 1
    case 9  => str.insert(41, "O"); i += 1
    case 10 => str.insert(57, "|"); i += 1
    case 11 => str.replace(56, 57, "/"); i += 1
    case 12 => str.insert(58, "\\"); i += 1
    case 13 => str.insert(73, "/"); i += 1
    case 14 => str.insert(74, " \\"); i += 1
    case _ =>
  }

  def reSet(): Unit = {
    str = new StringBuilder("")
    i = 0
  }

  def game_O():Boolean = i match {
    case 15 => true
    case _ => false
  }

  override def toString = s"$str"
}