package Garage

class Bike(z: Int, x: Int, c: String) extends Vehicle {
  override val v_id = z
  override val p_id = x
  override val v_make = c
  override var fixed = false
  override var bill = 0

  def get_v_id(): Int = {
    v_id
  }

  def get_p_id(): Int = {
    p_id
  }

  def get_v_make(): String = {
    v_make
  }

  def get_fixed(): Boolean = {
    fixed
  }

  def get_bill(): Int = {
    bill
  }

  def set_fixed(x: Boolean): Unit = {
    fixed = x
  }
}

