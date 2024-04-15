Insertion sort

Algorithm –
[Implementatio](Eclipse%20Java%20WorkSpace/Sorting/src/InsertionSort.java)[n(optimized_sort)](Eclipse%20Java%20WorkSpace/Sorting/src/InsertionSort.java)

Create a sorted sequence by repeatedly picking the first remaining
element in the unsorted sequence and **inserting** it it in the
appropriate position in the partially sorted sequence.

Implementation

- [Unoptimize](Eclipse%20Java%20WorkSpace/Sorting/Insertion%20Sort/InsertionSort.java)[d
  Insertion
  sort](Eclipse%20Java%20WorkSpace/Sorting/Insertion%20Sort/InsertionSort.java)
- [Optimize](Eclipse%20Java%20WorkSpace/Sorting/Insertion%20Sort/InsertionSortOptimized.java)[d
  insertion
  sort](Eclipse%20Java%20WorkSpace/Sorting/Insertion%20Sort/InsertionSortOptimized.java)

Characteristics

- Analysis

  - Space

    - **Best case:** N – 1(O(N)) comparisons and 0(O(1)) half swaps when
      the sequence is already sorted

    - **Worst case:
      **$${{{{{{1 + 2} + 3} + \ldots} + {({N–1})}} = \frac{{({N - 1})}N}{2}} = O}{(N^{2})}$$comparisons
      and half swaps when the sequence is in reverse order.

    - **Average case: **

      In the average case assume that the element to be inserted moves
      halfway along the sorted part of the array. For each element this
      would mean half the number of comparison and half swaps w.r.t. the
      worst case.

      $$C{{{{(N)} = {{{{\frac{1}{2} + \frac{2}{2}} + \frac{3}{2}} + \ldots} + \frac{({N–1})}{2}}} = \frac{{({N - 1})}N}{4}} = O}{(N^{2})}$$

  - Time

    - O(1)

- Stable

- Adaptive.

  - O(N) comparisons and O(1) data movements when the sequence is
    already sorted
  - $$O{(N^{2})}$$comparisons and data movements when the sequence is in
    reverse order.
  - No data movement is required is the collection is already sorted.

Discussion

Insertion sort is the algorithm of choice either when the data is nearly
sorted (because it is adaptive) or when the problem size is small
(because it has low overhead, i.e., half swaps instead of full swaps).

For these reasons, and because it is also stable, insertion sort is
often used as the recursive base case (when the problem size is small)
for higher overhead divide-and-conquer sorting algorithms, such as merge
sort or quick sort.

References

- Sedgewick – 3<sup>rd</sup> and 4<sup>th</sup> Edition
- **http://www.sorting-algorithms.com/**
