Collision resolution with open addressing

[Linear
probin](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Symbol%20Tables/src/LinearProbingHashST.java)[g
implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Symbol%20Tables/src/LinearProbingHashST.java)

Open addressing

- All elements occupy the hash table itself.
- This avoids pointers completely unlike chaining.
- Searching involves examining a sequence of slots which are computed by
  the hash function.
- The extra memory freed by not storing the pointers provides the hash
  table with a larger number of slots for the same amount of memory,
  potentially yielding fewer collisions and faster retrievals.

Operations

- Insertion

  - Inserting involves successively examining or probing the hash table
    unitl we find the suitable an empty slot in which to put the key.

  - The hash function for an open address implementation is defined as
    mapping of a key and the probe number to a permutation
    of$$\langle{0,1,\ldots,{m - 1}}\rangle$$,

    i.e.,
    $$h:{U \times \{}0,1,\ldots,m–1\}\rightarrow{\langle{0,1,...,{m - 1}}\rangle}$$.

  - For every key k, the probe
    sequence$$\langle{h{({k,0})},h{({k,1})},\ldots,h{({k,m–1})}}\rangle$$be
    a permutation of $$\langle{0,1,\ldots,{m - 1}}\rangle$$ so that
    every slot is eventually considered as a slot for a new key as the
    table fills up.

  - INSERT(T, x)

1.  i = 0
2.  while ( i != m )
3.   j = h(k, I)
4.   if T\[j\] == null
5.   T\[j\] = x
6.   return j
7.   i++

- Se
- 
- 

<!-- -->

- Probing techniques

  - Linear probing - Clustering can lead to bad performance in hash
    tables with linear probing.
  - Quadratic probing
  - Double hashing

Operations

- Insertion – Insert into the next available position on collision.
- Search – Search by going to the next position until a the required key
  is got(hit) or a null is encountered(miss)
- Delete – Similar to search. After the required key is deleted, all
  keys in the cluster to the right of the deleted key must be reinserted
  so as to avoid a search for a key which hashes to the same value as
  the deleted key reporting a miss due to encountering the null left
  behind by deleting the key. Thus deletes can be costly. This hashing
  method is especially used in the construction of compiler symbol
  tables as the compiler does only inserts.

Load factor

- Here M \> N. Thus N/M is interpreted as the load factor, determining
  the occupancy of the hash table. This load factor cannot be greater
  than 1 as that would lead to a search miss going into an infinite
  loop. Array resizing is required used to avoid this

Analysis

- The amortized analysis including the effects of resizing for a search,
  insert, delete or any combination of then is still proportional to the
  **number of operations**(i.e constant per operation and not dependent
  on the number of keys)

Properties

- In a linear-probing hash table with M lists and load factor of N/M =
  1/2, the average number of probes required for a search hit is ½ and
  for a search miss is 3/2. We thus use array resizing to keep the load
  factor below a maximum of ½
