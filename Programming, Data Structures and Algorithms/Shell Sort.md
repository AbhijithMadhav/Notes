Shell sort

Algorithm

- Insertion sort is slow for large unordered arrays because the only
  exchanges it does involve is of adjacent entries. So items can move
  through the array only one place at a time.

- Shell sort is an extension of insertion sort that gains speed by
  allowing exchanges of array entries that are far apart, to produce
  partially sorted arrays that can be efficiently sorted, eventually by
  insertion sort.

- For a decreasing sequence of h(starting with a large value) which ends
  with 1

  - The h subsequences in the given array consisting of every h'th item
    are identified.

  - All of these h subsequences are individually sorted(insertion sorted
    in this case)

  - Sorting of these h subsequences is called **h-sorting** and it
    results in the partial sorting of the whole array(h-sorted) such
    that every h'th entry(starting anywhere) yields a sorted
    subsequence. The h-sorted array can be seen as h independent
    subsequences, interleaved together.

  - The reason for using insertion sort in h-sorting is that

    - In the beginning the subsequences are short(because h is large)
    - In the later stages, the subsequences are partially sorted

    Both the conditions are tailor made for insertion sort to be
    deployed.

  - h is also called the **increment** and the sequence of values used
    as h is called the **increment sequence**

  - The following property holds during shell sort: when an h-sorted
    array is k-sorted, it remains h-sorted.

<table>
<tbody>
<tr class="odd">
<td>h</td>
<td>Subsequences</td>
<td>a[]</td>
</tr>
<tr class="even">
<td>13-sort</td>
<td>1</td>
<td>SHELLSORTEXAM<strong>P</strong>LE</td>
</tr>
<tr class="odd">
<td>2</td>
<td>PHELLSORTEXAMS<strong>L</strong>E</td>
<td></td>
</tr>
<tr class="even">
<td>3</td>
<td>PHELLSORTEXAMSL<strong>E</strong></td>
<td></td>
</tr>
<tr class="odd">
<td>4</td>
<td>PHELLSORTEXAMSLE</td>
<td></td>
</tr>
<tr class="even">
<td>5</td>
<td>PHELLSORTEXAMSLE</td>
<td></td>
</tr>
<tr class="odd">
<td>6</td>
<td>PHELLSORTEXAMSLE</td>
<td></td>
</tr>
<tr class="even">
<td>7</td>
<td>PHELLSORTEXAMSLE</td>
<td></td>
</tr>
<tr class="odd">
<td>8</td>
<td>PHELLSORTEXAMSLE</td>
<td></td>
</tr>
<tr class="even">
<td>9</td>
<td>PHELLSORTEXAMSLE</td>
<td></td>
</tr>
<tr class="odd">
<td>10</td>
<td>PHELLSORTEXAMSLE</td>
<td></td>
</tr>
<tr class="even">
<td>11</td>
<td>PHELLSORTEXAMSLE</td>
<td></td>
</tr>
<tr class="odd">
<td>12</td>
<td>PHELLSORTEXAMSLE</td>
<td></td>
</tr>
<tr class="even">
<td>13</td>
<td>PHELLSORTEXAMSLE</td>
<td></td>
</tr>
<tr class="odd">
<td>4-sort</td>
<td>1</td>
<td><p>PHEL<strong>L</strong>SORTEXAMSLE</p>
<p>LHELPSOR<strong>T</strong>EXAMSLE</p>
<p>LHELPSORTEXA<strong>MS</strong>LE</p></td>
</tr>
<tr class="even">
<td>2</td>
<td><p>LHELM<strong>S</strong>ORPEXATPLE</p>
<p>LHELMSORP<strong>E</strong>XATPLE</p>
<p>LEELMHORPSXAT<strong>P</strong>LE</p></td>
<td></td>
</tr>
<tr class="odd">
<td>3</td>
<td><p>LEELMH<strong>O</strong>RPPXATSLE</p>
<p>LEELMHORPS<strong>X</strong>ATSLE</p>
<p>LEELMHORPSXATS<strong>L</strong>E</p></td>
<td></td>
</tr>
<tr class="even">
<td>4</td>
<td><p>LEELMHL<strong>R</strong>PSOATSXE</p>
<p>LEELMHLRPSO<strong>A</strong>TSXE</p>
<p>LEEAMHLLPSORTSX<strong>E</strong></p></td>
<td></td>
</tr>
<tr class="odd">
<td>1-sort</td>
<td>1</td>
<td><p>L<strong>E</strong>EAMHLEPSOLTSXR</p>
<p>EL<strong>E</strong>AMHLEPSOLTSXR</p>
<p>EEL<strong>A</strong>MHLEPSOLTSXR</p>
<p>AEEL<strong>M</strong>HLEPSOLTSXR</p>
<p>AEELM<strong>H</strong>LEPSOLTSXR</p>
<p>AEEHLM<strong>L</strong>EPSOLTSXR</p>
<p>AEEHLLM<strong>E</strong>PSOLTSXR</p>
<p>AEEEHLLM<strong>P</strong>SOLTSXR</p>
<p>AEEEHLLMP<strong>S</strong>OLTSXR</p>
<p>AEEEHLLMPS<strong>O</strong>LTSXR</p>
<p>AEEEHLLMOPS<strong>L</strong>TSXR</p>
<p>AEEEHLLLMOPS<strong>T</strong>SXR</p>
<p>AEEEHLLLMOPST<strong>S</strong>XR</p>
<p>AEEEHLLLMOPSST<strong>X</strong>R</p>
<p>AEEEHLLLMOPSSTX<strong>R</strong></p>
<p>AEEEHLLLMOPSSTRX</p></td>
</tr>
</tbody>
</table>

[**Implementation**](Eclipse%20Java%20WorkSpace/Sorting/Shell%20Sort/ShellSort.java)

The implementation uses the sequence of decreasing
values,$$½{({3^{k}–1})}$$, for h starting with the smallest increment
greater than$$\left\lfloor {N/3} \right\rfloor$$ and less than N. This
is the increment sequence given by knuth

Analysis

- The increment sequence plays a role in the performance of the
  algorithm. Though there are several sophisticated increment sequences
  with better worst case performance than Knuth's increment sequence, no
  singly provably best increment sequence has been found.

- Worst case:

  - Study of performance characteristics of shell sort requires
    mathematics which are beyond scope.
  - But it is known that that the worst case running time of shell sort
    depends on the increment sequence.
  - For the one used above it is proportional to $$N^{3/2}$$, i.e., it
    is sub-quadratic.
  - Increment sequences have been devised that drive the asymptotic
    growth of the worst-case number of compares down
    to$$N^{4/3},N^{5/4},N^{6/5},...$$, but many of these results are
    primarily of academic interest because these functions are hard to
    distinguish from one another(and from a constant factor of N) for
    practical values of N.

- Average case:

  No mathematical results are available about the average-case number of
  comparisons for shell sort for randomly ordered data.

- Best case:

  - The least number of comparisons occur when the data is completely
    sorted.
  - For a particular value of the increment, say$$h_{i}$$, each of
    the$$h_{i}$$sub-sequences require atmost one less comparison than
    the number of elements in the sub-sequence(as insertion sort is
    used) which is$$\frac{N}{h_{i}} - 1$$, where N is the total number
    of data items.
  - For$$h_{i}\text{-}\mathit{sorting}$$the given data in this
    situation$${h_{i} \times \left( {\frac{N}{h_{i}} - 1} \right)} = {N - h_{i}}$$number
    of comparisons are needed as there are$$h_{i}$$sub-sequences.
  - If the increment sequence selected is has k increments(such
    that$$h_{k} = 1$$), the total number of comparisons required would
    be$$C{{{(N)} \geq {{{{({N–h_{1}})} + {({N–h_{2}})}} + \ldots} + {({N–h_{k}})}}} = \mathit{kN}}–{{\sum\limits_{i = I}^{k}h_{i}} = O}{(\mathit{kN})}$$
  - Note that k here is not a constant, but a function in N, typical a
    log function. When Knuth's increment sequence is used, there
    are$$\log_{3}N$$ increments and thus the best case running time is
    O(N log N)

Discussion

- Shell sort performs well with large arrays, especially compared to
  quadratic algorithms like insertion and selection sort.
- It also performs well on arrays that are not necessarily in random
  order.
- Shell sort is not stable as it uses insertion sort which swaps
  elements separated by a distance.
- Shell sort is adaptive as can be seen when the file is almost sorted.
- Shell sort is now rarely used in serious applications. It performs
  more operations and has higher cache miss ratio(operates on elements
  separated by considerably large intervals) than quick sort
- Requires O(1) extra space

References

- <http://faculty.simpson.edu/lydia.sinapova/www/cmsc250/LN250_Weiss/L12-ShellSort.htm>
- Sedgewick – 4<sup>th</sup> Editionily of academic interest because
  these functions are hard to distinguish from one another(and from a
  constant factor of N) for practical values of N.
