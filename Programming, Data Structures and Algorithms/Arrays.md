Arrays

- An array is a fixed collection of same-type data that are stored
  contiguously and that are accessible by an index. Any item in the
  array can be accessed efficiently(constant time), given that items
  index.

- It is the most fundamental data structure in that they have a direct
  correspondence with the underlying memory systems on virtually all
  computers.

- Arrays are defined as primitives in most programming languages and
  most computer-language processors translate programs that involve
  arrays into efficient machine-language programs that access memory
  directly.

- Arrays can be allocated statically or dynamically. Typically in large
  programs where many arrays are used, without dynamic memory
  allocation, arrays would have to be predeclared to be as large as
  required. This is undesirable as

  - It is difficult to predict the size.
  - Memory space is blocked and wasted until the time the array is
    populated in considerable amounts.

[Sieve of
Eratosthenes](Eclipse%20Java%20WorkSpace/Elementary%20Data%20Structures/Arrays/SieveOfEratosthenes.java)

- Is a program to mark all prime numbers until a given value. It
  demonstrates the advantages of using arrays as accessing
  non-consecutive elements in the array is required.

- Analysis

  $$T{{{(N)} = {N + \left\{ {{{{{\frac{N}{2} + \frac{N}{3}} + \frac{N}{5}} + \frac{N}{7}} + \frac{N}{11}} + \ldots} \right\}}} = O}{({N\log N})}$$

  Need to know about infinite series, divergent series, harmonic
  progression to simplify

References

- Sedgewick – 3<sup>rd</sup> Edition

Can do

- Implementation of sieve of Eratosthenes
