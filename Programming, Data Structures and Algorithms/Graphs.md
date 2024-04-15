# Graphs

## Sparse graph

A graph is sparse if the number of edges is within a **small** constant
factor of the number of vertices.

i.e., \|E\| = c\|V\|

## Dense graph

A graph is dense if it has almost all the the possible edges

i.e., \|E\| ~ \|V\|\|V-1\|/2

## Comparison of space and time complexity of basic graph operations w.r.t. different underlying representations

|                  |               |              |                                  |                                        |
|------------------|---------------|--------------|----------------------------------|----------------------------------------|
| Representation   | Space         | Add edge v-w | Check whether w is adjacent to v | Iterate through vertices adjacent to v |
| List of edges    | E             | 1            | E                                | E                                      |
| Adjacency matrix | V<sup>2</sup> | 1            | 1                                | V                                      |
| Adjacency list   | V + E         | 1            | degree(v)                        | degree(v)                              |
| Adjacency set    | V + E         |              |                                  |                                        |

## FAQ's
### When is an adjacency list suitable for representation of a graph?

When the graph is sparse. It has a relatively small number of edges.
Representing this graph in a V \* V matrix leads to a lot of wastage of
space as a lot of array entires will go unmarked.

### When is a matrix suitable for graph representation?

When the graph is dense. The overhead of pointers in lists of a
adjacency list becomes very much greater than the wasted space due to
unused entries in a matrix representation as the number of edges are
relatively great.

## Graph Traversals

- [Und](Undirected%20Graphs.md)[irected
  graphs](Undirected%20Graphs.md)

  - DFS -
    [Implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/DFS.java)
  - BFS –
    [Implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/BFS.java)
  - Weighted-Quick-Union –
    [Implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/SearchWQU.java)

- [Directed graphs](Directed%20Graphs.md)

  - DFS -
    [Implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/DirectedDFS.java)

Time complexity of visiting all vertices connected to a source vertex
using DFS and BFS and when the adjacency list representation is used

V + E, where

- V is the number of visits to vertices
- E is the number of stack(DFS) or queue(BFS) operations

In any directed graph, if the out degree of each vertex is at least one,
then there is a directed cycle. If the indegree of each vertex is
atleast one then there is a directed cycle
