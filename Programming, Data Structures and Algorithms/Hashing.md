Hash tables

Hashing is a classic time-space trade-off

If there were no memory limitation, then we could do any search with
only one memory access by simply using the key as an index in a
potentially huge array. The array would be as large as to accommodate
all possible key values. - [Direct Address
](../../../Academic/Programming,%20Data%20Structures%20and%20Algorithms/Notes/Direct%20addressing%20table.md)[Tables](../../../Academic/Programming,%20Data%20Structures%20and%20Algorithms/Notes/Direct%20addressing%20table.md)

If there were no time limitation, then we could do a sequential search
in a single unordered array only as big as the number of keys.

Motivation for hashing based symbol tables

- Downside of direct address tables is that they have very large memory
  requirements when the universe of keys is large which is typically the
  case with most applications. Also most of this memory is wasted as not
  all keys in the universe are represented in the dynamic set of an
  application.
- The hashing approach while maintaining the same performance guarantees
  of the direct addressing table brings down the memory requirement to
  $$\Theta{({\mid K \mid})}$$where K is the set of keys actually stored
  in the table.
- The caveat here is that the performance guarantees is an average time
  guarantee versus the worst time guarantee that the direct addressing
  table gives.

Stages in search algorithms that use hashing

- **Computing the hash of a key using a **[**hash
  function**](Hash%20Functions.md)

  - With direct addressing a key k is stored in slot k. In hashing, a
    key k is stored in h(k). h : U → { 0, 1, …, m} is the hashing
    function which transforms the key in the index of the slot. Here m
    is the size of the hash table instead of$$\mid U \mid$$.

- **Collision-resolution process**

  - The catch here as$$m \ll {\mid U \mid}$$, many keys may has hash to
    the same slot of the hash table. This phenomenon is called
    collision.

  - Though a well designed hash function can reduce collisions,
    collision-resolution has to be done.

  - There are two main methods used

    - [Chaining](Collision%20resolution%20with%20chaining.md)
    - [Open
      addressing](Collision%20resolution%20with%20open%20addressing.md)

Closed vs open

- The use of "closed" vs. "open" reflects whether or not we are locked
  in to using a certain position or data structure (this is an extremely
  vague description, but hopefully the rest helps).
- For instance, the "open" in "open addressing" tells us the index (aka.
  address) at which on object is stored in the hash table is not
  completely determined by its hash code. Instead, the index may vary
  depending on what's already in the hash table.
- The "closed" in "closed hashing" refers to the fact that we never
  leave the hash table; every object is stored directly at an index in
  the hash table's internal array. Note that this is only possible by
  using some sort of open addressing strategy. This explains why "closed
  hashing" and "open addressing" are synonyms.
- Contrast this with open hashing - in this strategy, none of the
  objects are actually stored in the hash table's array; instead once an
  object is hashed, it is stored in a list which is separate from the
  hash table's internal array. "open" refers to the freedom we get by
  leaving the hash table, and using a separate list. By the way,
  "separate list" hints at why open hashing is also known as "separate
  chaining".
- In short, "closed" always refers to some sort of strict guarantee,
  like when we guarantee that objects are always stored directly within
  the hash table (closed hashing). Then, the opposite of "closed" is
  "open", so if you don't have such guarantees, the strategy is
  considered "open".

Disadvantages of hashing

- No order in the keys
- Hashing function may be costlier than comparisons
