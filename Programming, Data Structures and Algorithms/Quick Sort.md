2-way Quick Sort

Algorithm

- Quick sort is a divide and conquer algorithm
- Select a pivot and partition the array based on it such that no
  element to its left is greater than it and no element to its right is
  lesser than it. A subtlety is that elements equal to the pivot can be
  in both the partitions.
- Recursively sort the two partitions.

[](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Sorting/src/QuickSort.java)

Implementation

- This implementation picks the first element as the pivot.

- Preserving randomness

  - When the partitioning happens such that one of the sub-arrays is
    always empty, the recursive structure of the function calls go deep
    instead of spreading out. This results in strictly one element
    getting sorted per recursive call.
  - Example : A reversed array leads to the above described structure of
    the recursive call tree.
  - Randomizing the array before sorting helps prevent this condition.

- Different ways of partitioning

  - [2-way partitioning](2-way%20partitioning.md)
  - [3-way partitioning](3-way%20partitioning.md)
  - [Fast 3-way partitioning](Fast%203-way%20partitioning.md)

- Optimized implementation

  - Staying in bounds using sentinels
  - Cutting of to insertion sort
  - Using a median of three calculation to select the pivot element

- [Duplicate
  keys](Eclipse%20Java%20WorkSpace/Sorting/Quick%20Sort/ArrayWithOnlyTwoDistinctKeysSortUsingQuickSort.java)

- [Compares](Eclipse%20Java%20WorkSpace/Sorting/Quick%20Sort/ComparesinQuickSort.java)

- Partitioning in place

Analysis

- Faster than any other sort based algorithm. Inner loop of 'partition'
  compares an array value against a fixed value and increments the
  index. Merge sort and shell sort resort to exchanges.

- Efficiency of quick sort is dependent on how the partitioning divides
  the array

  - Best case – When the partitioning divides the array into two equal
    halves and the array has distinct elements

    $$C{{(N)} = 2C}{{{({N/2})} + {({N + 1})}} = {({N + 1})}}\mathit{\lg}N–{1 \equiv N}\mathit{\lg}N$$

  - Average case: C(N) equiv 1.39 N lg N = O(N log N)

  - Worst case: C(N) = N^2/2, but randomization protects against it.

- Quicksort is faster than megesort even though it does 39% more
  compares as data movements are less

- Average swaps for quick sort = 1/3 1.39 N lg N

- 2-way partitioning does not adapt to an array with few distinct keys
  because all elements equal to the pivot will be needlessly swapped to
  the far end in this method. In this case(few distinct keys) there will
  be a considerable amount of keys equal to the pivot.

|     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |                  |
|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|------------------|
|     | B   | A   | B   | B   | B   | B   | A   | C   | C   | A   | B   | B   | C   | A   | C   | A   |                  |
|     | B   | A   | A   | B   | B   | B   | A   | C   | C   | A   | B   | B   | C   | A   | C   | B   |                  |
|     | B   | A   | A   | A   | B   | B   | A   | C   | C   | A   | B   | B   | C   | B   | C   | B   | Unnecessary swap |
|     | B   | A   | A   | A   | B   | B   | A   | C   | C   | A   | B   | B   | C   | B   | C   | B   | Unnecessary swap |
|     | B   | A   | A   | A   | B   | B   | A   | C   | C   | A   | B   | B   | C   | B   | C   | B   |                  |
|     | B   | A   | A   | A   | B   | B   | A   | A   | C   | C   | B   | B   | C   | B   | C   | B   |                  |
| C   |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |                  |
|     | A   | A   | A   | A   | B   | B   | A   | B   | C   | C   | B   | B   | C   | B   | C   | B   |                  |

- The above is the a trace of a single partitioning.

  - The gray highlighted element is the partitioning key
  - Each string shows the array state just before an exchange.
  - The yellow highlighting shows the left scan and the cyan shows the
    right scan

Discussion

- In-place
- Only sort to be inplace and O(N log N)
- Unstable
- Randomized algorithm
- Application – [linear time
  selection](Medians%20and%20Order%20Statistics.md)

Why is quick-sort preferred over merge-sort even if the average number
of compares is lesser in favour of merge-sort(¾ N lg(N) vs. 1.39 N
lg(N))?

The average number of data-movements is less and this results in QS
typically outperforming MS, i.e., 2/3 N lg(N) vs 6 N lg(N) in favour of
QS.

<span id="anchor"></span>Why is quick-sort not stable?

The I and j pointers move such that at the end of an iteration the
elements to the left are lesser than the pivot and the elements to the
right are greater than the pivot. If there are elements equal to the
pivot they are needlessly exchanged leading to instability.

Example: 1, 1, 1, 1, 1, 1, 1
