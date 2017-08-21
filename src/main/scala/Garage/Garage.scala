package Garage

import scala.collection.mutable
import scala.collection.mutable.ListBuffer


class Garage {

  var open: Boolean = false

  var v_Next_ID: Int = 1
  var p_Next_ID: Int = 1
  var vehicle: ListBuffer[Vehicle] = new ListBuffer()
  var person: ListBuffer[Person] = new ListBuffer()
  var assigned: mutable.Map[Int, Int] = mutable.Map()
  var earnings: Double = 0
  var time_h = 9
  var time_m = 0

  def adding_Bike(p_id: Int, make: String, parts: List[Part]) = {
    var x: Bike = new Bike(v_Next_ID, p_id, make, parts)
    v_Next_ID += 1
    adding_vehicle(x)

  }

  def adding_Car(p_id: Int, make: String, parts: List[Part]) = {
    var x: Car = new Car(v_Next_ID, p_id, make, parts)
    v_Next_ID += 1
    adding_vehicle(x)

  }

  def adding_vehicle(x: Vehicle): Int = {
    vehicle += x
    x.get_v_id()
  }

  def get_all_vehicle(): String = {
    var x = ""
    for (v <- vehicle) {
      x += v.toString + "\n"
    }
    x
  }

  def adding_Customer(f: String, s: String) = {
    var x: Customer = new Customer(p_Next_ID, f, s)
    p_Next_ID += 1
    adding_Person(x)

  }

  def adding_Employee(f: String, s: String) = {
    var x: Employee = new Employee(p_Next_ID, f, s)
    p_Next_ID += 1
    adding_Person(x)

  }

  def adding_Person(x: Person): Int = {
    person += x
    x.get_p_id()
  }

  def get_all_Person(): String = {
    var x = ""
    for (p <- person) {
      x += p.toString + "\n"
    }
    x
  }

  def removing_vehicles(v_id: Int) = {
    vehicle.remove(vehicle.indexOf(get_vehicle_v_id(v_id)))
  }

  def removing_Person(p_id: Int) = {
    person.remove(person.indexOf(get_Person_p_id(p_id)))
  }


  def get_vehicle_v_id(v_id: Int): Vehicle = {
    var t: Vehicle = null
    for (v <- vehicle) {
      if (v_id == v.get_v_id()) {
        t = v
      }
    }
    t
  }

  def get_vehicle_p_id(p_id: Int): Vehicle = {
    var t: Vehicle = null
    for (v <- vehicle) {
      if (p_id == v.get_p_id()) {
        t = v
      }
    }
    t
  }

  def get_Person_p_id(p_id: Int): Person = {
    var t: Person = null
    for (p <- person) {
      if (p_id == p.get_p_id()) {
        t = p
      }
    }
    t
  }


  def t_open_Garage(): Boolean = {
    open = !open
    open
  }

  def get_open_Garage(): Boolean = {
    open
  }

  def get_assigned_by_ID(p_id: Int): Employee = {
    var e: Employee = null
    for (p <- person) {
      if (p.p_id == p_id) {
        e = is_Employee(p).getOrElse(null)
      }
    }
    e
  }


  def assign(p: Person): Option[Int] = p match {
    case p: Employee => {
      if (p.v_id == 0) {

        for (v <- vehicle) {

          var t = false
          for (f <- person) {
            if (is_Employee(f).getOrElse(null) != null) {
              if (is_Employee(f).getOrElse(null).v_id == v.v_id) t = true
            }
          }
          if (!t) {
            if (!assigned.contains(p.p_id)) {

              assigned += (p.p_id -> 0)
            }
            p.v_id = v.v_id
            Option(p.p_id)
          }
        }
        if (p.v_id == 0) {
          None
        } else Option(p.p_id)
      } else None
    }
    case _ => None
  }

  def assign_all(): Boolean = {
    var x: Boolean = false
    for (p <- person) {
      val y = assign(p)
      println(x + " " + y)
      if (y != None) x = true
    }
    x
  }

  def get_time(v_id: Int): Int = {
    get_vehicle_v_id(v_id).get_time()

  }

  def get_T_time(): Int = {
    var x = 0
    for (v <- vehicle) {
      x += v.get_time()
    }
    x
  }

  def calculat_bills(v_id: Int): Double = {
    get_vehicle_v_id(v_id).get_bill()
  }

  def fix_vehicles(v_id: Int): (Int, Double) = {
    var x = get_vehicle_v_id(v_id).fix_All()
    earnings + x._2
    x

  }

  def add_time(t: Int): (Int, Int) = {
    var temp_m = time_m + t
    var temp_h = time_h
    if (temp_m > 60) {
      temp_h = time_h + (temp_m / 60)
      temp_m = temp_m % 60
    }
    if (temp_h > 23) temp_h %= 24
    (temp_h, temp_m)
  }

  def get_v_ID_by_Person(p: Person): Option[Vehicle] = p match {
    case p: Employee => Option(get_vehicle_v_id(p.v_id))
    case _ => None
  }


  def is_Employee(person: Person): Option[Employee] = person match {
    case a: Employee => Option(a)
    case _ => None
  }

  def fix_All_assigned_vehicles(): String = {
    var str = ""

    for (id <- assigned.keys) {
      val p: Employee = is_Employee(get_Person_p_id(id)).getOrElse(null)

      var v = get_vehicle_v_id(p.v_id)


      if (v != null) {
        earnings += v.get_bill()
        val t = v.get_time()
        str += v + "\n start time :" + add_time(assigned.get(id).getOrElse(0))
        str += "\n end time :" + add_time(assigned.get(id).getOrElse(0) + v.get_time())
        str += "\n bill :" + v.fix_All()._2 + "\n"

        vehicle.remove(vehicle.indexOf(v))
        p.v_id = 0


        assigned -= id

        assigned += (id -> (assigned.get(id).getOrElse(0) + t))


      }
    }
    str
  }


  def fix_All_vehicles() {
    if (open) {
      var str = ""
      var x = assign_all()
      while (x == true) {

        str += fix_All_assigned_vehicles()
        x = assign_all()
      }
      var total_time: Int = 0
      for (a <- assigned) {
        if (a._2 > total_time) total_time = a._2
      }
      str = add_time(total_time) + " finish time\n" + str
      str = earnings + " earnings\n" + str
      println(str)
    }
  }

}
