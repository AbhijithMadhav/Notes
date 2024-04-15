Bellman-Ford algorithm –
[Implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/BellmanFordSP.java)

- Relax all edges of the N vertex graph in one pass
- Run N – 1 passes
- After N – 1 passes check the SPT for **only a cycle**. If the graph
  consisted of a negative cycle, then the ill-formed SPT will have it
  and only looking for a cycle will end up detecting it.
- SPT is completely formed if no cycle is found.

Explain how the Bellman-Ford algorithm completes calculating the
shortest-path for all vertices at the end of N – 1 passes

- Consider a **shortest-path**, v<sub>0</sub> → v<sub>1</sub> → … →
  v<sub>i</sub>, from v<sub>0</sub> to v<sub>i</sub>.
- In the 0<sup>th</sup> pass(of relaxing all edges) only the
  shortest-path to v<sub>0</sub> is discovered(which 0)
- In the 1<sup>st</sup> pass, the edge v<sub>0</sub> → v<sub>1</sub> is
  relaxed as a part of relaxing all edges. Here the shortest path to
  v<sub>1</sub> is finalized as v<sub>0</sub> is already a part of the
  SPT
- Similarly in the 2<sup>nd</sup> pass, the edge v<sub>1</sub> →
  v<sub>2</sub> is relaxed and hence the shortest-path to v<sub>2 </sub>
  is found. This process continues and in the i'th pass the
  shortest-path to v<sub>i</sub> is found.
- But the longest(in terms of number of edges) shortest-path(without
  cycles) in a graph with N vertices is N – 1. Therefore the
  shortest-path to all vertices of a graph from a source vertex is
  determined in N – 1 passes.

Queue based implementation of the Bellman-Ford algorithm

- While relaxing all edges in a pass, the shortest-path to a particular
  vertex, v, can possibly change only if the shortest-path changes for
  the vertex, w, from which there is an edge to v.

- Thus in each pass it is not necessary to relax all edges. It is
  sufficient to relax only those edges whose 'from' vertices had their
  shortest-paths changed in the previous iteration.

- This can be done by maintaining a queue of vertices whose shortest
  paths changed.

- Note that in this method N passes may be required in the worst case
  instead of the constant N – 1 passes. Worst case is as below

  - Consider the **graph**, v<sub>0</sub> → v<sub>1</sub> → … →
    v<sub>n-1</sub>. The maximum length of any shortest path(in terms of
    the number of edges) is N – 1.
  - In the (N – 1)th pass, the edge v<sub>i – 1</sub> → v<sub>i</sub>,
    is relaxed and the shortest-path to all of the vertices from
    v<sub>0</sub> is determined. However due to the nature of the queue
    based implementation, v<sub>i</sub> is put in the queue leading to
    another pass.

- If the queue is not empty at the end of the N<sup>th</sup> pass, it
  means that the distTo\[\] of some vertex, v<sub>,</sub> got changed in
  the N'th pass.

- From the above proof we know that the shortest path to v<sub>
  </sub>must have been finalized to in the first N – 1 passes. So
  distTo\[v\] changing after the N – 1 passes means that it is a part of
  a negative cycle leading its shortest path to monotonically decrease
  infinitely.

<span id="anchor"></span>Performance of the queue based implementation
of the Bellman-Ford algorithm

- Time complexity = O(VE)
- Space complexity = O(V)

Arbitrage of currencies

Making a profit through the process of converting a currency to other
intermediate forms and back to the same currency

Application

- Finding out arbitrage opportunities

  - If x, y, z are the conversion ratios of one currency to itself
    through other intermediaries, there is an arbitrage opportunity is
    xyz \> 1

  - Consider xyz \> 1

    - ln (xyz) \> ln 1

      ln(x) + ln(y) + ln(z) \> 0

      i.e., -\[ ln(x) + ln(y) + ln(z) \] \< 0

      i.e., -ln(x) – ln(y) – ln(z) \< 0

  - Thus representing the arbitrage table data as a directed graph with

    - The vertices representing the currencies

    - The negative natural logarithms(-ln(x)) of the conversion ratios,
      x, as the weights along the directed edges

      We have, any negative cycle, -ln(x) – ln(y) – ln(z) - … \< 0,
      representing an arbitrage property.

- Finding out the best way to convert a currency into another

  - Also the sum of the negative natural logarithms minimize when the
    product of the conversions maximize, the shortest-path from one
    vertex to the other is the best way of converting the currency
    represented by the first vertex into the one represented by the last
    vertex.

Dynamic programming angle

- Bellman ford algorithm to find single source shortest paths can be
  designed as a dynamic problem.

- The subproblems can be identified by recognizing that shortest paths
  from a source vertex s to a vertex v must contain shortest paths from
  s to all the intermediary vertices u.

- The size of the subproblem chosen is the number of permitted edges in
  the path from the source vertex to the a given vertex v.

- The maximum number of edges in a path involving a vertex v is n – 1.

  - A positive cycle is always dropped from a shortest path as it only
    increases weight.
  - A negative cycle cannot be a part of a shortest-path path. This is
    so because a cycle is never a part of a shortest path.

- Problem formulation is as follows

  Let$$D_{s}{\lbrack{k,v}\rbrack}$$= The distance of the shortest-path
  from s to v with a length of atmost k.

  $$D_{s}{{\lbrack{k,v}\rbrack} = \mathit{\min}}\left\{ \begin{matrix}
  {D_{s}{\lbrack{{k - 1,}v}\rbrack}} \\
  {\mathit{\min}_{\forall w,{v \in V}}\left\{ {D_{s}{{\lbrack{{k - 1,}w}\rbrack} + c_{\mathit{wv}}}} \right\}}
  \end{matrix} \right.$$

  Base case
  :$$\forall{w \in V},D_{s}{{\lbrack{0,s}\rbrack} = 0}\text{and}D_{s}{\lbrack{0,w}\rbrack}$$

- Required solutions :
  $$\forall{w \in V},D_{s}{\lbrack{{n - 1,}w}\rbrack}$$. This is because
  the longest path length of a shortest-path can only be N – 1

- Detection of negative cycle:

  - There is no negative cycle **reachable from s ***if and only if*
    solving for n sized subproblems not change the distances of any
    vertex v.

- Time complexity :

  - The number of candidates for an optimal solution to a problem
    involving a destination v = 1 + inDegree(v).
  - Thus total time
    is$$O{\left( {{n \ast {\sum\limits_{v \in V}\mathit{indegree}}}{(v)}} \right) = O}{(\mathit{VE})}$$

- Space complexity :

  - The subproblem size runs from 0 to N – 1 and $${\mid V \mid} = n$$.
    Thus a total of$$n^{2}$$entries are needed for the dynamic table.
  - But as k sized subproblem needs results only from (k-1) sized
    subproblems, only two arrays size n is sufficient bringing down the
    space complexity to O(n).

- Stopping early

  - Suppose for some j \< n − 1, A\[j, v \] = A\[j − 1, v \] for all
    vertices v .
  - ⇒ For all v , all future A\[i, v \]’s will be the same
  - ⇒ Can safely halt (since A\[n − 1, v \]’s = correct shortest-path
    distances)

Basic algorithm

1.  $$\begin{matrix}
    {D_{s}{{\lbrack{0,s}\rbrack} = 0}} \\
    {\pi{{\lbrack s\rbrack} = s}}
    \end{matrix}$$
2.  for all other$$v \in G$$
3.   $$\begin{matrix}
    {D_{s}{{\lbrack{0,v}\rbrack} = \infty}} \\
    {\pi{{\lbrack v\rbrack} = v}}
    \end{matrix}$$
4.  for each subproblem size, k = 1 to n - 1
5.   for$$v \in V$$
6.   $$D_{s}{{\lbrack{k,v}\rbrack} = D_{s}}{\lbrack{{k - 1,}v}\rbrack}$$
7.   for$${({w,v})} \in E$$
8.  
    if$$D_{s}{{\lbrack{k,v}\rbrack} > D_{s}}{{\lbrack{{k - 1,}w}\rbrack} + c_{\mathit{wv}}}$$
9.   $$\begin{matrix}
    {D_{s}{{\lbrack{k,v}\rbrack} = D_{s}}{{\lbrack{{k - 1,}w}\rbrack} + c_{\mathit{wv}}}} \\
    {\pi{{(v)} = w}}
    \end{matrix}$$

O(n) space algorithm

$$D_{s}{{\lbrack s\rbrack} = 0}$$

$$\pi{{\lbrack s\rbrack} = s}$$

for all other$$v \in G$$

$$D_{s}{{\lbrack v\rbrack} = \infty}$$

$$\pi{{\lbrack v\rbrack} = v}$$

for each subproblem size(1 to n - 1)

for$$v \in V$$

for$${({w,v})} \in E$$

if$$D_{s}{{\lbrack v\rbrack} > D_{s}}{{\lbrack w\rbrack} + c_{\mathit{wv}}}$$

$$D_{s}{{\lbrack v\rbrack} = D_{s}}{{\lbrack w\rbrack} + c_{\mathit{wv}}}$$

$$\pi{{\lbrack v\rbrack} = w}$$
