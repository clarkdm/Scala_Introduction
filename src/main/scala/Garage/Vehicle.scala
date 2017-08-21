package Garage

abstract class Vehicle {
  val v_id: Int
  val p_id: Int
  val v_make: String


  var parts: List[Part]


  def get_time(): Int

  def get_No_Broken(): Int

  def get_bill(): Double

  def get_Not_fixed(): String

  def get_parts(): String

  def fix(name: String): Double


  def get_v_id(): Int

  def get_p_id(): Int

  def get_v_make(): String



  def fix_All(): (Int,Double)


  override def toString = s"Car(v_id=$v_id, p_id=$p_id, v_make=$v_make, get_time=$get_time, get_No_Broken=$get_No_Broken, get_bill=$get_bill)"


}
