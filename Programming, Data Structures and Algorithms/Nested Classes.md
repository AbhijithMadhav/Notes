Nested Class

- A class defined inside another class is called a nested class.
- A nested class is a member of its enclosing class. It is the third
  type of member of a class apart from the data members and the methods.
- As nested classes are members of the outer class they can be declared
  private, protected, public or package specific.

Why use nested classes??

- Logical way of grouping classes that are used in only one place. Is
  this one place the outer class?? If so isn't declaring nested class
  anything other than 'private' a waste??
- They can lead to more maintainable and readable code
- Encapsulation

Categories

- Static nested classes

<!-- -->

- Non-static nested classes

  - Inner classes
  - Local classes
  - Anonymous classes

Static nested classes

- Prefixed with the 'static' keyword which is intended to mean that this
  inner class is not associated with any instance of the outer class.
- Like static methods, a static nested class cannot refer directly to
  the instance variables(data members) and instance methods(member
  functions) of its outer class – It can only access them through object
  references. This is because static nested classes are not a part of an
  object instance of the outer class just like static methods and hence
  a reference to an instance variable would be meaningless.
- Static nested classes are used to mainly group classes that are used
  in only one place and whose member functions do not need access to the
  enclosing class' members(data and methods).
- An important note is that though static nested classes are not a part
  of an object instance of the outer class, they are separately
  instantiable. They are static in the sense of being a part/member of
  the outer class only.
- Static nested classes are accessed using the name of the outer class.

Inner classes

- Like instance variables and member of the enclosing class the inner
  class is associated with an instance of the enclosing class.
- As the inner class is associated with an instance of the enclosing
  class, it cannot contain static members. Why?? What would happen to
  let a static member be?? Wouldn't it just be not associated with any
  instance like in a normal static member??
- To separately instantiate an inner class, an object of the enclosing
  class has to be created and then the inner class can be instantiated.
- Inner classes are used mainly as helper classes which need to access
  the member of the enclosing class.
- Since inner classes belong to the enclosing class, the modifiers,
  private, protected, public and default, can be used to restrict access
  to instances of the inner classes.

Local classes

- Local classes are inner classes that can be declared/defined in a
  block. They are most typically defined in the body of a function.
- Ordinarily, local classes have access to the instance members of its
  enclosing class.
- Local classes themselves aren't static but their enclosing block can
  be static(typically a static method). When this is the case the local
  classes can only access static members of the enclosing class as their
  enclosing block is not associated with any instance of its class.
- Local classes can only access those local variables of its enclosing
  block which are final. This is done as changes to local variables of
  the enclosing block are meaningless and erroneous.
- Interfaces are inherently static and they thus cannot be defined like
  local classes in non-static blocks.
- Local classes cannot posses static members unless the static members
  are declared constant. Why is this so???

Anonymous classes

- Anonymous classes are like local classes except that they do not have
  a name. Use they if you need to use a local class only once.
- Anonymous classes help make code more concise.
