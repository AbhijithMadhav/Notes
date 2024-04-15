Precedence-constrained scheduling problem

- Given a set of jobs to be completed, with precedence constraints that
  specify that certain jobs have to be completed before certain others
  begin, how can we schedule the jobs such that they are all completed
  while still respecting the constraints?

- The digraph model for representing such a problem is immediate with
  vertices representing jobs and edges representing constraints. An edge
  is present from vertex x to vertex y if job x needs to be completed
  before job y can begin.

- Finding a precedence-constrained schedule in this case amounts to
  putting the vertices in **order** such that all its directed edges
  point from a vertex earlier in the order to a vertex later in the
  order. Such an order is called the topological order.

- Applications

  - [Finding the serializability order of
    transactions](../Databases/Transactions.md#Generating%20a%20serializability%20order)

<span id="anchor"></span>Topological sort

- Given a digraph, put the vertices in a **total** **order** such that
  all its directed edges point from a vertex earlier in the order to a
  vertex later in the order
- However, a digraph has a topological order if and only if it is
  acyclic.
- Such a digraph which contains no directed cycles is called a
  **Directed Acyclic Graph(DAG)**.

Finding the topological order -
[Implementatio](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/Topological.java)[n](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/Topological.java)

- Finding the topological order in a digraph –

  - Determine if the given digraph is a DAG - [Implementation using
    DFS](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/DirectedCycleDFS.java)

    - Implementation is similar to the implementation of finding cycles
      in an undirected graph.

  - Determine the topological order –
    [Implementatio](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/OrderDirectedDFS.java)[n
    using
    DFS](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/OrderDirectedDFS.java)

    - The post order of a digraph is the order in which the visits to
      vertices of a graph are completed. The reverse of this order gives
      the topological order.
