// Scala has a built-in general pattern matching mechanism. It allows to match on any sort
// of data with a first-match policy. Here is a small example which shows how to match
// against an integer value

// The block with the case statements defines a function which maps integers to strings. The
// match keyword provides a convenient way of applying a function (like the pattern matching
// function above) to an object.

sealed trait Tree

case class Sum(left : Tree , right : Tree) extends Tree
case class Var(n : String) extends Tree
case class Const(variable : Int) extends Tree

type Environment = String => Int

def eval(t: Tree , env : Environment) : Int = t match {
  case Sum(left,right) => eval(left,env) + eval(right,env)
  case Var(n) => env(n)
  case Const(variable) => variable
}

def derive(t: Tree , v : String) : Tree = t match {
  case Sum(left,right) => Sum(derive(left,v) , derive(right,v))
  case Var(variable) if( v == variable) => Const(1)
  case _ => Const(0)
}

val exp : Tree = Sum(Sum(Var("x"),Const(2)), Const(5))
val env : Environment = { case "x" => 5 case "y" => 7}

println(eval(exp,env))
println("Derivative relative to x:\n " + derive(exp, "x"))
