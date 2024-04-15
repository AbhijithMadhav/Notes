Heap sort

Algorithm – O(N lg N)

- Construct a max heap - O(N)

- Repeat until there are no elements in the heap - O(N)

  - Remove max element and exchange it with the last element of the
    heap. This places the max element in its final position. - O(lg N)
  - Now de-link this element from the heap. - O(1)

Heap sort is a non-adaptive

Why is heap sort not stable?

- Due to the exchanges during the re-heapification after removing the
  min element

- Consider 2<sub>1</sub>, 1, 2<sub>2</sub>.

  Create a heap: 1, 2<sub>1</sub>, 2<sub>2</sub>

  Heap sort: 1, 2<sub>2</sub>, 2<sub>1</sub>
