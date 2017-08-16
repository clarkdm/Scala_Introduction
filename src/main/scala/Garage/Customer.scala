package Garage

class Customer(id: Int, f: String, s: String) extends Person {
  override val p_id = id
  override val f_name = f
  override val s_name = s

  def get_p_id(): Int = {
    p_id
  }

  def get_f_name(): String = {
    f_name
  }

  def get_s_name(): String = {
    s_name
  }

  override def toString = s"Customer(get_p_id=$get_p_id, get_f_name=$get_f_name, get_s_name=$get_s_name)"
}
