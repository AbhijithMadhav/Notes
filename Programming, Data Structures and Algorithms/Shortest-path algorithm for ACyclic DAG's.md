Topological-sort based shortest-path algorithm for Acyclic DAG's

Algorithm -
[Implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/AcyclicSP.java)

- Test for the shortest-path to the vertices from the given source as
  determined by the order of vertices in the topological order(Figure 6)

  - For an edge v → w

    - After the test for whether the shortest path to w passes through v
      is done ,
      $$\mathit{distTo}{{\lbrack w\rbrack} \leq \mathit{distTo}}{{\lbrack v\rbrack} + \mathit{weight}}{({v\rightarrow w})}$$

  - As the testing is done in topological order, the test for whether
    the shortest-path to v runs through some other vertex, t, is done
    before the above. As a result distTo\[v\] never changes after
    distTo\[w\] changes as above.

  - So, when the test for the shortest path to w through other vertices
    are done, it can only decrease before settling in on the minimum

- Note that this algorithm can be applied to acyclic graphs with
  negative edges too.

<span id="anchor"></span>Complexity

- Time Complexity = O(E + V) for sparse graphs using adjacency list
  implementation

  - Topological sort = E + V
  - Relaxation according to topological sort = E + V

- Space complexity = O(V)

  - Data structures used

    - Vertex indexed arrays, distTo\[\] and edgeTo\[\]

Longest paths problem for DAGS -
[Implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/AcyclicLP.java)

- Given an edge-weighted DAG and a source vertex s find if there is a
  directed path from s to a given target vertex v? If so , find the
  longest such path.

- As the shortest path algorithm can work even with negative weight
  edges, the longest path can be obtained by applying the same algorithm
  to the DAG after negating the weights

- It could also be done by changing the sense of testing for the
  shortest-path. Testing should now be done for the longest path

  if (distTo\[w\] \< distTo\[v\] + weight(v → w))

  - distTo\[w\] = distTo\[v\] + weight(v → w);

Application of longest paths problem in a DAG - Parallel
precedence-constrained scheduling

Given a set of jobs of specified duration to be completed, with
precedence constraints that specify that certain jobs have to be
completed before certain other jobs are begun, how can we schedule the
jobs on **identical processors(as many as needed) **such that they are
all completed in the minimum amount of time

What is the critical path method? -
[Implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/CPM.java)

- Convert the parallel precedence-constrained scheduling problem into a
  edge-weighted DAG

  - Represent each job by an edge with the weight equal to the time
    needed to complete the job.
  - Further connect these edges according to the precedence constraints.
    The precedence denoting edges will be zero.
  - Connect start vertices of each job to a start vertex, s. Connect end
    vertices of each job to a end vertex, t. The weight of both these
    types of edges will be zero.

- Now the longest path from s to the start vertex of a job represents
  the sequence of jobs which must be done one after another(as they are
  constrained by precedence) and hence cannot be speeded up by putting
  the jobs on parallel processors. Also it being the longest path says
  that a job ,say J, dependent on the completion of two jobs, say A and
  B must start only after the completion of the latest among A and B

  - Thus the start time of each job is the longest distance of its start
    vertex from s along the LPT
  - Also as the longest path length from s to t is the minimum time
    required to complete all those jobs using parallel-processors.
