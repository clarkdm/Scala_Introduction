package Garage

abstract class Person {

  val p_id: Int
  val f_name: String
  val s_name: String

  def get_p_id(): Int

  def get_f_name(): String

  def get_s_name(): String

  override def toString = s"Person(get_p_id=$get_p_id, get_f_name=$get_f_name, get_s_name=$get_s_name)"
}


