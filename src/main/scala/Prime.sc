import scala.collection.mutable.ListBuffer



println(Prime_List((2 to 100000).toList).size)


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