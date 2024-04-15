Undirected Graphs - Common graph processing problems

[Implementation of an adjacency list representation](src/ds/graphs/Graph.java)

Single-source connectivity – [Implementation using
DFS](src/ds/graphs/SearchDFS.java)

- Is a given vertex connected to the **source vertex**?
- How many vertices are connected to the **source vertex**?
- **Algorithm - **Run a DFS on the source vertex and collect the data

Multiple-source connectivity

- Is there a path from **any** source vertex in a given set to a given
  target vertex?
- Algorithm - Run DFS on all the source vertices in the given set and
  collect the data.

Single-source path – [Implementation using
DFS](src/ds/graphs/PathsDFS.java)

- Is there a path between a **source vertex s** and another given vertex
  v?
- If so, find the path.
- Algorithm - Run a DFS on the source vertex and collect the data

Single-source shortest path – [Implementation using
BFS](src/ds/graphs/PathsBFS.java)

- Problem

  - Is there a path between a **source vertex s** and another given
    vertex v?
  - If so, find the **shortest** path.

- Solution

  - Run a BFS on the source vertex and collect the data

Connectivity problem -
[Implementatio](src/ds/graphs/ConnectedComponentsDFS.java)[n
using
DFS](src/ds/graphs/ConnectedComponentsDFS.java)
– [Implementation using
Union-Find](src/ds/graphs/UnionFind.java)

- Problem

  - Are two given vertices connected?

    - Is a given graph connected?

  - How many connected components does this graph have?

  - To which component does a vertex belong to?

    - Do two given vertices belong to the same component?

- Why is union-find preferred to DFS based implementations to solve the
  connectivity problems?

  - In theory, DFS based implementations give a constant time result for

    - isconnected(v, w)
    - count()
    - id(v)

  - But they need to pre-process the entire graph before that. Changes
    to the graph like adding an edge will need the whole preprocessing
    again.

  - In contrast a union-find implementation is online, it can answer the
    above queries in reasonable time(near constant) and yet respond to
    dynamic events like adding a graph. One can say that in practice
    this implementation is faster in a dynamic scenario.

  - A DFS based implementation can be used in apps where there is no
    dynamic requirement.

Finding cycles – [Implementation using
DFS](src/ds/graphs/CycleDFS.java)

- Is a given graph cyclic?

**Bipartite graph** – [Implementation using
DFS](src/ds/graphs/BipartiteDFS.java)

- Is the graph bipartite?

**Symbol Graphs** -
[Implementation](src/ds/graphs/StringGraph.java)
– Degrees of separation
