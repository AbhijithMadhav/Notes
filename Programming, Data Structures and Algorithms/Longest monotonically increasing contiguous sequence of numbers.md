Longest monotonically increasing sequence of contiguous numbers

Problem

Given a sequence of numbers,
**$$\langle{a_{1,}a_{2,}\ldots,a_{n}}\rangle$$**, find the longest
monotonically increasing **contiguous** subsequence.

Non-memoized solution

- Determine the lengths of every possible **contiguous**
  subsequence $$\left( \frac{n{({n + 1})}}{2} \right)$$ and then find the
  largest one.

Problem characteristics

Is this an optimization problem? - Yes

There are possibly $$\frac{n{({n + 1})}}{2}$$ monotonically increasing
**contiguous** subsequences and it is required to find the largest one.

Does the optimization problem have an optimal substructure? - Yes

- A monotonically increasing contiguous subsequence of length $$k$$
  includes a similar contiguous subsequence of length **$$k - 1$$**.
- If $$L_{i}$$ denotes the length of the longest monotonically
  increasing contiguous subsequence **starting at index** $$i$$ in the
  given sequence, the longest monotonically increasing contiguous
  subsequence can be described in terms of its subproblems as 
  $$\mathit{\max}{({L_{1,}L_{2,}\ldots,L_{n}})}$$, where, 
   $$L_{i} = \left\{ \begin{matrix}
  {{1 + L_{i + 1}},} & {\mathit{if}{a_{i} < a_{i + 1}}} \\
  1, & \mathit{otherwise}
  \end{matrix} \right.$$.

Are subproblems involved in the candidate solution independent?

Every candidate solution, $$\left( {1 + L_{i + 1}} \right)$$ , involves
only one subproblem. So the question of independence does not arise.

Characteristics of the subproblem space

- **Overlapping subproblems?**

  Yes. $$L_{i}$$ invokes all the of the subproblems involved in solving
  $$L_{i + 1}$$

- Is the entire distinct subproblem space solved? - Yes.

  - Distinct number of subproblems = n, $$L_{1,}L_{2,}\ldots,L_{n}$$

Running time

- Non-memoized solution - $$O{(n^{3})}$$

  There are $$O{(n^{2})}$$ different contiguous subsequences to be
  examined. The examination of each contiguous subsequence to see if it
  is monotonically increasing takes at most $$O{(n)}$$ comparisons.

- Memoized solution - $$\Theta{(n)}$$

  A total of $$n$$ subproblems, $$L_{1,}L_{2,}\ldots,L_{n}$$, are
  solved, each of which require one comparison when solved in the
  correct order$$\left( {L_{n},L_{n - 1},\ldots,L_{1}} \right)$$ . This
  adds up to $$\Theta{(n)}$$ comparisons. Another $$n$$ comparisons are
  required to find the length of the longest monotonically increasing
  contiguous subsequence.
