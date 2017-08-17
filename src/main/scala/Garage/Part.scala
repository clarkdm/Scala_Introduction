package Garage

class Part(t_name: String,
           t_bill: Double,
           t_time: Int,
           t_broken: Boolean = false) {

  val name = t_name
  val bill = t_bill
  val time = t_time
  var broken = t_broken


  override def toString = s"Part(name=$name, bill=$bill, time=$time, broken=$broken)"
}
