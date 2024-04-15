Bubble sort

Algorithm

- Operates like selection sort. In the i'th pass the sort **bubbles** up
  the i'th smallest element to its correct position.
- Both selection and bubble sort bring the least remaining element to
  place in an iteration. Bubble sort does more work as it moves the
  element one place at a time(bubbling). But this same fact helps bubble
  sort remain stable
- The main difference between insertion sort and bubble sort is that the
  swaps are done within the sorted subarray in case of insertion sort
  while they are done within the unsorted subarray in the case of the
  later.

Implementation

- [Bubble sort](Eclipse%20Java%20WorkSpace/Sorting/src/BubbleSort.java)

Analysis

- Time

  - Best case:

    N-1 = O(n) compares and 0 = O(1) swaps when the sequence is sorted

  - Worst case:

    $${{{{{{{({N–1})} + {({N–2})}} + \ldots} + 2} + 1} = \frac{{({N - 1})}N}{2}} = O}{(N^{2})}$$
    comparisons and swaps when the sequence is in reverse order.

  - **Average case:** Complicated???

- Space

  - O(1)

Characteristics

- **Adaptive:** O(n) when nearly sorted
- Stable

Discussion

- Bubble sort has many of the same properties as insertion sort, but has
  slightly higher overhead(swaps instead of half swaps). Also in the
  case of nearly sorted data, bubble sort takes O(n) time, but requires
  at least 2 passes through the data (whereas insertion sort requires
  something more like 1 pass). Consider the nearly sorted sequence, 2 3
  4 5 1 6 7
- The smaller element moves quickly to the left compared to the movement
  of the bigger element to the right
