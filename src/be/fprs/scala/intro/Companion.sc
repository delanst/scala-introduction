import be.fprs.scala.intro.Blog

// A companion object is an object with the same name as a class or trait and is defined in
// the same source file as the associated file or trait. A companion object differs from
// other objects as it has access rights to the class/trait that other objects do not. I
// n particular it can access methods and fields that are private in the class/trait.

// see  Blog.scala for the definition of the Blog class and companion object.
// The use of a companion object can not be declared in a worksheet as the use
// of it attached to the file name.


// you are now not reguired to use the word new for instantiating a Blog
// The use is reduced to the functionality in the object class only
// By definition this corresponds to the singleton pattern.
Blog.showInfo(Blog("This is an instance passed to the companion object."))

