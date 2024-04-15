Sorting

Sorting algorithm classification

- Internal and external sorting

  If the file to be sorted will fit into memory, then the sorting method
  is called internal. Sorting files from tape or disk is called
  external. We deal with internal sorts only here.

- Adaptive and non-adaptive sorting

  - In non-adaptive sorting the sequence of operations performed is
    independent of the order of data. Non-adaptive sorts are well suited
    for hardware implementations.
  - An adaptive sort is one that performs different sequence of
    operations, depending on the outcomes of the comparisons. Most of
    the general-purpose sorts that we consider are adaptive.

- Stable and unstable sorting

  Stable sorts preserve the relative order of items with duplicate keys.
  Usually stable sorts are preferred by applications.

- Direct and indirect sort

  In indirect sort, the data items themselves are not moved. Instead
  pointers or indexes are suitably adjusted.

Performance considerations

- Time

- Space

  - In-place sorts
  - Data pointers or indexes to elements
  - Duplicate copy of elements

Inversions

- An inversion is a pair of entries that are out of order in the array.
- The total number of inversions is a measure of the unsortedness of a
  given array.
- It can also be seen as the number of elements left of each element of
  the array and greater than it.

Partially sorted arrays

If the number of inversions in an array is less than a constant multiple
of the array size, we say that the array is partially sorted. Typical
examples include

- An array where each entry is not far from its final position

<!-- -->

- A small array appended to a large sorted array
- An array with only a few entries not in place.

No compare-cased sorting algorithm can guarantee to sort N items with
fewer than lg(n!) = N lg N compares

Comparisons of various sorts w.r.t to the number of compares

<table>
<tbody>
<tr class="odd">
<td>Algorithm</td>
<td>C(N) in best case</td>
<td>C(N) in average case</td>
<td>C(N) in worst case</td>
</tr>
<tr class="even">
<td><a href="Selection%20Sort.odt">Selection sort</a></td>
<td>= ½(N-1)N ~ O(N<sup>2</sup>)</td>
<td></td>
<td></td>
</tr>
<tr class="odd">
<td><a href="Insertion%20sort.odt">Insertion sort</a></td>
<td>Sorted</td>
<td>Each element moves halfway to its left</td>
<td>Reversed </td>
</tr>
<tr class="even">
<td><p>= N – 1 </p>
<p>~ O(N)</p></td>
<td><p>= ¼(N-1)N</p>
<p>~ O(N<sup>2</sup>)</p></td>
<td><p>= ½ (N-1)N</p>
<p>~ O(N<sup>2</sup>)</p></td>
<td></td>
</tr>
<tr class="odd">
<td><a href="Bubble%20Sort.odt">Bubble sort</a></td>
<td>Sorted </td>
<td>Complicated </td>
<td>Reversed </td>
</tr>
<tr class="even">
<td><p>= (N – 1)</p>
<p> ~ O(N)</p></td>
<td><p>~ ½(N-1)N </p>
<p>~ O(N<sup>2</sup>)</p></td>
<td><p>= ½(N-1)N </p>
<p>~ O(N<sup>2</sup>)</p></td>
<td></td>
</tr>
<tr class="odd">
<td><a href="Shell%20Sort.odt">Shell sort</a></td>
<td>Sorted</td>
<td>Not mathematically determined. Empirical studies suggest that it is
sub-quadratic</td>
<td>~ N<sup>3/4</sup>, i.e., sub-quadratic when used with the intervals
1, 4, 13, ...</td>
</tr>
<tr class="even">
<td><p>= kN – (h<sub>1</sub> + h<sub>2</sub> + … + h<sub>k</sub>)</p>
<p>~O(N log N)</p></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr class="odd">
<td><a href="Merge%20Sort.odt">Merge sort</a></td>
<td>Sorted</td>
<td>Elements are intertwined amongst the two halves such that iterations
in one half comes to an end when the iteration in the other half is only
half way through during the merge.</td>
<td>Elements are intertwined amongst the two halves such that iterations
in both halves during the merge come to an end within one step of each
other</td>
</tr>
<tr class="even">
<td><p>= ½ N lg(N) </p>
<p>~ O(N lg(N))</p></td>
<td><p>= ¾ N lg(N) </p>
<p>~ O(N lg(N))</p></td>
<td><p>= N lg(N) </p>
<p>~ O(N lg(N))</p></td>
<td></td>
</tr>
<tr class="odd">
<td>Merge sort with pre-compare</td>
<td>Sorted</td>
<td></td>
<td>Same as above + (N – 1) pre-compares</td>
</tr>
<tr class="even">
<td><p>= (N-1) </p>
<p>~ O(N)</p></td>
<td><p>= ½(N lg(N)) + (N–1))</p>
<p>~ O(N lg(N))</p></td>
<td><p>= N lg(N) + (N – 1)</p>
<p>~ O(N lg(N))</p></td>
<td></td>
</tr>
<tr class="odd">
<td><a href="Quick%20Sort.odt">Quick sort</a></td>
<td>The array has distinct elements and the pivot divides the array into
equal halves</td>
<td></td>
<td>When the pivot is such that one of the halves is always empty.
<em><strong>Random shuffling protects against this
case</strong></em></td>
</tr>
<tr class="even">
<td><p>= (N+1) lg(N) – 1</p>
<p>~ O(N lg(N))</p></td>
<td><p>~ 1.39 * N lg(N)</p>
<p>~ O(N lg(N))</p></td>
<td><p>= N<sup>2</sup>/2</p>
<p>~O(N<sup>2</sup>)</p></td>
<td></td>
</tr>
<tr class="odd">
<td>3-way Quick sort</td>
<td>The array has few distinct keys</td>
<td></td>
<td></td>
</tr>
<tr class="even">
<td>~ O(N)</td>
<td>~ O(N lg(N))</td>
<td>~O(N<sup>2</sup>)</td>
<td></td>
</tr>
<tr class="odd">
<td><a href="Heap%20Sort.odt">Heap sort</a></td>
<td>Sorted</td>
<td></td>
<td>Descending order</td>
</tr>
<tr class="even">
<td><p>= N/2 + 2Nlg(N)</p>
<p>~ O(N lg(N))</p></td>
<td></td>
<td><p>= 2N + 2Nlg(N)</p>
<p>~ O(N lg(N))</p></td>
<td></td>
</tr>
</tbody>
</table>

Other properties of sort algorithms

<table>
<tbody>
<tr class="odd">
<td>Algorithm</td>
<td>Stable?</td>
<td>In-Place?</td>
<td>Adaptive?</td>
<td>Extra-space</td>
</tr>
<tr class="even">
<td>Bubble sort</td>
<td>Yes</td>
<td>Yes</td>
<td>Yes</td>
<td>1</td>
</tr>
<tr class="odd">
<td>Selection sort</td>
<td><a href="#selection sort not stable">No</a></td>
<td>Yes</td>
<td>No</td>
<td>1</td>
</tr>
<tr class="even">
<td>Insertion sort</td>
<td>Yes</td>
<td>Yes</td>
<td>Yes</td>
<td>1</td>
</tr>
<tr class="odd">
<td>Shell sort</td>
<td>No</td>
<td>Yes</td>
<td>Yes</td>
<td>1</td>
</tr>
<tr class="even">
<td>Merge sort</td>
<td>Yes</td>
<td>No</td>
<td>No</td>
<td><p>N : Bottom-up</p>
<p>N + lg(N) : recursive-top- down</p></td>
</tr>
<tr class="odd">
<td>Quick sort</td>
<td><a href="#quick sort not stable">No</a></td>
<td>Yes</td>
<td><p>No : 2-way-partitioning</p>
<p>Yes : 3-way-partitioning</p></td>
<td>lg(N)</td>
</tr>
<tr class="even">
<td>Heap sort</td>
<td><a href="#Heap sort not stable">No</a></td>
<td>Yes</td>
<td>No</td>
<td>1</td>
</tr>
</tbody>
</table>

Comparisons of various algorithms w.r.t to exchanges

<table>
<tbody>
<tr class="odd">
<td>Algorithm</td>
<td>Exchanges</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr class="even">
<td>Bubble sort</td>
<td>O(N<sup>2</sup>)</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr class="odd">
<td>Selection sort</td>
<td>O(N)</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr class="even">
<td>Insertion sort</td>
<td>O(N<sup>2</sup>)</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr class="odd">
<td>Shell sort</td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr class="even">
<td>Merge sort</td>
<td>No exchanges. Maximum of 6Nlg(N) array accesses</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr class="odd">
<td>Quick sort</td>
<td>1/6(1.39N lg(N))</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr class="even">
<td>Heap sort</td>
<td><p>N + Nlg(N)</p>
<p>Half the number of compares</p></td>
<td></td>
<td></td>
<td></td>
</tr>
</tbody>
</table>

Linear sorting algorithms

- [Counting
  sort](../../../Academic/Programming,%20Data%20Structures%20and%20Algorithms/Notes/Counting%20Sort.odt)
- [Radix sort](Radix%20Sort.odt)
- [Bucket sort](Bucket%20Sort.odt)
