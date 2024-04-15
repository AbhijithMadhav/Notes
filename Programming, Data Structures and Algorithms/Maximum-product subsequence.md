Maximum-product subsequence

Problem statement

Given a sequence$$a_{1,}a_{2,}\ldots,a_{n}$$, design
a$$\Theta{(n)}$$algorithm to compute the subsequence of contiguous
numbers having the maximal product

$$\Theta{(n)}$$solution (Figure 14)

- The product of all numbers in the sequence gives us the desired
  product if the number of negative integers is even.

- The product of all numbers in the sequence gives us a non-maximal
  negative product if the number of negative integers is odd.

  - In this case removal of an optimal negative number from the sequence
    should do the trick.

  - If$$a_{i}$$and$$a_{j}$$are the first and last negative numbers of
    the given sequence, then the maximal product is
    $$\mathit{\max}{({a_{1}a_{2}\ldots a_{j - 1},a_{i + 1}a_{i + 2}\ldots a_{n}})}$$

    - Let a_k be a negative number between a_i and a_j and let this be
      the optimal negative number.
    - But
      $$a_{1}\ldots{a_{j - 1} > a_{1}}\ldots a_{k - 1}$$and$$a_{i + 1}\ldots{a_{n} > a_{k + 1}}\ldots a_{n}$$as
      the product spans$$a_{1}\ldots a_{j - 1}$$and
      $$a_{i + 1}\ldots a_{n}$$are positive(missing exactly one of the
      odd negative numbers) and have more elements
      than$$a_{1}\ldots a_{k - 1}$$and$$a_{k + 1}\ldots a_{n}$$respectively.
