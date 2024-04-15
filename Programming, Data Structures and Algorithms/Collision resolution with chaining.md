Collision resolution with chaining

[Implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Symbol%20Tables/src/SeparateChainingHashST.java)

Operations

- INSERT(T, x)

  - Insert keys that collide into a list associated with the index.
  - Keys are inserted into the start of the list and this is thus a O(1)
    operation.

- SEARCH(T, k)

  - Index to a list and do a sequential search with the associated list
    for a key.
  - A O(L) operation where L is the length of the list. This would occur
    for an unsuccessful search and this would also be an upper bound for
    a successful search(Hence a big O instead of a$$\Theta$$).

- DELETE(T, x)

  - Index to the list and do a delete in the sequential search symbol
    table
  - As long as the list is a doubly linked list this is a O(1)
    operation.
  - If DELETE(T, k) is implemented it would be a O(L) operation.

Load factor

- The average number of elements stored in a chain.
- $$\alpha = {n/m}$$, where n =$$\mid K \mid$$= number of keys and m =
  number of slots in the table.
- Load factor in case of chaining can be less than, equal to or greater
  than one.

Analysis

- In the worst case all n keys can be hashed to the same slot( A
  pathological data set) and the running time for an unsuccessful search
  operation would be an unacceptable$$\Theta{(n)}$$ as L = n.
- However an average-case bound of O(1) can be guaranteed.
- When the hashing function, h, is chosen **randomly** from a [universal
  collection of hash functions](Universal%20Hashing.md) the expected
  length of the list that a key k hashes to,
  $$E{\lbrack n_{h{(k)}}\rbrack}$$, is equal the load factor
  $$\alpha = {n/m}$$. Thus as long as the load factor is monitored to be
  a constant factor, i.e., n = O(m), the average running time would be a
  O(1) – **Notes 21**
- The load factor can be monitored to be a constant factor by using a
  dynamic array. The total [amortized
  ](Amortized%20analysis%20of%20the%20resizing%20operations%20on%20a%20dynamic%20table.md)[cost](Amortized%20analysis%20of%20the%20resizing%20operations%20on%20a%20dynamic%20table.md)
  including the effects of resizing for a insert and delete is still
  proportional to the **number of operations**(i.e constant per
  operation).

Properties

- A closed-addressing hashing method.
- A open hashing method.
- Hashing with separate chaining using an array of size M speeds up
  search and insert by a factor of M
- In this implementation the goal is to choose a table size of M to be
  sufficiently small so that large swaths of contiguous memory is not
  wasted with empty indexes. It must also be sufficiently large so that
  searches do not have to traverse long chains
- However the above decision is not very crucial: if more keys arrive
  than expected, then searches will take a little longer than if we had
  chosen a bigger table size ahead of time; if fewer keys are in the
  table, then we have extra-fast search with some wasted space.
- Array resizing may be used to keep the average chain length small. It
  is however optional only in the case where a initial good assumption
  of N cannot be made.
