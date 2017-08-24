import scala.collection.mutable.ListBuffer

object RearangingOrSorting {

  def main(args: Array[String]): Unit = {
    get_String()
  }

  def get_Int(): Unit = {
    var nums: ListBuffer[Int] = new ListBuffer[Int]
    while (true) {

      nums += parse_Int(scala.io.StdIn.readLine())
      nums = nums.sorted
      print_nums(nums.toList)
    }
  }

  def print_nums(nums: List[Int]): Unit = {
    for (x<-nums) printf(x+" ")
  }

  def parse_Int(str: String) = str.toInt match {
    case x: Int => x
    case _ => 0
  }

  def get_String(): Unit = {
    var str: ListBuffer[String] = new ListBuffer[String]
    while (true) {

      str += parse_String(scala.io.StdIn.readLine())
      str = str.sorted
      print_String(str.toList)
    }
  }

  def print_String(nums: List[String]): Unit = {
    for (x<-nums) printf(x+" ")
  }

  def parse_String(str: String):String = str match {
    case x: String => x
    case _ => "HI"
  }


}
