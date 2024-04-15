Matrix-chain multiplication

[Top-down
implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Design%20of%20Algorithms/Dynamic%20programming/TDMatrixChainMultiplication.java)

[Bottom-up
implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Design%20of%20Algorithms/Dynamic%20programming/BUMatrixChainMultiplication.java)

Problem

- We are given a sequence(chain) \<A<sub>1</sub>, A<sub>2</sub>, …,
  A<sub>n</sub>\> of n matrices to be multiplied, and we wish to compute
  the product A<sub>1</sub>A<sub>2</sub>...A<sub>n</sub>. The order of
  the sequence is important as for any two consecutive matrices, A and
  B, in the sequence to be compatible, the number of columns of A is
  equal to the number of rows in B. The solution deals with the best way
  to parenthesize the sequence without disturbing the order.
- Given a chain \<A<sub>1</sub>, A<sub>2</sub>, …, A<sub>n</sub>\> of n
  matrices and that each matrix A<sub>i</sub> has a dimension
  p<sub>i-1</sub>\*p<sub>i</sub>, fully parenthesize the product
  A<sub>1</sub>A<sub>2</sub>...A<sub>n </sub>in a way that minimizes the
  number of scalar multiplications.

Brute force solution

- <span id="anchor"></span>We can parenthesize a chain of n matrices in
  2<sup>n-1</sup> different ways, since we have an independent option of
  splitting, or not splitting, for the outermost parenthesization
  between the k'th and k+1'th matrices for k = 1 to n – 1.
- The brute force solution involves calculating the cost of all these
  parenthesizations(which may themselves be exponential) and determining
  the minimum among them. Thus the running time may be of the order
  O(n<sup>n</sup>)

Problem characteristics

Is this an optimization problem? - Yes

The given sequence of matrices can be parenthesized in an
[2](#Number different ways of parenthesizations)[<sup>n-1</sup>](#Number different ways of parenthesizations)[
number of](#Number different ways of parenthesizations)[<sup>
</sup>](#Number different ways of parenthesizations)[ways](#Number different ways of parenthesizations).
We seek that parenthesization among the 2<sup>n-1</sup> ones which
results in the minimal amount of scalar multiplications.

Does the optimization problem have an optimal substructure? - Yes

- A<sub>i...j</sub> is the matrix that results from evaluating the
  product A<sub>i</sub>A<sub>i+1</sub>...A<sub>j</sub>, i \< j.

  m\[i, j\] is the minimum number of scalar multiplications needed to
  compute the matrix A<sub>i...j</sub>. It can be expressed in terms of
  the optimal solutions of its subproblems as
  follows<sub>$$\begin{matrix}
  {{{{i - j} + 1} = n},\mathit{the}\mathit{number}\mathit{of}\mathit{matrices}\text{in}\mathit{the}\mathit{chain}} \\
  {m{{\lbrack{i,j}\rbrack} = 0}\mathit{if}{i = j}} \\
  {m{{\lbrack{i,j}\rbrack} = \mathit{\min}}\text{\{}m{{\lbrack{i,k}\rbrack} + m}{{\lbrack{{k + 1,}j}\rbrack} + p_{i - 1}}p_{k}p_{j}\text{\}}\mathit{for}{{i \leq k} < j}\mathit{if}{i < j}}
  \end{matrix}$$</sub>

- As the problem has an optimal substructure there is no need to
  calculate the cost of all 2<sup>n-1</sup> parenthesizations and then
  find the one that has the minimal cost. It is sufficient if we find
  the cost of parenthesizations resulting from the *n* different splits
  at k = i, i + 1, ..j-1 and then determine the split which causes the
  parenthesization with the minimal cost. Each of the *n*
  parenthesizations obtained are the optimal minimum for each of the *n*
  respective positions where a split can be made.

Are the subproblems involved in a candidate solution independent? - Yes

Every candidate solution, the split at some k, involves two subproblems,
the cost of multiplications of subsequences
A<sub>i</sub>A<sub>i+1</sub>...A<sub>k</sub> and
A<sub>k+1</sub>A<sub>k+2</sub>...A<sub>j</sub>. Both these matrices are
disjoint to even consider the prospect of the calculation of the cost of
one to affect the other.

Characteristics of the subproblem space

- Are there overlapping subproblems? - Yes.

  - Total number of feasible subproblems – 2<sup>n</sup>

    Can be seen by drawing the recursion tree.

- Distinct number of subproblems = $$\Theta{(n^{2})}$$

  There are relatively few distinct subproblems: One subproblem for each
  subsequence in a sequence of length n =
  $${{{{{{n + {({n - 1})}} + {({n - 2})}} + \ldots} + 1} = {\sum n}} = \Theta}{(n^{2})}$$

  - Illustration : Consider a sequence of length 4. The subsequences are

    - 1, 12, 123, 1234 → n

      2, 23, 234 → n - 1

      3, 34 → …

      4 → 1

- Is the entire distinct subproblem space solved? - Yes.

  - As is evident from from the recursive problem formulation all the
    distinct subproblems(represented by the upper triangle in the cost
    matrix m\[\]\[\]) are solved.
  - Thus, a bottom up implementation will be more efficient.

Running time

- Naive recursive version

  $$\begin{matrix}
  {\mathit{If}T{(n)}\mathit{is}\mathit{the}\mathit{time}\mathit{taken}\text{to}\mathit{parenthesize}a\mathit{chain}\mathit{of}n\mathit{matrices},\mathit{then}} \\
  {T{{(1)} \geq 1,}\mathit{The}\mathit{time}\text{to}\mathit{recognize}\mathit{that}\mathit{this}\mathit{is}a\mathit{trivial}\mathit{case}} \\
  {T{{(n)} \geq {1 + {\sum\limits_{k = 1}^{n–1}T}}}{{(k)} + T}{{({n–k})} + 1,}\mathit{i.e.}\mathit{The}\mathit{time}\text{to check if}\mathit{this}\mathit{is}a\mathit{trivial}\mathit{case}} \\
  {{+ {\sum\limits_{k = 1}^{n–1}\mathit{The}}}\mathit{time}\mathit{required}\text{to}\mathit{calculate}\mathit{the}\mathit{cost}\mathit{of}\mathit{spliting}\mathit{the}\mathit{chain}\mathit{at}} \\
  {\mathit{position}k} \\
  {\mathit{It}\mathit{can}\mathit{be}\mathit{seen}\mathit{through}\mathit{simple}\mathit{substitution}\mathit{that}T{{(n)} \geq 2^{n - 1}}}
  \end{matrix}$$

<!-- -->

- Top-down method(Figure 3)

  - Solves each of the $$\sum n$$ subproblems once with $$\sum n$$
    recursive calls. Each subproblem may require n iterations to find
    the minimum of the number of scalar multiplications among the
    possible types of parameterizations. Thus $$T{{(n)} = O}{(n^{3})}$$

- Bottom-up method

  - The running time follows from the nested for loops.
    $$T{{(n)} = O}{(n^{3})}$$
