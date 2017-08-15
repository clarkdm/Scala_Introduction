package Garage

abstract class Vehicle {
  val v_id: Int
  val p_id: Int
  val v_make: String
  var fixed: Boolean
  var bill: Int

  def get_v_id(): Int

  def get_p_id(): Int

  def get_v_make(): String

  def get_fixed(): Boolean

  def get_bill(): Int

  def set_fixed(x: Boolean)
}
