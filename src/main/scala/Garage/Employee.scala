package Garage

class Employee(id: Int, f: String, s: String) extends Person {
  override val p_id = id
  override val f_name = f
  override val s_name = s
  var v_id: Int = 0

  def get_p_id(): Int = {
    p_id
  }

  def get_f_name(): String = {
    f_name
  }

  def get_s_name(): String = {
    s_name
  }

  def set_v_id(id: Int) = {
    v_id = id
  }

  def get_s_v_id(): Int = {
    v_id
  }

  def is_available(): Boolean = {
    if (v_id == 0) {
      true
    } else {
      false
    }
  }










}
