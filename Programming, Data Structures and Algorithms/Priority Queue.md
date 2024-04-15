Priority queues

Priority Queue  
An abstract data-type which supports two operations

- Insert a key
- Remove the maximum/minimum key

Need for priority queues

Certain group of applications which always need to process the
greatest/smallest element

- Simulation systems where keys correspond to event times, to be
  processed in chronological order(Min priority Queue)
- Job scheduling, where the keys correspond to priorities indicating
  which task are to be performed first(Max priority queue)
- Numerical computations, where the keys represent computational errors,
  indication which order we should deal with them(Min priority queue)
- In implementing minimum spanning tree algorithms and shortest path
  first algorithms

Why can't the above applications use a sort algorithm to sort their data
before-handed so that they can always process the greatest element?

The dataset of the typical process-the-greatest-element type algorithm
is dynamic with new elements coming in. Sorting the whole dataset every
time a new element comes in can be done with a worst case complexity of
N compares. A PQ on the other hand guarantees a worst case complexity of
lg(N) compares when implemented using a heap. Refer to the next table

Performance and implementation alternatives for Priority queue

|                                                       |                 |         |
|-------------------------------------------------------|-----------------|---------|
| Underlying data structure                             | Time complexity |         |
| Insert                                                | Delete max      |         |
| Ordered array or linked list                          | O(N)            | O(1)    |
|  Unordered array or linked list                       | 1               | O(N)    |
| [B](Binary%20Heap.md)[inary heap](Binary%20Heap.md) | O(lg N)         | O(lg N) |

Costs of finding the largest M in a stream of N elements(M is pretty
much smaller than N)

<table>
<tbody>
<tr class="odd">
<td>Client</td>
<td>Order of growth</td>
<td></td>
<td></td>
</tr>
<tr class="even">
<td>Time</td>
<td>Space</td>
<td></td>
<td></td>
</tr>
<tr class="odd">
<td>Sort client</td>
<td>N lg(N)</td>
<td>N</td>
<td></td>
</tr>
<tr class="even">
<td><p>PQ client</p>
<p>(Keeps only the top M elements after insertion of the M+1
element)</p></td>
<td>Elementary implementation</td>
<td>M + M + … N times = NM</td>
<td>M</td>
</tr>
<tr class="odd">
<td>Heap-based implementation</td>
<td>lg M + lg M + … N times = N lg(M)</td>
<td>M</td>
<td></td>
</tr>
</tbody>
</table>

Implementation of PQ operations using sink and swim when PQ is
implemented as a complete-binary-heap

- Insert – O(lg N)

  - Add key at the end of the tree and swim it up so that the order of
    the binary heap is not violated.
  - This requires no more than 1 + lg N compares

- Remove the maximum – O(lg N)

  - Remove the first node
  - Put the item from the end of the heap at the top.
  - Make it sink.
  - This requires no more than 2 lg N compares

How to design a data type which implements all the below operations in
logarithmic time

- Insert in logarithmic time
- Remove the maximum in logarithmic time
- Remove the minimum in logarithmic time
- Find the max in constant time
- Find the min in constant time

Use both, a min-PQ and a max-PQ

How to design a data-type which implements

- Insert in logarithmic time
- Find the median in constant time
- Delete the median in logarithmic time

Use a min-PQ to store elements greater than the median and a max-PQ to
store elements lesser than the median

**Given k sorted sequences of totally n elements, describe a n log k
algorithm to merge all the k sorted sequences into one sorted sequence
of n elements**

1.  Construct a heap with the k sorted sequences. Base the comparisons
    for heap construction on the smallest element of each sorted
    sequence.
2.  Repeat until there are no elements in the heap
3.   Remove the minimum element of the heap. This gives one sorted
    sequence.
4.   Remove and append the smallest element of this sorted sequence into
    the output sequence
5.   Reinsert the modified sorted sequence

Need for indexed priority queues

- In a priority queue, access is limited to the smallest or largest
  element only. 'Access' means read or change or a delete operation.
  Some clients may need access to all elements in the PQ. This is
  achieved by associating each item with a name(in this case an index).
  The client can now access not only the smallest/largest but also any
  element using its name.

- Applications

  - Prims algorithm
  - Dijkshtra's algorithm.

How is this implemented

Access through the 'name' of an item is implemented by

- Storing the elements in a normal array(keys\[\])
- Storing their names(indexes of the items in the normal) in the
  PQ(pq\[\]). The PQ is of course organized based on the values of the
  items in the normal array and not on the values of the names(indexes)
  it actually stores. Now the items can be referred through
  names(indexes) in the normal data array(keys\[\])
- In order for other access operation like change or delete delete of an
  item, it is necessary to readjust the PQ of the corresponding
  names(indexes) to reflect the change or delete. This can be done only
  if the position of a particular item in the PQ is known. So an
  additional reverse index array(qp\[\]) is used to store the positions
  of the items(actually position of the names of the items) in the PQ.

Semantics of the reverse indexes

Interpret qp\[i\] as giving the index of the priority queue where
i(actually the element associated with i) is stored

Implementations

- [Max
  PQ](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Sorting/src/MaxPQ.java)
- [Min
  PQ](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Sorting/src/MinPQ.java)
- [Indexed minimum priority
  queue](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Sorting/src/IndexMinPQ.java)

What would happen if elements with successively greater priorities are
inserted into

- A minimum priority queue

  - The PQ acts a FIFO queue

- A maximum priority queue

  - The PQ acts as a LIFO stack
