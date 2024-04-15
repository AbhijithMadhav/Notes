Divide and Conquer

- The divide-and-conquer strategy helps design algorithms problems which
  exhibit optimal substructure.
- The sub-problems of the a problem with optimal substructure are
  typically non-overlapping.
- If the sub-problems are overlapping, the [dynamic
  programming](Dynamic%20programming.md) strategy is used.

Strategy

- **Divide** the problems into the subproblems that are smaller
  instances of the same problem.
- **Conquer** the subproblem by solving them recursively(recursive
  cases). If the subproblems are small enough solve them directly(base
  cases)
- **Combine** the solutions to the smaller subproblems into the solution
  for the original problem

**Note :** Subproblems which are not the same as the original problems
are solved in the combine stage like finding the max-crossing-sub-array
in max-sub-array problem.

[Master Theorem](Master%20Theorem.md)

- The running time of divide and conquer algorithms can be captured by
  the recurrence

  - $$T{{(n)} = a}T{\left( \frac{n}{b} \right) + O}\left( n^{d} \right)$$

    where

  - *n* = problem size

  - *a* = number of subproblems

  - *b* = factor by which the subproblem size shrinks

  - $$O{(n^{d})}$$<sup> </sup>= Polynomial representing the time
    required to combine the solutions of the *a* sub-problems to form
    the solution

- The master theorem provides the solution to recurrences of this form

Algorithms employing divide and conquer

- Binary Search(Decrease and conquer) -
  [Implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Symbol%20Tables/src/BinarySearchST.java)
- Merge sort -
  [Implementation](../../../../tmp/Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Sorting/src/MergeSortWithGoodDesign.java)
- Quick sort -
  [Implementation](../../../../tmp/Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Sorting/src/QuickSort.java)
- Finding the maximum sub array – [Implementation](src/MaxSubArray.java)
