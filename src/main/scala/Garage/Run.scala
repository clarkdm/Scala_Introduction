package Garage


import scala.collection.mutable.ListBuffer

object Run extends App {

  var g: Garage = new Garage()

  var p = new ListBuffer[Part]
  p += new Part("wheels", 33, 10, true)
  p += new Part("brakes", 66, 30, false)
  p += new Part("batteries", 25, 5, true)
  p += new Part("steering", 120, 100, true)
  var p1 = new ListBuffer[Part]
  p1 += new Part("wheels", 33, 10, true)
  p1 += new Part("brakes", 66, 30, true)
  p1 += new Part("batteries", 25, 5, true)
  p1 += new Part("steering", 120, 100, true)
  var p2 = new ListBuffer[Part]
  p2 += new Part("wheels", 33, 10, false)
  p2 += new Part("brakes", 66, 30, true)
  p2 += new Part("batteries", 25, 5, true)
  p2 += new Part("steering", 120, 100, true)
  var p3 = new ListBuffer[Part]
  p3 += new Part("wheels", 33, 10, true)
  p3 += new Part("brakes", 66, 30, false)
  p3 += new Part("batteries", 25, 5, false)
  p3 += new Part("steering", 120, 100, true)


  g.adding_Bike(1, "hirfd", p.toList)
  g.adding_Car(2, "hifewd", p1.toList)
  g.adding_Car(4, "hiwd", p2.toList)
  g.adding_Car(5, "cefiwd", p3.toList)
//  println(g.get_all_vehicle())

  println(g.get_all_vehicle())

  g.adding_Customer("david", "clark")
  g.adding_Employee("tam", "grg")
  g.adding_Employee("bob", "clagrgerk")

//  println(g.get_all_Person())

  println(g.get_all_Person())
  g.open = true
  g.fix_All_vehicles()


}