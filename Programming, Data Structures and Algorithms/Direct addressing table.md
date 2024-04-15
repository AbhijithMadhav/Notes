Direct Address Table

Why?

- Provides a O(1) ordered symbol table operations.

Array of pointers implementation(CLRS – Fig 11.1 – page 254)

- It is an array, T\[\], whose each slot corresponds to a key in the
  universe, U. Accessing the pointer in that slot gives the required
  key-data pair. If the dynamic set being represented does not have an
  element corresponding to a particular key value then a NULL is stored
  in that slot.
- Can be used only when the universe of keys is small. Else the size of
  the array, T, will be unreasonable.

Saving space – Avoid storing keys redundantly

Every slot is indexed by the key. Thus storing the key as a part of the
key-data pair is redundant and only the corresponding satellite data can
be stored.

Saving space - Bit vectors – Avoid storing pointers

- To save space of storing pointers with every key in the universe, the
  satellite data can be stored directly in the array. But then the
  problem of distinguishing an empty slot from a non empty one would
  arise.
- This can be solved by using a **parallel** auxiliary array called the
  bit vector. The entries of the bit vector are a 0 or a 1 indicating
  the whether the corresponding slot is empty or not.
- The bit vector is as large as T but every entry of the bit vector is
  single bit. Pointers need many times more than 1-bit of storage space.

Saving space - Validating cycles – Avoid storing pointers(Figure 20)

- Can avoid initializing the bit vector initially to all 0's by
  establishing a validating cycle.

- This involves using auxiliary array's V and D.

- Every slot of T contains an index of D at which the corresponding
  satellite data can be found, i.e., D\[T\[key\]\] = key.data

- V is called the validator. It is a **dynamically resizing array** and
  contains an attribute V.top which gives the index of the last valid
  entry, i.e., V\[1 … V.top\] contains only that many entries
  corresponding to the number of keys stored. The value of each slot of
  V\[1 … V.top\] is an index of T whose value is the index to this slot
  of V. This is called a validating cycle and establishes that T\[key\]
  corresponds to a valid index of D, i.e., if T\[key\] = i and V\[i\] =
  key then 'key' is a valid key and D\[T\[key\]\] exists.

- D is the array which holds the actual data. It is an array parallel to
  V and D\[1 … V.top\] contains only that many entries corresponding to
  the number of keys stored.

- Operations

  - SEARCH(T, key)

    - Check if the validating cycle holds for 'key' and if it does get
      D\[T\[key\]\].

  - INSERT(T, x) – x is a pointer a key-data pair

1.  1.  1.  top++
        2.  V\[V.top\] = x.key
        3.  V\[V.top\] = x.data
        4.  T\[x.key\] = V.top

- - Delete(T, key)

    Just breaking the validating the cycle would leave a hole in S and
    S'. So the last entries are copied to the deleted position.

1.  1.  1.  V\[T\[key\]\] = V\[V.top\]
        2.  D\[T\[key\]\] = D\[V.top\]
        3.  top--
