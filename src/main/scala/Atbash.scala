object Atbash {


  val cipher = Map(
    'a' -> 'z',
    'b' -> 'y',
    'c' -> 'x',
    'd' -> 'w',
    'e' -> 'v',
    'f' -> 'u',
    'g' -> 't',
    'h' -> 's',
    'i' -> 'r',
    'j' -> 'q',
    'k' -> 'p',
    'l' -> 'o',
    'm' -> 'n',
    'n' -> 'm',
    'o' -> 'l',
    'p' -> 'k',
    'q' -> 'j',
    'r' -> 'i',
    's' -> 'h',
    't' -> 'g',
    'u' -> 'f',
    'v' -> 'e',
    'w' -> 'd',
    'x' -> 'c',
    'y' -> 'b',
    'z' -> 'a')

  def swop(x: Char): Char = {
    cipher(x)
  }

  def atbash(x: String): String = {
    var y = ""
    for (a <- x) {
      y += swop(a)
    }
    y
  }


}
