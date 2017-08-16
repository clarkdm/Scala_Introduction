package Garage

import scala.collection.mutable.ListBuffer


class Garage {

  var open: Boolean = false

  var v_Next_ID: Int = 1
  var p_Next_ID: Int = 1
  var vehicle: ListBuffer[Vehicle] = new ListBuffer()
  var person: ListBuffer[Person] = new ListBuffer()
  var assigned: ListBuffer[Int] = new ListBuffer()

  def adding_Bike(p_id: Int, make: String) = {
    var x: Bike = new Bike(v_Next_ID, p_id, make)
    v_Next_ID += 1
    adding_vehicle(x)

  }

  def adding_Car(p_id: Int, make: String) = {
    var x: Car = new Car(v_Next_ID, p_id, make)
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

  def fix_vehicles(v_id: Int): Int = {
    get_vehicle_v_id(v_id).fix_All()
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

  def calculat_bills(v_id: Int): Int = {
    get_vehicle_v_id(v_id).get_bill()
  }

  def t_open_Garage(): Boolean = {
    open = !open
    open
  }

  def get_open_Garage(): Boolean = {
    open
  }

//  def fix_all(): Int = {
//
//
//  }

  def assign(p: Person):Int = p match {
    case p: Employee => {
      if (p.v_id == 0) {
        //var x = 0
        for(v<-vehicle){
          if(!assigned.contains(v.v_id)){
            p.v_id=v.v_id
            assigned += v.v_id
          }

        }


        9
      } else
      p.v_id
    }
    case p: Customer => 0
  }


}
