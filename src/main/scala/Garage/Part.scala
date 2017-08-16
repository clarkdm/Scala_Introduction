package Garage

class Part(t_name: String,
           t_£: Double,
           t_time: Int,
           t_broken: Boolean = false) {

  val name = t_name
  val £ = t_£
  val time = t_time
  var broken = t_broken


  override def toString = s"Part(name=$name, £=$£, time=$time, broken=$broken)"
}
