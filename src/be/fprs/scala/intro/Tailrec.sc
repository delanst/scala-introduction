// a tail call recursion is function that calls itself where the call is placed at the end of
// the function itself.
// Recursion has been an issue on the JVM forever due to the stack overflow. When a function calls
// itself this can created an infinite loop for which each function call creates a new stack.
// This causing the the stack overflow error.
// In scala we can safely implement a tail call recursion as the scala compiler flattens out
// the recursion meaning that the entire code is run in one stack.
// We can ensure the safety by annotating the function with @scala.annotation.tailrec

def factorial(n : Int) =  {

  @scala.annotation.tailrec
  def factorialImpl(n : Int , fact : BigInt) : BigInt = {
    if( n == 1)
      fact
    else
      factorialImpl(n-1,n*fact)
  }

  factorialImpl(n,BigInt(1))

}

println("factorial :: " + factorial(50000))