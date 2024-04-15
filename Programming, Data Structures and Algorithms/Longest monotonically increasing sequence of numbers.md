Longest monotonically increasing sequence of numbers

Problem

Given a sequence of numbers,
**$$\langle{a_{1,}a_{2,}\ldots,a_{n}}\rangle$$**, find the longest
monotonically increasing subsequence. The subsequence need not be .

Non-memoized solution

Determine the lengths of every possible
subsequence$$\left( 2^{n} \right)$$ and then find the largest one.

Problem characteristics

Is this an optimization problem? - Yes

There are possibly $$\left( 2^{n} \right)$$ monotonically increasing
subsequences and it is required to find the largest one.

Does the optimization problem have an optimal substructure? - Yes

- A monotonically increasing subsequence of length $$k$$ includes a
  similar subsequence of length **$$k - 1$$**.
- If $$L_{i}$$ denotes the length of the longest monotonically
  increasing subsequence **ending at index** $$i$$ in the given
  sequence, the longest monotonically increasing subsequence can be
  described in terms of its subproblems as
  $$\mathit{\max}{({L_{1,}L_{2,}\ldots,L_{n}})}$$, where,
  $$L_{i} = {{({\mathit{\max}_{{j < i}\text{and}{a_{j} < a_{i}}}L_{j}})} + 1}$$.

Are subproblems involved in the candidate solution independent?

The subproblems involved in a candidate solution, $$L_{i}$$, do not
affect each other.

Characteristics of the subproblem space

- **Overlapping subproblems?**

  Yes. $$L_{i}$$ invokes all the of the subproblems involved in solving
  $$L_{i + 1}$$

- Is the entire distinct subproblem space solved? - Yes.

  - Distinct number of subproblems = n, $$L_{1,}L_{2,}\ldots,L_{n}$$

Running time

- Non-memoized solution - $$O{({n2^{n}})}$$

  There are $$2^{n}$$ different subsequences to be examined. The
  examination of each subsequence to see if it is monotonically
  increasing takes at most $$n$$ comparisons.

- **Memoized solution - $$O{(n^{2})}$$**

  Each one of the **$$n$$** values of $$L_{i}$$ is computed by comparing
  $$a_{i}$$ against up to $$i–{1 \leq n}$$ values to the right of it, so
  this analysis gives a total of $$O{(n^{2})}$$ time.
