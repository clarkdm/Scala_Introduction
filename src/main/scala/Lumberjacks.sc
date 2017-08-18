//  7
//  1 1 1
//  2 1 3
//  1 4 1

//  3 2 2
//  2 2 3
//  2 4 2

var x: Array[Array[Int]] = Array(Array(1, 1, 1), Array(2, 1, 3), Array(1, 4, 1))
x = add(x, 8)


def add(pile: Array[Array[Int]], n: Int = 1): Array[Array[Int]] = n match {
  case 0 => pile
  case n => add_(pile, n, 0)
}

def add_(pile: Array[Array[Int]], n: Int = 1, i: Int = 0, r: Int = 0): Array[Array[Int]] = n match {

  case 0 => pile
  case n => {


    if (pile(r).indexOf(i) >= 0) {
      pile(r)(pile(r).indexOf(i)) = pile(r)(pile(r).indexOf(i)) + 1
      add_(pile, n - 1, i)
    } else if (r == pile.size - 1) add_(pile, n, i + 1, 0)
    else add_(pile, n, i, r + 1)

  }
}
println("hi")
print(x)

def print(pile: Array[Array[Int]]): Unit = {
  for (x <- 0 to pile.size - 1; y <- 0 to pile.size - 1) {
    printf(pile(x)(y)+" ")
    if (y == pile.size - 1) printf("\n")
  }
}
