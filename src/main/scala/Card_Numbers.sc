println("hi")
println(is_valid("49927398716"))

def is_valid(num: String): Boolean = get_sum(num)%10 match{
  case 0 => true
  case _ => false
}


def get_sum(num: String, doubled: Boolean = false): Int = doubled match {
  case false if num.length < 2 => parse_Int(num)
  case true if num.length < 2 => parse_Int(num)
  case false  => parse_Int(num.head.toString) + get_sum(num.tail,true)
  case true  => (((parse_Int(num.head.toString)%10)*2)/10) +(((parse_Int(num.head.toString)%10)*2)%10) + get_sum(num.tail,false)
}




def parse_Int(str: String) = str.toInt match {
  case x:Int => x
}


