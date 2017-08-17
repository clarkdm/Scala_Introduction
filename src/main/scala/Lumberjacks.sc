//  7
//  1 1 1
//  2 1 3
//  1 4 1

//  3 2 2
//  2 2 3
//  2 4 2

var x: Array[Int] = Array(1, 1, 1,
  2, 1, 3,
  1, 4, 1)
add(x, 7)



def add(pile: Array[Int], n: Int = 1): Array[Int] = n match {
  case 0 => pile
  case n => add_(pile, n, 0)
}

def add_(pile: Array[Int], n: Int = 1, i: Int = 0): Array[Int] = n match {

  case 0 => pile
  case n => {
    var t: Array[Int] = pile
    println("hi" + t.indexOf(i))
    if (t.indexOf(i) >= 0) {
      t(t.indexOf(i)) = t(t.indexOf(i)) + 1
      t = add_(t, n - 1, i)
    } else t = add_(pile, n, i + 1)
    t
  }


}