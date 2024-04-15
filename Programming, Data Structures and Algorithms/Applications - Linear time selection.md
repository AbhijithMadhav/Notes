Given a sequence $$a_{1,}a_{2,}\ldots,a_{n}$$, design a
$$O{({n\log n})}$$ algorithm to determine if there exists an element x
such that
$${x = {a_{i} + a_{j}}}\mathit{for}\mathit{some}i\text{and}{j \in \{}1,2,\ldots,n\}$$

- Approach 1 – sort and scan from both sides
- Approach 2 – sort and binary search

Given a sequence $$a_{1,}a_{2,}\ldots,a_{n}$$, design a $$\Theta{(n)}$$
algorithm to compute$$\mathit{\max}_{i,j}{a_{j} - a_{i}}$$

- Calculating$$a_{j}–a_{i}$$for all pairs of elements and then finding
  the max of them all would give a correct
  but$$\Theta{(n^{2})}$$solution as there
  are$$\frac{n{({n–1})}}{2}$$pairs.
- The above solution is not interpreting all the information given in
  the question. The question talks of finding the two elements, the
  difference of whom is the greatest. This implies that it wants two
  elements which are the furthest apart from each other in terms of
  their value. Which two elements are the furthest apart from each other
  than the minimum and the maximum.
- So find the minimum element and the maximum element and return their
  difference.

Given a sequence$$a_{1,}a_{2,}\ldots,a_{n}$$, design a $$\Theta{(n)}$$
algorithm to compute$$\mathit{\max}_{i < j}{a_{j} - a_{i}}$$

- Calculating$$a_{j}–a_{i}$$for all pairs of elements and then finding
  the maximum of them all would give a correct
  but$$\Theta{(n^{2})}$$solution as there
  are$$\frac{n{({n–1})}}{2}$$pairs.
- The above solution is not interpreting all the information given in
  the question. The question talks about$$a_{j}$$of always being to the
  right of$$a_{i}$$and then of both of the difference between them being
  the greatest.
- For every$$a_{j}$$for in the sequence, keep track of the
  minimum$$a_{i}$$seen until then and thus find
  $$\mathit{\max}_{i < j}{a_{j} - a_{i}}$$.

Majority element

- Approach 1 – Use select algorithm
- Approach 2 – Use buckets

Describe an O(n)-time algorithm that, given a set S of n distinct
numbers and a positive integer$$k \leq n$$, determines the k numbers in
S that are closest to the median of S

1.  r = 1
2.  l = 1
3.  rankOfMedian = ceiling(n/2)
4.  median = a\[select(A, n, rankOfMedian)\]
5.  for (i = 1; i \<= k ; i++)
6.   x = select (A, n, rankOfMedian – l)
7.   y = select (A, n, rankOfMedian + r)
8.   if ((median – x) \< (y – median))
9.   insert y into the list of k closest elements
10.  l++
11.  else
12.  insert x into the list of k closest elements
13.  r++

Given three arrays A, B, and C, each of n elements, describe
a$$O{(n^{2})}$$algorithm to determine if for some a in A, b in B and c
in C, c = a + b

1.  Sort A and B in descending order
2.  k = 1
3.  l = n
4.  for i : i to n
5.   Repeat 2n times
6.   if (k \> n or l \< 1)
7.   break;
8.   if (a\[k\] + b\[l\] == c\[i\])
9.   return TRUE
10.  else if (a\[k\] + b\[l\] \> c\[i\])
11.  l--
12.  else
13.  k++
14. return FALSE

Finding the i largest elements in an array of n elements

- Algorithm

  - Find i'th order statistic
  - Partition using the i'th order statistic
  - Sort the i largest numbers

- Asymptotically atleast as good as

  - Sorting n elements and getting the i largest numbers.
  - Build max-heap and call extract max i times.
