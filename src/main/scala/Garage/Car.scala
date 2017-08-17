package Garage

class Car(t_v_id: Int = 0, t_p_id: Int = 0, t_v_make: String = "", t_parts: List[Part]) extends Vehicle {
  override val v_id = t_v_id
  override val p_id = t_p_id
  override val v_make = t_v_make

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

  def get_bill(): Double = {
    var x: Double = 0
    for (p <- parts) {
      if (p.broken) {
        x += p.bill
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
        x = p.bill
      }
    }
    x
  }

  override def fix_All(): (Int,Double) = {
    var x:Double = 0
    var z = 0
    for (p <- parts) {
      if (p.broken) {
        p.broken = false
        x += p.bill
        z+= p.time
      }
    }
    (z,x)
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


  override def toString = s"Car(v_id=$v_id, p_id=$p_id, v_make=$v_make, parts=$parts)"
}
