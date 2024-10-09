0-1 Knapsack problem

[Top-down
implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Design%20of%20Algorithms/Dynamic%20programming/TD01Knapsack.java)

[Bottom-up
implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Design%20of%20Algorithms/Dynamic%20programming/BU01Knapsack.java)

Problem

- Given a knapsack of fixed capacity, *c*, and *n* items of fixed
  integral weights(w<sub>1</sub>, w<sub>2</sub>, …, w<sub>n</sub>) and
  prices(p<sub>1 </sub>, p<sub>2</sub>, …, p<sub>n</sub>), find a way to
  pack the knapsack such that the value of the items in the knapsack is
  the maximum.
- The weights and values are integers
- The '0-1' signifies that the item is included in the knapsack or not
  included.

Brute force solution

- We can pack the knapsack in **possibly** 2<sup>n</sup> ways provided
  the packing fits into the knapsack. The count of 2<sup>n</sup> is
  arrived at recognizing that the packing can contain or not contain
  each of the *n* items.
- The brute force solution involves calculating the cost of all these
  packings and determining the maximum among them. Thus the running time
  may be exponential

Problem characteristics

Is this an optimization problem? - Yes

We can pack the knapsack in many ways(**possibly** 2<sup>n</sup>,
capacity allowing). But what is required is the packing that gives the
maximum value.

Does the optimization problem have an optimal substructure? - Yes

Let V<sub>c </sub>be the maximal value obtainable for a knapsack of
capacity c by packing it in an optimal way. Then it can be described in
terms of its subproblems as below,
$${V_{n} = \mathit{\max}}{({{p_{1} + V_{c - w_{1}}},{p_{2} + V_{c - w_{2}}},...,{p_{n} + V_{c - w_{n}}}})}$$

- where p<sub>i</sub> is the price of the i'th item and $$V_{c–w_{i}}$$
  is the optimal value of the knapsack for the remaining capacity.

As the problem has an optimal substructure there is no need to calculate
the cost of all **possibly** 2<sup>n</sup> packings and then find the
one that provides the maximum price. It is sufficient if we find the
cost of *n* packings formulated above and find the maximum among them.
Each of the *n* packings obtained are the optimally maximum w.r.t.
containing the given item.

Are the subproblems involved in a candidate solution independent?

Every candidate solution involves only one candidate solution only. So
the question of independence does not arise.

Characteristics of the subproblem space

- Are there overlapping subproblems? - Yes.

  - Total number of subproblems - 2<sup>n</sup>

  - Total number of feasible subproblems – c , one each for every
    indivisible unit of capacity

  - Distinct number of subproblems = n \< c

    It is clear from the recursive formulation that the subproblem space
    consists of just n distinct subproblems(
    $$V_{c - w_{1}},V_{c - w_{2}},...,V_{c - w_{n}}$$)

- Is the entire distinct subproblem space solved? - No.

  - n distinct subproblems are solved

  - Only *n* among the possible *c* distinct subproblems are solved.

  - Thus, a top down implementation will be more efficient.

Running time

- Naive Divide and conquer solution

  - Let T(n) denote the number of recursive calls made to solve a 0-1
    knapsack problem. Then,

    - $$\begin{matrix}
      {T{{(0)} = 1,}\mathit{as}\mathit{there}\mathit{is}\mathit{an}\mathit{initial}\mathit{call}} \\
      {\text{AND}} \\
      {T{{(n)} \leq {1 + {\sum\limits_{i = 1}^{n}T}}}{(i)},\mathit{signifying}\mathit{the}\mathit{initial}\mathit{call}\text{and}\mathit{subsequent}\mathit{recursive}\mathit{calls}\text{to}\mathit{solve}} \\
      {\mathit{the}\mathit{subproblem}\mathit{for}a\mathit{particular}\mathit{capacity},\mathit{i.}} \\
      {\mathit{Note}\mathit{that}\mathit{the}\mathit{lesser}\mathit{than}\mathit{sign}\mathit{compensates}\mathit{for}\mathit{not}\mathit{all}\mathit{subproblems}\mathit{being}\mathit{solved}}
      \end{matrix}$$

  - Solving this simple recurrence problem gives
    <sup>$$T{{(n)} = O}{(2^{n})}$$</sup>

    - T(0) = 1 = 2<sup>0</sup>

      T(1) = 1 + T(0) = 1 + 2<sup>0 </sup>= 2<sup>1</sup>

      T(2) = 1 + T(0) + T(1) = 1 + 2<sup>0</sup> + 2<sup>1 </sup>=
      2<sup>2</sup>

      T(3) = 1 + T(0) + T(1) + T(2) = 1 + 2<sup>0</sup> + 2<sup>1
      </sup>+ 2<sup>2</sup> = 2<sup>3</sup>

      …

      T(n) = 1 + T(0) + … + T(n-1) = 1 + 2<sup>0</sup> + … +
      2<sup>n-1</sup> = 1 + 2<sup>n </sup>- 1 = 2<sup>n</sup>

- Top down method with memoization

  - Solves each of the n subproblems once with n recursive calls. Each
    subproblem runs a for loop for a maximum of c times to determine the
    maximum revenue. Thus

    $$T{{(n)} = \Theta}{({cn})}$$

- Bottom up method with memoization

  - The running time is easy to see. There is a nested for loop which
    results in $$T{{(n)} = \Theta}{(\mathit{cn})}$$
