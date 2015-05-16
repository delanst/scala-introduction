// lazy evaluation also called normal order only executes a function a the moment the result
// is actually required. As means of demonstration the first example demonstrates the  no lazy
// evaluation called applicative order.

// ATTENTION for some reason the lazy evaluation does not work in the IDE. Execute this
// worksheet in the REPL.
// You may NOT see Add executed after the println("lazy evaluation or also normal order.")

def evaluate(input : Int) : Int = input

def add(a: Int , b : Int) = {
  println("Add executed")
  a+b
}

// here the execution of the function is first the add function end then the evaluate function
// with the result of add as parameter. APPLICATIVE ORDER
// All functions are always executed.
println("applicative order :: " + evaluate(add(2,3)))


println("lazy evaluation or also normal order.")

lazy val result = add(2,3)

// due that the first check is false the second (result==5) should not be executed. But
// we have already called the add function in the line above. By the keyword lazy
// the add function will only be executed when we actually need it. This means
// it will only be called when result==5 is executed. So we may not see "Add executed"
// in this example.

if(false && result==5) {
  println("input larger then 10 result equals to 5")
} else {
  println("false")
}