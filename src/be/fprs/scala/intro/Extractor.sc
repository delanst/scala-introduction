// An extractor in Scala is an object that has a method called unapply as one of its
// members. The purpose of that unapply method is to match a value and take it
// apart. Often, the extractor object also defines a dual method apply for building
// values, but this is not required.

object Twice {
  def apply(x: Int): Int = x * 2
  def unapply(z: Int): Option[Int] = if (z%2 == 0) Some(z/2) else None
}

object TwiceTest {
  val x = Twice(21)
  x match { case Twice(n) => println(n) }
}

val test = TwiceTest

