// Methods may define multiple parameter lists. When a method is called with a fewer number
// of parameter lists, then this will yield a function taking the missing parameter
// lists as its arguments.

def filter(xs : List[Int], p : Int => Boolean) : List[Int] = {
  if(xs.isEmpty) xs
  else
  if(p(xs.head))
    xs.head :: filter(xs.tail,p)
  else
    filter(xs.tail,p)
}

def modN(n : Int)(x : Int) : Boolean = ((x%n) == 0)

val nums = List(1,2,3,4,5,6,7,8)

// notice that second parameter is not passed in the ModN function. This is because the
// second is automatically provided by the in scope value of the nums list.

println( filter(nums,modN(2)) )
println( filter(nums,modN(3)) )

// complete use of the modN function
println("complete function :: no mod value :: " + modN(3)(2))
println("complete function :: mod value :: " + modN(3)(6))

// see here a special case where we provide the _ (=wildcard,value we don't care,any value)
// in this case the function can not work since it can use a wide variation of Int
// values. Then the function on itself is returned.
println(modN(3)_)