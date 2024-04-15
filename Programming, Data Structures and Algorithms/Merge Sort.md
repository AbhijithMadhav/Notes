Merge Sort

Algorithm

- A divide and conquer algorithm.

- To sort an array, divide it into two halves, sort the two halves
  recursively and then merge them(The now ordered halves).

- One can envision merge sort as a procedure which generates the
  appropriate merges where the actual data movement required to sort the
  elements is done.

  - sort(0, 7) MERGESOR

  sort(0, 3)

  sort(0, 1)

  sort(0, 0)

  sort(1, 1)

  merge(0, 1) EMRGESOR

  sort(2, 3)

  sort(2, 2)

  sort(3, 3)

  merge(2, 3) EMGRESOR

  merge(0, 3) EGMRESOR

  sort(4, 7)

  sort(4, 5)

  sort(4, 4)

  sort(5, 5)

  merge(4, 5) EGMRESOR

  sort(6, 7)

  sort(6, 6)

  sort(7, 7)

  merge(6, 7) EGMRESOR

  merge(4, 7) EGMREORS

  merge(0, 7) EEGMORRS

Implementation

- [Merge
  sort](Eclipse%20Java%20WorkSpace/Sorting/Merge%20Sort/MergeSortGoodDesign.java)

  - [Bad Design
    1](Eclipse%20Java%20WorkSpace/Sorting/Merge%20Sort/MergeSortWithBadDesign1.java):
    Do not make aux\[\] a static class member. As merge sort will be a
    shared library software many clients may concurrently use it.
  - [Bad Design
    2](Eclipse%20Java%20WorkSpace/Sorting/Merge%20Sort/MergeSortWithBadDesign2.java):
    Make aux\[\] a local of sort(the driver) instead of merge. If
    aux\[\] is a local of merge, there will be a penalty of creating it
    as many times as merge is called which is
    about$${{\sum 2^{n - 1}} = 2^{n}}–{1 = {N - 1}}$$times($$N = 2^{n}$$is
    the number of elements in the array)

- [Adaptive and
  o](Eclipse%20Java%20WorkSpace/Sorting/Merge%20Sort/MergeSortOptimized.java)[ptimized
  merge
  sort](Eclipse%20Java%20WorkSpace/Sorting/Merge%20Sort/MergeSortOptimized.java)

  - Use insertion sort for small sub-arrays
  - Test whether the array is already sorted
  - Eliminate copy to the auxiliary array.

<!-- -->

- [Bottom up merge
  sort](Eclipse%20Java%20WorkSpace/Sorting/Merge%20Sort/MergeSortBU.java)

  - Iteratively merge from the bottom up starting with a 1-1 pair of
    subarrays. Then 2-2, 4-4 and so forth.
  - Number of comparisons and array access is the same as the top-down
    implementation.

- [Faster
  ](Eclipse%20Java%20WorkSpace/Sorting/Merge%20SOrt/MergeSortFasterUnstable.java)[but
  unstable
  ](Eclipse%20Java%20WorkSpace/Sorting/Merge%20SOrt/MergeSortFasterUnstable.java)[merge](Eclipse%20Java%20WorkSpace/Sorting/Merge%20SOrt/MergeSortFasterUnstable.java)

  The check to see if each of the halves have been exhausted in the
  inner loop can be avoided if the second half of the array is copied in
  decreasing order. However this makes the sort unstable.

- [Indirect merge
  sort](Eclipse%20Java%20WorkSpace/Sorting/Merge%20SOrt/MergeSortIndirect.java)

Analysis

- The number of comparisons used in merge sort can be modeled on a
  recurrence relation. If C(N) is the number of comparisons required to
  sort an array of N comparable items,

  $$C{{(N)} \leq C}{\left( \left\lfloor {N/2} \right\rfloor \right) + C}{\left( \left\lfloor {N/2} \right\rfloor \right) + O}{(N)}$$.
  i.e., the number of comparisons is at most the comparisons required to
  sort the two equal sub-arrays and the comparisons required to merge
  the sorted sub-arrays.

- Best case:

  - When the file is completely sorted, the number of comparisons
    required to merge the two sorted sub-arrays
    is$$\lfloor{N/2}\rfloor$$. This is because the smallest element of
    the second half is ge to the biggest(hence last element of the
    1<sup>st</sup> half. The comparisons considered are only element
    comparisons and not the index comparisons.
    Thus$$C{{(N)} \geq C}{\left( \left\lfloor {N/2} \right\rfloor \right) + C}{{\left( \left\lfloor {N/2} \right\rfloor \right) + {\lfloor{N/2}\rfloor}} = \frac{1}{2}}N\mathit{\lg}N$$
  - If the collection is checked for sortedness before attempting to
    sort and merge its halves, and the file is completely sorted, there
    would be
    only$$C{{(N)} = 2}C{{\left( \left\lfloor {N/2} \right\rfloor \right) + 1} = {N - 1}}$$
    comparisons.

- Worst case:

  - N comparisons for the merge in the worst case where the left and
    right half get exhausted simultaneously, i.e., the sorted array can
    be viewed as formed of elements picked alternatively from the left
    and the right halves.
  - $$C{{(N)} \leq C}{\left( \left\lfloor {N/2} \right\rfloor \right) + C}{{\left( \left\lfloor {N/2} \right\rfloor \right) + N} = N}\mathit{\lg}N$$

- Average case:

  - Elements are intertwined amongst the two halves such that iterations
    in one half comes to an end when the iteration in the other half is
    only half way through during the merge.
  - Thus the number of comparisons = N/2 + N/4
  - $$C{{(N)} \leq C}{\left( \left\lfloor {N/2} \right\rfloor \right) + C}{\left( \left\lfloor {N/2} \right\rfloor \right) + \frac{3}{4}}{N = \frac{3}{4}}N\mathit{\lg}N$$

- The number of comparisons to sort an array of N elements can also be
  understood using the recursive tree structure of merge sort.(Figure 9)

  - Let$$N = 2^{n}$$, where the tree has precisely n levels.

  - For k from 0 to n – 1, the k'th level from the top
    depicts$$2^{k}$$sub-arrays, each of length
    $${2^{n}/2^{k}} = 2^{n - k}$$.

    - The cost of one merge between two sub-arrays
      is$${2 \cdot 2^{n - k}} = 2^{n–{k + 1}}$$
    - For each level, there are$${2^{k}/2} = 2^{k - 1}$$such pairs and
      thus the cost of the all merges is for each level
      is$${2^{k - 1} \cdot 2^{{n - k} + 1}} = 2^{n}$$.

  - For a total of n levels, the total comparisons
    is$${{2^{n} \cdot n} = N}\mathit{\lg}N$$

- Space complexity

  Not an in-place merge, but an abstract in-place merge. The final merge
  result is in the same array while internally using an auxiliary array.
  Thus space complexity is proportional to N.

- [Array
  access](Eclipse%20Java%20WorkSpace/Sorting/src/ArrayAccessesInMergeSort.java)

  - A comparison during a merge needs two accesses and a swap needs four
    array accesses. In the case that every comparison in a merge leads
    to an exchange, there are a maximum of N lg N comparisons leading to
    a maximum of 6N lg N array accesses.

Properties

- Not adaptive

  - If the array is checked for sortedness before attempting to sort and
    merge its two halves, the sort becomes adaptive.

- Stable

- Merge sort is an asymptotically optimal compare-based sorting
  algorithm

  - What this means is that, in the worst case the number of compares
    used by merge sort is asymptotically equal to the minimum number of
    comparisons that any compare-based sorting algorithm can guarantee(
    ~ N lg N)

- Initial conditions

  - Random

  - Nearly sorted

  - Reverse ordered

  - Few Unique

  - When there are duplicate elements

    - If all items have same value and pre-compare is used → O(N) → N –
      1
    - else O(N lg N) → 1.2 N lg N

Inversions -
[Implementation](Eclipse%20Java%20WorkSpace/Sorting/Merge%20Sort/InversionsUsingMergeSort.java)

- Let$$a_{1,}a_{2,}\ldots,a_{n}$$be a sequence of distinct numbers. The
  pair (i, j) is called an inversion if i \< j and $$a_{i} > a_{j}$$.
- An inversion count of an array is the total number of such pairs.
- A brute force solution examines all such pairs, a total
  of$$\frac{n{({n - 1})}}{2}$$of them to obtain the count. This is
  obviously a$$\Theta{(n^{2})}$$solution. This solution is inefficient
  because the count of inversions can be incremented **only by one per
  examination of a pair of numbers in the sequence**. This can be
  improved by using merge sort.
- During the process of merging two sorted subsequences, if$$a_{j}$$in
  the right subsequence is lesser than$$a_{i}$$in the left subsequence,
  then$$a_{i},a_{i + 1},\ldots.a_{\mathit{mid}}$$are all greater
  than$$a_{j}$$. Hence the inversion count for$$a_{j}$$can be increased
  by$$\mathit{mid}–{i + 1}$$in one shot while merging the two sorted
  subsequences.
- Diving deep down, the total count of inversions can be obtained this
  way by employing merge-sort as all inverted elements in the sequence
  are eventually placed in their sorted place in the series of
  successive recursive merges.
- This was the complexity is just$$\Theta{({n\log n})}$$.

Given k sorted sequences of totally n elements, describe a n log k
algorithm to merge all the k sorted sequences into one sorted sequence
of n elements

1.  Consider the k sorted sequences in pairs and merge them until there
    is one large sequence.
