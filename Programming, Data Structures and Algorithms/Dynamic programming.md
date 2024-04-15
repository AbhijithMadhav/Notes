Dynamic Programming

- Solves [**optimization
  problems**](Design%20of%20algorithms.odt#Optimization%20problems)
  which exhibit optimal substructures by combining the solutions to
  sub-problems, just like a divide and conquer approach

- In contrast to the divide-and-conquer algorithms, dynamic programming
  algorithms have overlapping sub-problems – that is, sub-problems share
  sub-problems. In this context divide-and-conquer algorithms do more
  work than necessary, repeatedly solving the common sub-problems.
  Dynamic programming algorithms solves each sub-problem just once and
  then saves the answer in a table. “Programming” in this context refers
  to this tabular saving. Thus dynamic programming uses additional
  memory to save computation time.

- The savings obtained may be dramatic: an exponential-time solution may
  be transformed into a polynomial-time solution. This happens where the
  number of distinct sub-problems involved is polynomial in the input
  size and we can solve each such sub-problem in polynomial time.

- Since each sub-problem is solved exactly once, the time required to
  solve a problem is the sum of the time required to solve all its
  sub-problems

- Another aspect about the optimal substructure is that the different
  sub-problems which form a candidate solution must independent of one
  another. Two sub-problems are independent if the solution to one does
  not affect another. If two sub-problems are not independent then the
  optimal solutions to the sub-problems will not combine to form a
  correct/legal solution to the main problem at all

  - Example : Longest path in an unweighted graph

- Thus the two key ingredients of a problem to apply a dynamic solution
  is

  - Optimal substructure with independent sub-problems
  - Overlapping sub-problems - When a recursive algorithm visits the
    same sub-problem repeatedly, we say that the optimization problem
    has overlapping problems.

- Considering the recursion trees of algorithms of optimization problems
  with optimal substructure,

  - The time required to solve a sub-problem is proportional to the
    number of outgoing edges of the corresponding vertex.
  - The number of sub-problems is equal to the number of vertices of the
    recursion tree
  - The running time of the dynamic programming solution is linear in
    the number of vertices and edges.

Step while designing a dynamic programming algorithm for an optimization
problem

- Characterize the problem

  - Check if it is an optimization problem.
  - Check if the problem has optimal substructure.
  - Check if there are overlapping sub-problems.
  - Check if the overlapping sub-problems are independent.

- Recursively define the value of an optimal solution

- Compute the value of an optimal solution

- Construct an optimal solution from computed information

Approaches to implementation

- Top-down with memoization

  - The naive divide and conquer recursive implementation is modified to
    save the result of each sub-problem in a table.

  - Each sub-problem can thus check the table to see if it has already
    been solved.

    - If so uses the value in the table without doing the computation.
    - Else proceeds with the computation as usual

  - This can also be viewed as a kind of depth first search.

- Bottom-up method

  - We sort the sub-problems by size and solve them in size order,
    smallest first so that when solving a particular sub-problem, we
    have already solved all of the smaller sub-problems this
    sub-problems solution depends upon.
  - In other words we consider the sub-problems in a [topological
    order](Precedence-Constrained%20Scheduling.odt) such that no
    sub-problem is considered until all of the sub-problems it depends
    upon have been solved.

- The two approaches usually yield algorithms with the same asymptotic
  running time

  - The top-down approach is faster in which not all sub-problems need
    need to be solved and as top-down approach solves only those needed.
  - In the other case the bottom-up approach often has much better
    constant factors, since it has less overhead for procedure calls.

|                                                                                                                                                                                                                                                                                                                          |                                   |                      |                           |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------|----------------------|---------------------------|
| Problem                                                                                                                                                                                                                                                                                                                  | Plain divide and conquer approach | Dynamic programming  | Bottom-up method          |
| Fibonacci                                                                                                                                                                                                                                                                                                                |                                   |                      |                           |
| [0-1 Knapsack](0-1%20Knapsack.odt)                                                                                                                                                                                                                                                                                       | $$O{(2^{n})}$$                    | $$\Theta{({cn})}$$   | $$\Theta{({cn})}$$        |
| [Tower of Hanoi](Tower%20of%20Hanoi.odt) - Placeholder                                                                                                                                                                                                                                                                   |                                   |                      |                           |
| [Rod cutting](Rod%20cutting.odt)                                                                                                                                                                                                                                                                                         | $$\Theta{(2^{n})}$$               | $$\Theta{(n^{2})}$$  | $$\Theta{(n^{2})}$$       |
| [Matrix-chain multiplication](Matrix-chain%20multiplication.odt)                                                                                                                                                                                                                                                         | $$\Omega{(2^{n})}$$               | $$O{(n^{3})}$$       | $$O{(n^{3})}$$            |
| [Longest common subsequence](Longest%20common%20subsequence.odt)                                                                                                                                                                                                                                                         | $$O{(\mathit{Exponential})}$$     | $$O{(\mathit{mn})}$$ | $$\Theta{(\mathit{mn})}$$ |
| [Longest monotonically increasing ](Longest%20monotonically%20increasing%20contiguous%20sequence%20of%20numbers.odt)[contiguous ](Longest%20monotonically%20increasing%20contiguous%20sequence%20of%20numbers.odt)[sequence of numbers](Longest%20monotonically%20increasing%20contiguous%20sequence%20of%20numbers.odt) | $$O{({n2^{n}})}$$                 | $$O{(n)}$$           | $$O{(n)}$$                |
| [Longest monotonically increasing](Longest%20monotonically%20increasing%20sequence%20of%20numbers.odt)[ ](Longest%20monotonically%20increasing%20sequence%20of%20numbers.odt)[sequence of numbers](Longest%20monotonically%20increasing%20sequence%20of%20numbers.odt)                                                   | $$O{(n^{2})}$$                    | $$O{(n^{2})}$$       | $$O{(n^{2})}$$            |
| [Subset sum](Subset%20sum.odt)                                                                                                                                                                                                                                                                                           |                                   |                      |                           |
| Floyd- Warshall(All pairs shortest-path)                                                                                                                                                                                                                                                                                 |                                   |                      |                           |
| Bellman-Ford(Single source shortest-path)                                                                                                                                                                                                                                                                                |                                   |                      |                           |
