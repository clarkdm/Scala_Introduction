
l_scale("1234567891111")
s_scale("1234567891111")


def s_scale(n: String): String = n match {
  case "" => ""
  case n if n.length < 4 => n.toString
  case n if n.length < 7 => n.substring(0,n.length-3)+ " thousand and " + s_scale(n.substring(n.length-3,n.length))
  case n if n.length < 10 => n.substring(0,n.length-6)+ " million, " + s_scale(n.substring(n.length-6,n.length))
  case n if n.length < 13 => n.substring(0,n.length-9)+ " billion, " + s_scale(n.substring(n.length-9,n.length))
  case n if n.length < 16 => n.substring(0,n.length-12)+ " trillion, " + s_scale(n.substring(n.length-12,n.length))

  case n => ""
}
def l_scale(n: String): String = n match {
  case "" => ""
  case n if n.length < 4 => n.toString
  case n if n.length < 7 => n.substring(0,n.length-3)+ " thousand and " + l_scale(n.substring(n.length-3,n.length))
  case n if n.length < 10 => n.substring(0,n.length-6)+ " million, " + l_scale(n.substring(n.length-6,n.length))
  case n if n.length < 13 => n.substring(0,n.length-9)+ " milliard, " + l_scale(n.substring(n.length-9,n.length))
  case n if n.length < 16 => n.substring(0,n.length-12)+ " billion, " + l_scale(n.substring(n.length-12,n.length))

  case n => ""
}