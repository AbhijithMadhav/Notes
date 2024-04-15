Selection sort

**Algorithm –
**[**Implementation**](Eclipse%20Java%20WorkSpace/Sorting/src/SelectionSort.java)

Construct the sorted sequence by repeatedly **selecting** the smallest
element amongst the remaining unsorted elements.

Illustration

S O R T E X A M P L E

A O R T E X S M P L E

A E R T O X S M P L E

A E E T O X S M P L R

A E E L O X S M P T R

A E E L M X S O P T R

A E E L M O S X P T R

A E E L M O P X S T R

A E E L M O P R S T X

A E E L M O P R S T X

A E R L M O P R S T X

Properties

- Non-adaptive

  Running time is$$O{(n^{2})}$$irrespective of the order of the file, a
  **non-adaptive sort**

- Not stable

  The **swap** employed to get the minimum element found in each
  iteration to the last position of the intermediate sorted array causes
  the **instability**. Example: 5, 5, 2, 6

- N – 1 = O(N) swaps.

- $${{{{{{({N–1})} + {({N–2})}} + \ldots} + 1} = \frac{{({N - 1})}N}{2}} = O}{(n^{2})}$$comparisons

- O(1) extra space.

Discussion

Selection sort has the property of minimizing the number of swaps(N –
1). In applications where the cost of swapping items is high, selection
sort very well may be the algorithm of choice.
