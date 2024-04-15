Directed graphs – Common graph processing problems

[Implementation of a adjacency list
representation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/Digraph.java)

**Single-source reachability– **[Implementation using
DFS](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/DirectedDFS.java)

- Problem

  - Is there a directed path between a **source vertex s** and another
    **given** vertex v?

- Analogous to the single-source connectivity problem for undirected
  graphs. Implementation has no change except for the use of digraphs
  instead of graphs.

- Application of solution to the directed-graph problem is useful in
  implementing a [garbage
  collector](../Compiler%20Design/Automatic%20memory%20management.md)

Multiple-source reachability – [Implementation using
DFS](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/DirectedDFS.java)

- Problem

  - Is there a directed path from any vertex in a given set to a given
    target vertex

- Analogous to the single-source connectivity problem for undirected
  graphs. Implementation has no change except for the use of digraphs
  instead of graphs.

Single-source directed path

- Problem

  - Is there a directed path between a **source vertex s** and another
    given vertex v?
  - If so, find the path.

- Analogous to the single-source path problem for undirected graphs.
  Implementation has no change except for the use of digraphs instead of
  graphs.

Single-source shortest directed path

- Problem

  - Is there a path between a **source vertex s** and another given
    vertex v?
  - If so, find the **shortest** path.

- Analogous to the single-source shortest path problem for undirected
  graphs. Implementation has no change except for the use of digraphs
  instead of graphs.

[Precedence-constrained
scheduling](Precedence-Constrained%20Scheduling.md)

[**Strongly connected
Components**](Strongly%20connected%20components.md)

All pairs reachability

- - Is there a directed path from a **given** vertex v to another
    **given** vertex w?

  - Solution for directed graphs

    - Solution **not** similar to strong connectivity problem. If v and
      w belong to the same component, w is reachable from v. If they
      don't belong to the same strong component, w may still be
      reachable from v.
    - Solution lies in computing the transitive closure for all the
      vertices, i.e., finding the vertices reachable from every vertex
      of G. This makes it a V(V+E) complex.

Finding cycles – [Implementation using
DFS](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/DirectedCycleDFS.java)

- Does the given directed graph contain a cycle

- Useful in

  - [Deadlock detection
    algorithms](../Operating%20System/Deadlock%20detection%20and%20recovery.md#Deadlock%20detection%20algorithms)
  - Semantic analyzer of a object oriented compiler(Is the inheritance
    structure of the program defined cyclically?)

**Symbol Graphs** -
[Implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/StringDigraph.java)
