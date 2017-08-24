object bottles_of_beer {


  def main(args: Array[String]): Unit = {
    println(b_of_b())
  }


  def b_of_b(num: Int=99): String = num match {
case 0 => "No more bottles of beer on the wall, no more bottles of beer. \nGo to the store and buy some more, 99 bottles of beer on the wall.\n\n"
case 1 =>"1 bottle of beer on the wall, 1 bottle of beer.\nTake one down and pass it around, no more bottles of beer on the wall.\n\n"+ b_of_b(num-1)
case n =>  n + " bottles of beer on the wall, "+n+" bottles of beer.\nTake one down and pass it around, "+(n-1)+" bottle of beer on the wall.\n\n"+b_of_b(num-1)
  }
}
