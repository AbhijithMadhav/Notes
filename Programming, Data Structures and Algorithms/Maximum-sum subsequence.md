Maximum sum among all possible subsequences of contiguous numbers in a
given sequence

Problem statement

Given a sequence$$a_{1,}a_{2,}\ldots,a_{n}$$, design a $$\Theta{(n)}$$
algorithm to compute the maximum subsequence of contiguous numbers

$$O{(n^{3})}$$ algorithm

- Use three loops.

  - The outermost one maintains the variant pointing to the start of an
    interval.
  - The middle one maintains a variant pointing to the end of the same
    interval.
  - The last one iterates though the elements in the interval defined
    above and finds the sum of the associated subsequence.

$$O{(n^{2})}$$ algorithm

- The solution can be made$$O{(n^{2})}$$by observing that the sum of the
  subsequence $${s_{i,j} = a_{i}},\ldots,a_{j}$$ is
  $$s_{i,{j - 1}} + a_{j}$$. The third loop does redundant work in
  calculating the $$s_{i,j}$$ by iterating through$$a_{i},...a_{j}$$

$$\Theta{(n)}$$ algorithm

- $$\Theta{(n)}$$solution can be got by interpreting the sum of a
  contiguous subsequence,$$s_{i,j}$$as $$s_{1,j}–s_{1,i}$$. Now the
  maximum of all sums of contiguous subsequences
  is$$\mathit{\max}_{i < j}{({s_{1,j} - s_{1,i}})}$$ which can be found
  out in linear time as above provided we have an auxiliary array
  containing sums of subsequences of the form $$s_{1,j}$$. This kind of
  auxiliary array can be easily formed in linear time.

Another$$\Theta{(n)}$$algorithm

- Another more clear solution can be got by interpreting the nature of
  data. Since the data is numeric, all possible candidate subsequences
  can be seen as being seperated by negative numbers. The maximum of the
  sum of all contiguous subsequences is the one of among them. Thus this
  algorithm works by finding the sum of those all those subsequences and
  thus the max of those in a single pass making this
  a$$\Theta{(n)}$$running time
