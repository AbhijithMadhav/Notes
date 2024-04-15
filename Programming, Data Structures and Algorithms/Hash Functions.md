Hashing functions

Requirements of a hash function

- If we have an array that can hold M key-value pairs, then we need a
  hash function that can transform any given key into an index into that
  array: an integer in the range \[0, M – 1\]
- Should be easy to compute
- Should be consistent, i.e., if two keys are equal their hash values
  must also be equal.
- Should distribute keys **uniformly**: For each key, every integer
  between 0 and M – 1 should be equally likely(independently for each
  key).
- The above is possible only if all the bits of the key are involved in
  the calculation of its hash. This also means that any change to a key,
  even a small one, will change the hash in an apparently random way

Hash functions

- Modular hashing

<!-- -->

- - hash = key % M, M is the size of the symbol table
  - M should be picked such that all bits of 'key' play a role in the
    generation of hash. This is possible to some extent by choosing M to
    be a prime number.
  - Modular hashing can be used not only with positive integers but with
    all types of keys by considering the underlying binary
    representation of the keys and applying modular hashing on them

- Mid-square hashing

  - hash = The mid *r* digits of the square of the key, r is the width
    of the index of the hash table
  - A good hash function to use with integer key values. The mid-square
    method squares the key value, and then takes out the middle *r* bits
    of the result, giving a value in the range 0 to 2<sup>r</sup>-1.
    This works well because most or all bits of the key value contribute
    to the result.

- **Folding hashing**

  - ****B****reak key up into binary segments (ASCII)****
  - ****XOR these together****
  - ****Calculate the numeric integer equivalent****

Pitfalls

- A bad hash function can be a performance bug if

  - If it does not uniformly distribute keys
  - If it is not efficient

- 

- 
