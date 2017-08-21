val str_1: String = "wertyui"
val str_2: String = "werfghjkl"

println(transform(str_1, str_2))

def subsequence(str_1: String, str_2: String): String = {
  var size = 0
  var temp = ""
  for (x <- 0 to str_1.length; y <- x + 1 to str_1.length) {
    if ((y - x) > size & str_2.contains(str_1.subSequence(x, y))) {
      size = y - x
      temp = str_1.substring(x, y)
    }
  }
  temp
}

def transform(str_1: String, str_2: String): Int = (str_1,str_2) match {
  case ("","") => 0
  case (a,"") => a.length
  case ("",a) => a.length
  case (a,b) if a.length>b.length => a.length-subsequence(a,b).length
  case (a,b)  => b.length-subsequence(a,b).length
}
