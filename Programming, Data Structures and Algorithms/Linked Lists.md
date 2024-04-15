Linked Lists

- A linked list is a data structure consisting of a group of nodes which
  link to one another in a chain-like fashion to represent a sequence of
  data items.
- Linked lists, unlike arrays are typically not directly supported by
  programming language constructs but have to be constructed
  programmatically.

Singly linked list

- Nodes contain links only to the next node. Traversal is possible only
  in one direction

- A singly linked list is also a recursive data structure as it can be
  seen as containing a link to a smaller version of itself. As a result
  many operations like

  - Merging two lists
  - [Enumerating in reverse
    order](Eclipse%20C++%20Workspace/ReverseListRecursive/ReveresListRecursive.cpp)

  have very simple recursive algorithms.

- Implementations(Trivial ones. No need to go through them)

  - [Move largest item of a linked list to its last
    node](Eclipse%20C++%20Workspace/3.33%20-%20Largest%20last/largestLast.cpp)
  - [Move smallest item of a linked list to its first
    node](../../.local/share/Trash/files/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/3.34/smallestFirst.cpp)
  - [Put nodes in an even position of a linked list after the nodes in
    the odd
    position](../../.local/share/Trash/files/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/3.35/rearrange.cpp)
  - [Exchange positions of two given nodes of a linked
    list](../../.local/share/Trash/files/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/3.36/swap.cpp)
  - [Make a copy of a linked
    list](../../.local/share/Trash/files/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/3.37/copyList.cpp)
  - [Remove nodes in a linked list for which a given function returns a
    non-zero
    value](../../.local/share/Trash/files/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/3.38/conditionalDelete.cpp)
  - [Create a new list with
    ](../../.local/share/Trash/files/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/3.39/conditionalDeleteCreate.cpp)[nodes
    in a
    ](../../.local/share/Trash/files/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/3.39/conditionalDeleteCreate.cpp)[given
    ](../../.local/share/Trash/files/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/3.39/conditionalDeleteCreate.cpp)[linked
    list for which a given function returns a non-zero
    value](../../.local/share/Trash/files/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/3.39/conditionalDeleteCreate.cpp)
  - [Insertion sort on a linked list without a header
    node](../../.local/share/Trash/files/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/3.41/insertionSort.cpp)

Doubly linked list

- Doubly linked list is a list with each node containing pointers to the
  next and the previous nodes. As a result doubly linked lists need more
  space per node than the singly linked counterparts and their
  elementary operations are more costly requiring changing of more
  links.

- Though this is so the operations are simpler and potentially more
  efficient because there is no need to traverse the list to find the
  previous node, so that its link can be modified

  - For removal of a given node
  - For insertion/removal before a given node

  Also the last link of the list need not be maintained. It is readily
  available through the first nodes previous link. This helps traversal
  to the end when the last node needs to be removed.

- Two links for each node allow traversal in both directions.

- Implementations(Trivial)

  - [Exchange positions of two given nodes of a
    ](../../.local/share/Trash/files/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/3.43/swap.cpp)[doubly
    ](../../.local/share/Trash/files/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/3.43/swap.cpp)[linked
    list](../../.local/share/Trash/files/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/3.43/swap.cpp)

Circular linked list

- In a circular linked list the link in the last node points to the
  first.
- In this case there is no need to maintain pointers to the first and
  last node. The pointer to the first node can always be obtained in the
  link of the last node.
- Circular list can be singly or doubly linked.
- Circular lists can be traversed completely from any node of the list.
- A circular linked list is often used as a buffer where one portion of
  the program produces data and another consumes it, such as in
  communications.

<!-- -->

- Implementations

  - [Number of nodes on a circular
    list](../../.local/share/Trash/files/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/3.23/count.cpp)

  - [Number of nodes that are between the nodes referenced by two given
    pointers on a circular
    list](../../.local/share/Trash/files/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/3.24/count.cpp)

  - [Inserting a circular list at a specified position in another
    circular
    list](../../.local/share/Trash/files/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/3.25/merge.cpp)

  - Josephus problem

    - [Using a circular list with a header](src/3.42-josephus.cpp)
    - [Optimized](src/3.27.cpp)
    - [Running
      time](../../.local/share/Trash/files/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/3.28/3.28.cpp)

[](../../.local/share/Trash/files/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/3.33/largestLast.cpp)

Sentinel or dummy nodes

- A **sentinel or dummy node** is a specifically designated node used
  with linked lists and does not hold or reference any data managed by
  the data structure.

- Specifically, when a list becomes empty, the following operations
  involve a different kind of processing than in the general case

  - Insertion/removal at end
  - Removal of a given node

  because there is no predecessor node. Use of a head node generalizes
  operations even when the list is empty. The advantage of this is

  - Increased speed of operations due to reduced algorithmic complexity
    and code size
  - Increased data structure robustness (arguably)

- Implementation(Trivial)

  - [List reversal for a linked list with a header
    node](../../.local/share/Trash/files/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/3.40/reverse.cpp)

Comparison of efficiency of operations

<table>
<tbody>
<tr class="odd">
<td></td>
<td><a
href="Eclipse%20Java%20WorkSpace/Elementary%20Data%20Structures/Linked%20List/SinglyLinkedLinearList.java">Singly
linked </a><a
href="Eclipse%20Java%20WorkSpace/Elementary%20Data%20Structures/Linked%20List/SinglyLinkedLinearList.java">linear
</a><a
href="Eclipse%20Java%20WorkSpace/Elementary%20Data%20Structures/Linked%20List/SinglyLinkedLinearList.java">list</a></td>
<td><a
href="Eclipse%20Java%20WorkSpace/Elementary%20Data%20Structures/Linked%20List/DummyHeadedDoublyLinkedCircularList.java">Dummy
headed d</a><a
href="Eclipse%20Java%20WorkSpace/Elementary%20Data%20Structures/Linked%20List/DummyHeadedDoublyLinkedCircularList.java">oubly
linked </a><a
href="Eclipse%20Java%20WorkSpace/Elementary%20Data%20Structures/Linked%20List/DummyHeadedDoublyLinkedCircularList.java">circular
</a><a
href="Eclipse%20Java%20WorkSpace/Elementary%20Data%20Structures/Linked%20List/DummyHeadedDoublyLinkedCircularList.java">list</a></td>
</tr>
<tr class="even">
<td>Insertion at the beginning</td>
<td>O(1)</td>
<td>O(1)</td>
</tr>
<tr class="odd">
<td>Removal at the beginning</td>
<td>O(1)</td>
<td>O(1)</td>
</tr>
<tr class="even">
<td>Insertion at the end</td>
<td><p>O(1) if the last node is kept track off. </p>
<p>Keeping track of last node forces extra checks even if a dummy headed
list is used though.</p></td>
<td>O(1)</td>
</tr>
<tr class="odd">
<td>Removal at the end</td>
<td>O(n) for removal as the list must be traversed to get to the
predecessor node.</td>
<td>O(1)</td>
</tr>
<tr class="even">
<td>Insertion/Removal after a given node</td>
<td>O(1)</td>
<td>O(1)</td>
</tr>
<tr class="odd">
<td>Insertion/Removal before a given node</td>
<td>O(n) for traversing up to the predecessor node.</td>
<td>O(1)</td>
</tr>
<tr class="even">
<td>Removal of a particular given node</td>
<td>O(n) for traversing up to the predecessor node.</td>
<td>O(1)</td>
</tr>
</tbody>
</table>

Comparison with arrays

- Linked lists represent a sequence of items just like arrays. The
  advantage that linked lists hold over arrays is that insertion and
  deletion of items anywhere in the sequence is a constant time
  operation. The corresponding operations are unnatural and inconvenient
  in arrays because they require moving all of the arrays contents
  following the affected item.
- Arbitrarily number of items can be inserted into a linked list,
  limited only by the physical memory. In the case of an array the same
  would require resizing and re-allocation(the cost of which is an
  amortized O(1)), which is not possible if the memory is fragmented.
- The advantage of efficient insertion and deletion is gained at the
  expense of quick access to any arbitrary element in the sequence,
  because the only way to get to an item in the list is to follow links
  from the beginning. This sequential access provided by the linked list
  does not lend itself to the implementation of an indexed ADT like how
  the array does. Also, the sequential access on arrays is faster than
  on linked lists due to locality of reference.
- Linked lists need extra storage space to store links which makes it
  impractical for list of small data items like boolean values or
  characters.
- The Josephus problem demonstrates the pro's and cons of of both the
  linked list and array implementations. While it is efficient to find
  the next person(getting the n'th count) if implemented as an array, it
  is inefficient to remove him from the array and it is the vice-verse
  if implemented as a linked list.

**Why do we care about resizing arrays when we have linked lists?**  
Some ADT implementations like

- Symbol table implemented using ordered arrays(binary search)
- Hash tables

require indexed access to their elements which is efficiently provided
only by arrays.

Memory allocation for lists(Exclude from studies)

- Implementations

  - [Free all nodes of a given linked
    list](../../.local/share/Trash/files/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/3.46/freeAll.cpp)
  - [Free nodes of a given linked list that are in positions that are
    divisible by
    5](../../.local/share/Trash/files/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/3.47/freeEvery5th.cpp)
  - [Free nodes of a given linked list that are in even
    positions](../../.local/share/Trash/files/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/3.48/freeEvery2nd.cpp)
  - [Comparison between list processing routines which do and do not
    manage memeory
    explicitly](../../.local/share/Trash/files/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/3.50/3.50.sh)

References

- Algorithms – 4<sup>th</sup> Edition – Sedgewick, Wayne
- Algorithms in C++ - 3<sup>rd</sup> Edition – Sedgewick
- [Wikipedia](http://en.wikipedia.org/wiki/Linked_list)
