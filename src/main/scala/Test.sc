






var str: StringBuilder = new StringBuilder("")
var i: Int = 0


for(x <- 0 to 15){
  add(x)
  println(str)
  println("\n\n"  )



}


println(str)



def add(x:Int): Unit = x match {
  case 0 => str.append("    |")
  case 1 => str.append("    |")
  case 2 => str.insert(0,"    __|___"+"\n" )
  case 3 => str.insert(0,"      |    "+"\n")
  case 4 => str.insert(0,"      |       "+"\n")
  case 5 => str.insert(0,"      |       "+"\n")
  case 7 => str.insert(0,"      |      "+"\n")
  case 8 => str.insert(0,"      _______"+"\n")
  case 9 =>  str.insert(26,'|' )
  case 10 => str.insert(41,"O")
  case 11 => str.insert(57,"|")
  case 12 => str.replace(56,57,"/")
  case 13 => str.insert(58,"\\")
  case 14 => str.insert(73,"/")
  case 15 => str.insert(74," \\")
  case _ =>
}

























//
//
//var tz = java.util.TimeZone.getAvailableIDs
//
////for (t<-tz.filter(tz.))) {
////  printf(t.split("/")(1)+" : ")
////}
//println(timeZone(tz))
//println(tz.size)
//def timeZone(a: Array[String]):Array[String] = {
//
//
//tz
//}
//
//
//var tz2 =  Array("Africa/Abidjan", "Africa/Accra","Africa")
//var a = tz2.foreach(f => f.split("/"))
//var a3 = tz2.foreach(f => f.split("/"))
//
//println(a)
//
////var a2 = (tz2.foreach(f => f.split("/"))).filter(_.length==1)
//
//





