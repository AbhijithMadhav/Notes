Controversy about multiple inheritance

- Multiple inheritance is supported in multiple programming languages
  like C++, python, Eiffel, Perl, Common Lisp, Tcl, Scala and others. So
  it can't be a completely useless feature

- The reason it is not supported in Java is spelt out by James Gosling

  - Rarely used
  - Mis-understood

- James gosling's observation does not mean that multiple inheritance is
  completely useless. After all there are many intuitive patterns that
  seem to need multiple inheritance.

- Multiple inheritance allows programmers to use more than one totally
  orthogonal hierarchy simultaneously, such as allowing *Cat* to inherit
  from *Cartoon character* and *Pet* and *Mammal* and access features
  from within all of those classes. Lack of multiple inheritance often
  results in a very awkwardly mixed hierarchy, or forces functionality
  to be rewritten in more than one place, with attendant maintenance
  problems – Wikipedia.

- It would be nice to come across a bad implementation of multiple
  inheritance to understand the “misunderstood” part of James gosling's
  assertion.

- It would also be nice to come across an awkward implementation, made
  awkward due to the fact that multiple inheritance wasn't used.

- “Any language feature needs to reduce coding time without
  significantly increasing bugs. Since encapsulation is quite powerful
  in any language, the value of MI isn't that high, however the number
  of bugs can be quite large when you consider any kind of interesting
  corner cases. I would agree that virtual inheritance is the culprit of
  bugs, but it is vastly more valuable than MI”

- “I would argue that language features aren't just about reducing
  coding time. They're also about increasing the expressiveness of a
  language, and increasing performance”

An object whose class implements multiple inheritance contains as
sub-objects, objects of all inherited classes together.

References

- <http://en.wikipedia.org/wiki/Multiple_inheritance>
- <http://www.cs.dartmouth.edu/~mckeeman/cs118/references/OriginalJavaWhitepaper.pdf>
- <http://stackoverflow.com/a/291585> – Read the comments
- <http://stackoverflow.com/questions/225929/what-is-the-exact-problem-with-multiple-inheritance>
- <http://stackoverflow.com/a/364969>
- <http://stackoverflow.com/questions/406081/why-should-i-avoid-multiple-inheritance-in-c>
- <http://stackoverflow.com/questions/2843755/why-is-multiple-inheritance-not-supported-in-most-of-programming-language?lq=1>
- <http://stackoverflow.com/questions/191691/should-c-sharp-have-multiple-inheritance>
- <http://blog.jetbrains.com/kotlin/2011/08/multiple-inheritance-part-1-problems-with-the-existing-design/>
- <http://www.gotw.ca/publications/mill06.htm>
