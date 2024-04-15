Binary Heap

- A binary heap is a data structure, a [complete binary
  tree](Binary%20Trees.md#Complete%20binary%20tree) in which the key
  stored at a node satisfies a predicate(**the binary heap property**)
  with respect to the keys stored in it child nodes.

- The predicate is one of the below

  - The key of the parent is larger than or equal to the keys of its
    children. In this case the heap is called a max heap. Thus the
    largest key is stored at the root in a max heap.
  - The key of the parent is smaller than or equal to the keys of its
    children. In this case the heap is called a min heap. Thus the
    smallest key is stored at the root in a max heap.

- The notes below speaks about the max heap. The min heap is based on
  the same principle.

Properties of a binary heap

- Nodes at a lower level than a particular node A, are necessarily
  greater than 'A' only if they are descendants of A.

- Since the ordering of siblings in a heap is not specified by the heap
  property, a single node's two children can be freely interchanged
  unless doing so violates the shape property(completeness of the binary
  tree).

- If a heap is implemented using an array with the 0<sup>th</sup>
  position unused, the parent of a node in position k is in
  position$$\left\lfloor \frac{k}{2} \right\rfloor$$and, conversely, the
  two children of the node in position k are in positions 2k and 2k + 1.

- Minimum and maximum number of elements(N) possible in a binary heap of
  height* h*

  - A binary heap has the minimum number of elements when it has just
    one node of height *h* and all other levels are filled. The number
    of elements in the tree excluding the last level is$$2^{h}–1$$.
    Thus$$N \geq 2^{h}$$
  - A binary heap has maximum number of elements when all its levels are
    filled. Thus$$N \leq {2^{h + 1} - 1}$$
  - $${2^{h} \leq N} \leq {2^{h + 1} - 1}$$
    or$$\mathit{\lg}{({N + 1})}–{{1 \leq h} \leq \mathit{\lg}}N$$

- With respect to the level order based ordering leaf nodes of a heap
  can be accessed using the
  indices$${\lfloor{N/2}\rfloor} + 1$$,$${\lfloor{N/2}\rfloor} + 2$$, …
  N

- The height of a binary heap is$$\lfloor{\mathit{\lg}N}\rfloor$$

  $${2^{h} \leq N} \leq {2^{h + 1} - 1}$$ or
  $${2^{h} \leq N} < 2^{h + 1}$$
  or$${h \leq \mathit{\lg}}{N < {h + 1}}$$

- An N-element heap has at
  most$$\left\lceil \frac{N}{2^{h + 1}} \right\rceil$$nodes of height h.

<table>
<tbody>
<tr class="odd">
<td>Height</td>
<td>No. of nodes</td>
</tr>
<tr class="even">
<td>0</td>
<td>N/2(all leaves)</td>
</tr>
<tr class="odd">
<td>1</td>
<td>N/4</td>
</tr>
<tr class="even">
<td>2</td>
<td>N/8</td>
</tr>
<tr class="odd">
<td><p>.</p>
<p>.</p>
<p>.</p></td>
<td><p>.</p>
<p>.</p>
<p>.</p></td>
</tr>
<tr class="even">
<td>h</td>
<td><span class="math display">$$\frac{N}{2^{h + 1}}$$</span></td>
</tr>
</tbody>
</table>

- In a max heap the smallest element resides as one of the leaves as it
  can't have children. Similarly in a min heap the greatest element
  resides as one of the leaves as it can't have children.
- ??The position the k'th greatest element can occupy in the max heap is
  $$\left\lbrack {2^{\lfloor{\mathit{\lg}k}\rfloor},\mathit{Min}{({N,{2k + 1}})}} \right\rbrack$$.

Heap operations

- Heapify or sink – O(lg N)

  - When a key is smaller than that of either one of its children, the
    order of a binary heap is violated. It can be rectified by swapping
    the key with that of its larger child. Repeated application of this
    operation moves a key down the binary heap and is thus called
    sinking.
  - One sink operation for a key requires two comparisons - comparing
    the siblings ksy, comparing the key with that of the larger
    sibling's key.

- Building a heap - O(N)

  - Intuitive way is to do a swim based heap construction, from top to
    bottom. If a heap of N elements is to be constructed each element
    would requires a maximum of lg N comparisons making the time to
    construct proportional to N lg(N)

  - A sink based heap construction would however require only O(N). Sink
    all keys which have children. For N elements We would need N/2 sink
    operations

  - Analysis

    - The reasoning is as follows. Re-heapifying a node, say Z, whose
      left and right trees are already heapified results in a bigger
      heap consisting of this Z as well. At the start, all leaf
      nodes$$\left( {A_{{\lfloor{N/2}\rfloor} + 1},A_{{\lfloor{N/2}\rfloor} + 2}...A_{N}} \right)$$
      can be considered as trivial heaps as they don't have children. We
      thus proceed in a bottom up
      manner$$\left( {A_{\lfloor{N/2}\rfloor},A_{{\lfloor{N/2}\rfloor}–1}...1} \right)$$creating
      and collating heaps into larger ones.

    - The time required to heapify when called on a node of height h is
      O(h). Thus the total cost of building a heap is$$\begin{matrix}
      {T{{(N)} = {\sum\limits_{i = 0}^{h}\{}}\mathit{No}\mathit{of}\mathit{comparisons}\text{to}\mathit{reheapify}a\mathit{node}\mathit{at}\mathit{height}h\}} \\
      {{. \times \{}\mathit{Number}\mathit{of}\mathit{nodes}\mathit{at}\mathit{height}h\}} \\
      {T{{(N)} = {\sum\limits_{i = 0}^{h}i}}\frac{N}{2^{i + 1}}{=}N{{\sum\limits_{i = 0}^{h}\frac{i}{2^{i + 1}}} = O}{(N)}}
      \end{matrix}$$

      as$${h = \mathit{\lg}}N$$and
      $${\sum\limits_{i = 0}^{\mathit{\lg}N}\frac{i}{2^{i + 1}}} < N$$

- Swim – O(lg N)

  - When a key is larger than that of its parent, the order of a binary
    heap is violated. It can be rectified by swapping the key with that
    of its parents. Repeated application of this this operation moves
    the key up the binary heap and is thus called swimming.
  - One swim operation for a key requires one comparison, comparing the
    key with that of its parent's.

- Insert – O(lg N)

  - Add key at the end of the tree and swim it up so that the order of
    the binary heap is not violated.
  - This requires no more than 1 + lg N compares

- Remove the maximum

  - Remove the first node
  - Put the item from the end of the heap at the top.
  - Make it sink.
  - This requires no more than 2 lg N compares

Heap implementation

- Theoretically a binary heap can be array based or linked list
  based(binary trees).

- Heaps are typically array based though.

  - The case for a linked list based heap implementation would have
    arisen if insertions and deletions occurred at random positions.
    This kind of operation is very inefficient in arrays as it involves
    moving entire segments of arrays. But as outlined above

    - The insertion operation involves appending the new key to the end
      of the array.
    - The remove-the-maximum operation involves removing a key at the
      end of an array.

    Both these operations are efficient in arrays.

  - Also binary heaps due to their top-to-bottom, left-to-right
    structure can be represented in an array in a compact manner saving
    the space needed for links of the linked list based implementation.

- Tree based implementation

  - The tricky part in a tree based implementation is finding out the
    next insert position to insert elements and the last leaf to delete
    the maximum element. These positions will have to be kept track of
    explicitly using global pointers.

Will not using a higher order(d) heap lessen the height of the tree and
thus the insert and delete times?

Increasing the degree of the heap increases the comparisons per level
required in case of delete.

$$C{{(N)} = d}\log_{d}{N = \frac{d}{\mathit{\lg}d}}\mathit{\lg}N$$.
Observe that the denominator in the factor$$\frac{d}{\mathit{\lg}d}$$is
not able to keep up with with the numerator. So I think this offsets the
reduction achieved through the smaller height.

Effect of called sink(i) for i \> N/2?

Will return immediately as all A\[i\] for I \> N/2 are leaf nodes

Applications for binary heaps

- [Heap sort](Heap%20Sort.md)(Max heap)
- [Priority queues](Priority%20Queue.md)(typically min heaps)
