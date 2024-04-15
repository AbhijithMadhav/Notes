Rod cutting

[Top-down
implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Design%20of%20Algorithms/Dynamic%20programming/TDRodCutting.java)

[Bottom-up
implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Design%20of%20Algorithms/Dynamic%20programming/BURodCutting.java)

Problem Specification

Given a rod of length *n* inches and a table which specifies prices of
all possible lengths of rods, determine the best way to cut the rod into
pieces such that the revenue from selling those pieces is maximized.

Problem characteristics from a dynamic programming implementation
perspective

- Optimization problem

  The rod can be cut in$$2^{n - 1}$$ different ways which are all
  candidate solutions. The optimal solution is the cut which produces
  the maximum revenue.

- Optimal substructure

  Let r<sub>n </sub>be the maximal revenue obtained for a rod of length
  *n* by cutting it into pieces in the optimal way. Then it can be
  described in terms of its sub-problems as below,
  $${r_{n} = \mathit{\max}}{({{p_{1} + r_{n - 1}},{p_{2} + r_{n - 2}},...,{p_{n - 1} + r_{1,}}p_{n}})}$$,
  where p<sub>i</sub> is the revenue obtained by making a cut at length
  *i*.

- Sub-problems are independent

  Every candidate solution,<sub>$$p_{i} + r_{n - i}$$</sub>, involves
  only one candidate solution. So the question of dependence is not
  relevant.

- Overlapping sub-problems

- From the recursive formulation it is clear that there are only n-1
  unique subproblems. Each subproblem is also composed of some of those
  n-1 unique subproblems

Running time

- Naive Divide and conquer solution(figure 4)

  - Let T(n) denote the number of recursive calls made to solve a rod
    cutting problem of size n. Then,

    - $$\begin{matrix}
      {T{{(0)} = 1,}\mathit{as}\mathit{there}\mathit{is}\mathit{an}\mathit{initial}\mathit{call}} \\
      {\text{AND}} \\
      {T{{(n)} = {1 + {\sum\limits_{i = 1}^{n–1}T}}}{(i)},\mathit{signifying}\mathit{the}\mathit{initial}\mathit{call}\text{and}\mathit{subsequent}\mathit{recursive}\mathit{calls}\text{to}\mathit{solve}} \\
      {\mathit{the}\mathit{subproblem}\mathit{for}\mathit{each}\mathit{position}\mathit{of}\mathit{the}\mathit{cut},\mathit{i.}}
      \end{matrix}$$

  - Solving this simple recurrence problem gives T(n) = 2<sup>n</sup>

    - T(1) = 1 + T(0) = 1 + 2<sup>0 </sup>= 2<sup>1</sup>

      T(2) = 1 + T(0) + T(1) = 1 + 2<sup>0</sup> + 2<sup>1 </sup>=
      2<sup>2</sup>

      T(3) = 1 + T(0) + T(1) + T(2) = 1 + 2<sup>0</sup> + 2<sup>1
      </sup>+ 2<sup>2</sup> = 2<sup>3</sup>

      …

      T(n) = 1 + T(0) + … + T(n-1) = 1 + 2<sup>0</sup> + … +
      2<sup>n-1</sup> = 1 + 2<sup>n </sup>- 1 = 2<sup>n</sup>

- Dynamic programming implementation

  - The solution includes all distinct sub-problems( r<sub>n</sub>,
    r<sub>n-1</sub>, r<sub>n-2</sub>, …, r<sub>1</sub>). Thus, a
    **bottom up implementation** will be more efficient.

  - [Bottom-up
    implementatio](../../../Academic/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Design%20of%20Algorithms/Dynamic%20programming/BURodCutting.java)[n](../../../Academic/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Design%20of%20Algorithms/Dynamic%20programming/BURodCutting.java)

    The running time is easy to see. There is a nested for loop which
    results in$$T{{(n)} = \Theta}{(n^{2})}$$
