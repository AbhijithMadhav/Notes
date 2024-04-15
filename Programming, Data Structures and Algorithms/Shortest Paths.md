Shortest paths

What kind of problems does the shortest path algorithm try to answer?

“Find the lowest-weight directed path from one vertex to another”.

Shortest path

A shortest path from vertex s to vertex t in an edge-weighed digraph is
a directed path from s to t with the property that no other such path
has a lower weight.

Objective of *“Single-source shortest paths”* algorithm

Given an edge-wighted digraph and a source vertex s, support queries of
the form, *“Is there a directed path from s to a given target vertex t?
If so, find a shortest such path(minimal weight)”*

Why is a shortest-path to a vertex, v, from a source not possible if
there exists a path from s to v with a negative cycle?

One can keep going around the negative cycle infinitely and keep
constructing shortest-paths shorter than the previous one.

Types of Digraphs shortest path algorithms address

|                                                                                                                           |                                                                                                                                                                          |                     |
|---------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------|
| Algorithm                                                                                                                 | Digraph with negative weighted edge                                                                                                                                      | Digraph with Cycles |
| [Dijkstra's algorithm](Dijkstra's%20algorithm.md)                                                                        | Finds the shortest path only if there are no negative cycles in which case it will enter into an infinite loop.                                                          | Yes                 |
| [Topological sort based shortest-path algorithm for acyclic DAG's](Shortest-path%20algorithm%20for%20ACyclic%20DAG's.md) | Yes                                                                                                                                                                      | No                  |
| [Bellman-Ford algorithm](Bellman-Ford%20algorithm.md)                                                                    | Finds the shortest path only if there are no negative cycles. If there are negative cycles, it will detect them and report the absence of a shortest-path spanning tree. | Yes                 |

Properties of shortest paths

- Paths are directed
- The weights are not necessarily distances
- Not all vertices need to be reachable
- Negative weights introduce complications
- Shortest paths are usually simple
- Shortest paths are not necessarily unique
- Parallel edges and self-loops may be present

Shortest-paths trees(SPT)

- Given an edge weighted digraph and a designated vertex s, a
  shortest-paths tree for a source s is a subgraph containing s and all
  the vertices reachable from s that form a directed tree rooted at s
  such that every tree path is a shortest-path in the digraph.
- There may be two paths of the same length connected s to a vertices;
  if that is the case, we can delete the final edge on on of them and
  thus have only a single path from s to each vertex
- By building a shortest-paths tree, we can provide clients with the
  shortest path from s to any vertex in the graph, using a parent-link
  representation.

Edge Relaxation

- The basic operation in all shortest-path-algorithms.
- Is the process of testing whether the shortest path from the source
  vertex, s, to the 'to' vertex, w, of an edge v → w passes through its
  'from' vertex, v.

Vertex relaxation

- A vertex v is said to be relaxed if all its outgoing edges are relaxed

Analysis of different shortest-path algorithms

|                                                                                                                                      |           |       |
|--------------------------------------------------------------------------------------------------------------------------------------|-----------|-------|
| Algorithm                                                                                                                            | Time      | Space |
| [Dijkstra's algorithm](Dijkstra's%20algorithm.md#Complexity)                                                                        | O(V lg V) | O(V)  |
| [Topological sort based shortest-path algorithm for acyclic DAG's](Shortest-path%20algorithm%20for%20ACyclic%20DAG's.md#Complexity) | O(E + V)  | O(V)  |
| [Bellman-Ford algorithm](Bellman-Ford%20algorithm.md#Complexity)                                                                    | O(VE)     | O(V)  |
