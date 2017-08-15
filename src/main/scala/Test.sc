

var tz = java.util.TimeZone.getAvailableIDs

//for (t<-tz.filter(tz.))) {
//  printf(t.split("/")(1)+" : ")
//}
println(timeZone(tz))
println(tz.size)
def timeZone(a: Array[String]):Array[String] = {


tz
}


var tz2 =  Array("Africa/Abidjan", "Africa/Accra")
var a = (tz2(1).split("/"))(1)



println(comp("edcf","ethylenediaminetetraacetate")+"hi")

def comp(string_1: String, string_2: String): Boolean = {
  var x = true
  var s = string_2
  for (a <- string_1) {
   // println(a)
   // println(string_2.contains(a))
    if (string_2.contains(a)) {
      s = s.replace(a, '1')

    }
  }
  println(s)
  for (a <- s) {
    if (a != '1') {
      x = false
    }

  }
  x
}