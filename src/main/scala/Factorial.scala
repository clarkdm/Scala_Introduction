object Factorial {

  def factorial(x: Int, index: Int = 2): Option[Int] = {
    var t = x % index
    var temp = x / index
    var r: Option[Int] = Option(0)
//    println("h " + index)
//    println("hh " + t)
//    println("hhh " + x)
    if (t == 1 && x == 1) {
      r = Option(index-1)
    } else {
      if (t == 0) {
        if (x == 1) {
          r = Option(index-1)
        } else {

          r = factorial(temp, index + 1)
        }
      } else {

      }
    }
    r
  }

}
