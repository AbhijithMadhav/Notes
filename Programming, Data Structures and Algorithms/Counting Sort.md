Counting sort

[Implementation](src/CountingSort.java)

- Linear time algorithm as long as k = O(n), where k is the largest of
  the domain of numbers in the list

- A non-comparitive sort

- Can be used only on a sequence of integers.

- Stable.

  - Normally, the property of stability is important only when satellite
    data are carried around with the element being sorted.
  - Counting sorts stability is important for another reason. It is
    typically used as a subroutine for radix sort.
