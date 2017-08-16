package Garage

object Run extends App {

  var g:Garage  = new Garage()


  g.adding_Bike(1,"hirfd")
  g.adding_Car(2,"hifewd")
  g.adding_Bike(4,"hiwd")
  println(g.get_all_vehicle())
  g.removing_vehicles(2)
  println(g.get_all_vehicle())

  g.adding_Customer("david","clark")
  g.adding_Customer("tam","grg")
  g.adding_Employee("bob","clagrgerk")

  println(g.get_all_Person())
  g.removing_Person(3)
  println(g.get_all_Person())



}