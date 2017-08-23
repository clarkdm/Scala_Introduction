object Tetrahedral_number {


  def main(args: Array[String]): Unit = {
val n:Double =  169179692512835000.0D
    println(get_base(n))
  }

  def get_base(num: Double): Double =  {
  var n:Double=2D
    while (num != ((n * (n + 1) * (n + 2)) / 6)){
      n+=1
    }
    n
  }










}
