3-way partitioning

[**Implementation**](src/QuickSort3WayPartitioning.java)

- For cases where there are a few distinct keys the 2-way partitioning
  is inefficient as it results in unnecessary swaps. This is due to the
  right and left scan pausing at keys equal to the partitioning
  key(Figure 11).

- 3-way partitioning partitions the array into 3 sub-arrays(Figure 12)

  - The left sub-array contains elements lesser than the partitioning
    element.
  - The middle sub-array contains elements equal to the partitioning
    element.
  - The right sub-array contains elements lesser than the partitioning
    element.

- Further more the middle sub-array is already sorted and need not be
  partitioned further providing a further performance improvement in
  cases where there are a few distinct keys.

- But 3-way partitioning does not work well with an array with few
  duplicate elements. This is because there is an exchange involved with
  the scan of every key that is not equal to the partitioning
  key.(Figure 13)
