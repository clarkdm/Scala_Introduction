
scale("1234567891111",'s')
scale("1234567891111",'l')


def scale(n: String, scale_Tipe: Char): String = (n, scale_Tipe) match {
  case ("", _) => ""
  case (n, _) if n.length < 4 => n.toString
  case (n, 's') if n.length < 7 => n.substring(0, n.length - 3) + " thousand and " + scale(n.substring(n.length - 3, n.length), scale_Tipe)
  case (n, 's') if n.length < 10 => n.substring(0, n.length - 6) + " million, " + scale(n.substring(n.length - 6, n.length), scale_Tipe)
  case (n, 's') if n.length < 13 => n.substring(0, n.length - 9) + " billion, " + scale(n.substring(n.length - 9, n.length), scale_Tipe)
  case (n, 's') if n.length < 16 => n.substring(0, n.length - 12) + " trillion, " + scale(n.substring(n.length - 12, n.length), scale_Tipe)
  case (n, 'l') if n.length < 7 => n.substring(0, n.length - 3) + " thousand and " + scale(n.substring(n.length - 3, n.length), scale_Tipe)
  case (n, 'l') if n.length < 10 => n.substring(0, n.length - 6) + " million, " + scale(n.substring(n.length - 6, n.length), scale_Tipe)
  case (n, 'l') if n.length < 13 => n.substring(0, n.length - 9) + " milliard, " + scale(n.substring(n.length - 9, n.length), scale_Tipe)
  case (n, 'l') if n.length < 16 => n.substring(0, n.length - 12) + " billion, " + scale(n.substring(n.length - 12, n.length), scale_Tipe)
}