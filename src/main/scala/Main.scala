object Main {


  def main(args: Array[String]): Unit = {


    println("Hello World!")


    var a = "Hello World!"
    p_out(h_W())
    println(pas("hi"))
    println(pas(1))
    println(pas(2.2))

    println(Strings("Hello", 3))
    println(Strings_2("Ha", "llo", 'a', 'e'))

    println()

    println(operators(5, 6, true))
    println(operators(5, 6, false))
    println(operators(0, 6, true))
    println(operators(5, 0, false))
    println(operators(5, 0, true))
    println(operators(0, 6, false))

    println()
    iteration_1_1("hi", 3)
    iteration_2_1("hi", 3)

    f_b_1("Fizz", "Buzz", 15)

    println(iteration_1_2("hi", 3))
    println(iteration_2_2("hi", 3))

    println(f_b_2("Fizz", "Buzz", 15))


    println(operators_2(5, 6, true))
    println(operators_2(5, 6, false))
    println(operators_2(0, 6, true))
    println(operators_2(5, 0, false))
    println(operators_2(5, 0, true))
    println(operators_2(0, 6, false))
    println(operators_2(0, 0, true))
    println(operators_2(0, 0, false))


    println()
    var x = List(1, 2, 3, 4)
    var b = (1, 2)

    println(b)
    println(swap(b))
    println(x)
    println(swap(x))

    println()

    println(blackJack(1, 1))
    println(blackJack(21, 1))
    println(blackJack(10, 21))
    println(blackJack(21, 21))
    println(blackJack(22, 1))
    println(blackJack(1, 22))
    println(blackJack(22, 22))

    println("uniqueSum")

    println(uniqueSum(1, 2, 3))
    println(uniqueSum(3, 3, 3))
    println(uniqueSum(1, 1, 3))
    println(uniqueSum(1, 3, 3))
    println(uniqueSum(2, 3, 2))

    println("Too hot?")
    println(tooHot(80, false))
    println(tooHot(100, false))
    println(tooHot(100, true))
    println()
  }


  def p_out(temp: String) = {
    println(temp)
  }

  def h_W(): String = {
    "Hello World!"
  }

  def pas(temp: Any) = {
    temp
  }


  def Strings(st: String, i: Int): String = {
    st.substring(st.length - i, st.length)
  }

  def Strings_2(st_1: String, st_2: String, ch_1: Char, ch_2: Char): String = {
    st_1.concat(st_2).replace(ch_1, ch_2)
  }


  def operators(a: Int, b: Int, o: Boolean): Int = {

    if (o || a == 0 || b == 0)
      a + b
    else
      a * b
  }

  def iteration_1_1(st_1: String, i: Int) = {

    for (x <- 1 to i) {
      println(st_1)

    }
  }

  def iteration_1_2(str: String, i: Int): String = {

    if (i > 0) {
      str.concat("\n").concat(iteration_1_2(str, i - 1))

    } else ""

  }

  def iteration_2_1(st_1: String, i: Int) = {
    var temp = ""
    for (x <- 1 to i) {
      for (y <- 1 to i) {
        temp = temp.concat(st_1)

      }
      temp = temp.concat("\n")

    }

    printf(temp)
  }

  def iteration_2_2(st_1: String, i: Int): String = {

    if (i > 0) {
      iteration_1_2(iteration_2_2_2(st_1, i), i)

    } else {
      ""
    }


  }


  def iteration_2_2_2(st_1: String, x: Int): String = {

    if (x > 0) {

      st_1.concat(iteration_2_2_2(st_1, x - 1))

    } else {
      ""
    }


  }

  def f_b_1(f: String, b: String, t: Int): Unit = {

    for (x <- 1 to t) {
      var temp = ""
      if (x % 3 == 0) temp = f
      if (x % 5 == 0) {
        temp = temp.concat(b)
      }
      if ((x % 3 != 0) && ((x % 5 != 0))) {
        temp = x.toString
      }

      println(temp)

    }
  }

  def f_b_2(f: String, b: String, t: Int): String = {

    if (t > 0) {
      var temp = ""
      if (t % 3 == 0) temp = f
      if (t % 5 == 0) {
        temp = temp.concat(b)
      }
      if ((t % 3 != 0) && ((t % 5 != 0))) {
        temp = t.toString
      }
      f_b_2(f, b, t - 1).concat("\n").concat(temp)

    } else {
      ""
    }


  }

  def operators_2(a: Int, b: Int, u: Boolean): Int = (a, b, u) match {
    case (_, _, true) => a + b
    case (0, 0, false) => 0
    case (_, 0, false) => a
    case (0, _, false) => b
    case (_, _, false) => a * b

  }

  def swap(a: Any): Any = a match {

    case Nil => Nil
    case a :: r :: _ => (r, a)
    case a :: r => (r, a)


    //case a: Array[Any] => a.reverse
    case a: Tuple1[Any] => a
    case a: (Any, Any) => (a._2, a._1)
    case _ => a

  }


  def blackJack(a: Int, b: Int): Int = (a, b) match {
    case (a, b) if (a == b && a > 21) => 0
    case (a, b) if (a > 21 && b > 21) => 0
    case (a, b) if (a > 21 && b <= 21) => b
    case (a, b) if (a <= 21 && b > 21) => a

    case (a, b) if (a == b) => a
    case (a, b) if (b > a) => b
    case (a, b) if (a > b) => a
  }

  def uniqueSum(z: Int, x: Int, c: Int) = {
    var t = 0
    if (z == x && x == c) {
      t = 0
    }
    if (z != x && x == c) {
      t = z
    }
    if (z == x && x != c) {
      t = c
    }
    if (z == c && x != c) {
      t = x
    }
    if ((z != x) && (x != c) && (c != z)) {
      t = z + x + c
    }
    t

  }

  def tooHot(temperature: Int, isSummer: Boolean): Boolean = isSummer match {
    case false if (temperature >= 60 && temperature <= 90) => true
    case true if (temperature >= 90 && temperature <= 100) => true
    case _ => false
  }

}
