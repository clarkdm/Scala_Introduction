import scala.collection.mutable.ListBuffer

//val test_1 = (2 to 30).toList
//val test_1 = (2 to 100000).toList
//val test_1 = (1000000 to 3000000 ).toList


println(Prime_List((2 to 100000).toList).size)
println("hi")

def Prime_List(targets: List[Int]): List[Int] = {

  var primes = new ListBuffer[Int]()

  var temp = next_Prime_List(targets)

  while (temp._2!=Nil){


    primes+=temp._1
    temp = next_Prime_List(temp._2)

    }
  primes+=temp._1
  primes.toList
}


def next_Prime_List(targets: List[Int]): (Int, List[Int]) = targets match {
  case s :: rest => (s, rest.filter(_ % s != 0))
  case Nil => (0, Nil)
}