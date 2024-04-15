2-way partitioning

[Implementation](src/QuickSort.java)

- Note that the inner loop of 'partition(...)' compares an array value
  against a fixed value and increments the index. Merge sort and shell
  sort resort to data movements in their inner loops.

- Handling keys equal to partitioning

  - The left scan is stopped for items with keys greater then or equal
    to the pivot's key

  - The right scan is stopped for items with keys lesser then or equal
    to the pivot's key

  - By doing so it would seem to create unnecessary swaps involving
    items with keys equal to the pivot's key. But this is crucial to
    avoiding quadratic running time for inputs which have only a
    constant number of distinct keys

    - When the scanning stops and a swap has to take place, there can be
      four possible scenarios

      - GL - The left scan has encountered a key **greater** then the
        pivot key and the right scan has encountered a key **lesser**
        than the pivot key.

      - GE - The left scan has encountered a key **greater** then the
        pivot key and the right scan has encountered a key **equal** to
        the pivot key.

      - EL - The left scan has encountered a key **equal** to the pivot
        key and the right scan has encountered a key **lesser** than to
        the pivot key.

        - A swap in all these above three cases is justified as it
          decreases the inversion count.

      - EE – The left and right scans have encountered keys equal to the
        pivot key.

        - A swap may seem unnecessary here and indeed, scanning ahead is
          more efficient when inputs contain only a few duplicate keys.
          But in cases of inputs involving only a constant number of
          distinct keys, scanning ahead causes the partitioning to occur
          on the fringes of the input array, i.e., the recursive tree
          becomes unbalanced leading to quadratic times.
        - Not scanning ahead and swapping results in the partitioning to
          occur more or less in the middle and leads to linearithimic
          times.

  - For example, in inputs with only a single distinct key, a partition
    where the scan proceeds past equal keys always results in subarray
    of size one and n – 2 respectively, thus making the recursion tree
    extremely unbalanced.(Fig 10)
