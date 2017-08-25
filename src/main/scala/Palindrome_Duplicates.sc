println(palindromic("hannah"))
println(palindromic("12321"))
def palindromic(str: String, index: Int = 0): Boolean = str.isEmpty match {
  case true => false
  case false if str.length < 2 => false
  case false if (index > (str.length / 2)) => true
  case false if str(index) == str(str.length() - index - 1) => palindromic(str, index + 1)
  case false => false
}
duplicates(Array(4,5,2,1,7,8,9,3,6,54,22,11,22,45,66))
def duplicates(a:Array[Int]):Int = a.isEmpty match {
case true => 0
case false if a.tail.contains(a.head)=>  a.head
case false =>  duplicates(a.tail)
}

