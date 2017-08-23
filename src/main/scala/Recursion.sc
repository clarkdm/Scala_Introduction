sum(44)
def sum(n: Int): Int = n match {
  case 0 => 0
  case n => n + sum(n - 1)
}
factorial(5)
def factorial(n: Int): Int = n match {
  case 0 => 1
  case 1 => 1
  case n => n * factorial(n - 1)
}
zeros(Array(0,4,5,6,3,0,7,5,6,0,7,0,4,0,7,8,0,2))
def zeros(n: Array[Int]): Int = n.isEmpty match {
  case true => 0
  case false if n.head==0 => 1+zeros(n.tail)
  case false => 0+zeros(n.tail)
}
minimum(Array(36,24,5,6,36,62,7,5,6,5,7,5,7,6,7,8,6,65))
def minimum(n: Array[Int],min:Int=2147483647): Int = n.isEmpty match {
  case true => min
  case false if n.head<min => minimum(n.tail,n.head)
  case false => minimum(n.tail,min)
}
prints_all(Array(36,24,5,6,36,62,7,5,6,5,7,5,7,6,7,8,6,65))
def prints_all(n: Array[Int],min:Int=2147483647):Unit = n.isEmpty match {
  case true =>
  case false => println(n.head);prints_all(n.tail)
}
sum_2(-4411)
def sum_2(n: Int): Int = n match {
  case 0 => 0
  case n if n<0 => sum_2(-n)
  case n => n%10 + sum_2(n/10 )
}


