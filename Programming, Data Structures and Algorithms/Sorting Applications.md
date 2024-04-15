Sorting applications

Given a sequence of integers$$a_{1,}a_{2,}\ldots,a_{n}$$and another
integer x, design a$$n\mathit{logn}$$algorithm to decide whether or not
there exists two elements in the sequence whose sum is exactly x.

The brute force method is non-adaptive. It does not learn from its
failed tests. That is why it is $$O{(n^{2})}$$. This is because with an
unordered array, it is not possible to make a decision which leads
towards a solution after each test.

If the array is ordered, then an adaptive decision can be made. The test
is made against the sum of $$a_{1}$$and$$a_{n}$$, we can adapt because
we know that the next largest sum is$$a_{2} + a_{n}$$ and the next
smallest sum is$$a_{1} + a_{n - 1}$$
