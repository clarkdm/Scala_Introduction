package Garage

class Car(t_v_id: Int = 0, t_p_id: Int = 0, t_v_make: String = "", t_parts: List[Part]) extends Vehicle {
  override val v_id = t_v_id
  override val p_id = t_p_id
  override val v_make = t_v_make
  override var bill = 0
  var parts: List[Part] = t_parts


  def get_time(): Int = {
    var x: Int = 0
    for (p <- parts) {
      if (p.broken) {
        x += p.time
      }
    }
    x
  }

  def get_No_Broken(): Int = {
    var x: Int = 0
    for (p <- parts) {
      if (p.broken) {
        x += 1
      }
    }
    x
  }

  def get_£(): Double = {
    var x: Double = 0
    for (p <- parts) {
      if (p.broken) {
        x += p.£
      }
    }
    x
  }

  def get_Not_fixed(): String = {
    var t = ""
    for (p <- parts) {
      if (p.broken) {
        t += p
      }
    }
    t
  }

  def get_parts(): String = {
    var t = ""
    for (p <- parts) {
      t += p
    }
    t
  }

  def fix(name: String): Double = {
    var x: Double = 0
    for (p <- parts) {
      if (p.broken) {
        p.broken = false
        x = p.£
      }
    }
    x
  }

  override def fix_All(): Double = {
    var x = 0
    for (p <- parts) {
      if (p.broken) {
        p.broken = false
        x += p.£
      }
    }
    x
  }

  def get_v_id(): Int = {
    v_id
  }

  def get_p_id(): Int = {
    p_id
  }

  def get_v_make(): String = {
    v_make
  }

  def get_bill(): Int = {
    bill
  }

  def set_fixed(x: Boolean) = {
    fixed = x
  }


  override def toString = s"Car(v_id=$v_id, p_id=$p_id, v_make=$v_make, get_time=$get_time, get_No_Broken=$get_No_Broken, get_£=$get_£)"
}
