// A method with implicit parameters can be applied to arguments just like a normal method. In this case the implicit
// label has no effect. However, if such a method misses arguments for its implicit parameters, such arguments will be
// automatically provided.

// The actual arguments that are eligible to be passed to an implicit parameter fall into two categories:
// * First, eligible are all identifiers x that can be accessed at the point of the method call without a prefix and
// that denote an implicit definition or an implicit parameter. * Second, eligible are also all members of companion
// modules of the implicit parameter’s type that are labeled implicit.

// In the following example we define a method sum which computes the sum of a list of elements using the monoid’s
// add and unit operations. Please note that implicit values can not be top-level, they have to be members of a
// template.