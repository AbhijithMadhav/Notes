Sequential-Search Symbol Table –
[I](Eclipse%20Java%20WorkSpace/Symbol%20Tables/src/SequentialSearchST.java)[mplementation](Eclipse%20Java%20WorkSpace/Symbol%20Tables/src/SequentialSearchST.java)

- Implemented as an **unordered linked list**.
- Search is done by sequentially scanning the list and has a worst case
  complexity of O(N) for a table with N elements.
- Insertion is not simply inserting the key into the list in the first
  or last position. A scan of the list must first be made to ensure that
  the a duplicate does not exist. Thus insertion also has a worst case
  complexity of O(N) for a table with N elements.

Why is an array not used instead of a linked list in a sequential search
implementation?

The delete operation would be inefficient as it would require a lot of
data movement.

Why isn't the sequential-search symbol table implemented as an ordered
list?

Implementation as an ordered list would result in the insertion
operation resulting in movement of data. Also it wouldn't improve the
efficiency of the either the search operation or the delete operation.
