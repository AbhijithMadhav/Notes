Dijkstra's algorithm -
[Implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/DijkstraSP.java)

Dijkstra's algorithm

- Maintain a data structure which holds the shortest distances of all
  vertices to the source vertex. Initially all entries are 'unknown'.

- Include the source vertex, *s*, into the SPT.

- Repeat until all vertices are included in the SPT

  - Let *r* be the most recently added vertex to the SPT.
  - The shortest distances from the source to the vertices adjacent to
    *r* might change.

- Relax *r* to discover this change. Update the changes.

- Now include the vertex, *v*, at the least distance from the source to
  the SPT.

Implementation details

- The data structure used to hold the shortest-path distances of
  vertices to the source is a vertex indexed heap as the min element can
  be obtained in O(1) time and changes about the shortest-path distances
  can be done in O(lg V) time.
- Also note that the heap need not contain the distances of all the
  vertices but only of those which are adjacent to the SPT.

Illustrate the greedy strategy in Dijkstra's algorithm

- The shortest path from a source vertex, s, to a destination vertex, v,
  must be through the shortest-paths between s and the intermediary
  vertices between s and v.

- Consider an intermediary vertex w. If the shortest-path from s to v is
  not through the shortest path to w, then the path from s to w and w to
  v that would be shorter than the before said shorter path.

- Thus in the algorithm, shortest paths to v's are built upon shortest
  paths to w's.

  - Initially the shortest-path from s to each of its neighbors is just
    the shortest edge from s to each neighbor.
  - Once this is established, shortest paths to the other vertices are
    found out by making a greedy choice locally.

<span id="anchor"></span>Complexity of implementation of Dijkstra's
algorithm for a sparse graph represented using a adjacency

- **Space complexity** - O(V)

  - Vertex indexed arrays need space proportional to V
  - Even in the worst case the vertex indexed priority queue contains at
    most V - 1 vertices

- **Time complexity** – O(E lg(V)) = O(V lg(V) \[O(V<sup>2 </sup>lg(V))
  for dense graphs\]

  - The construction of the SPT is completed once there are zero
    vertices adjacent to the SPT. That is the priority queue is empty.
  - As each vertex of the graph becomes adjacent to the
    construction-in-progress SPT at some point, each vertex is inserted
    into the PQ once.
  - From the above two points it can be seen that there are V insertions
    and V deletions to the PQ = V lg(V) + 2V lg(V) comparisons
  - In the worst case there might be E 'change-shortest-distance
    operations', caused by a lessening of distance after the addition of
    each vertex(and thus an edge) into the SPT = E lg(V)

Limitation of Dijkstra's algorithm

- Limited to only directed graphs with non-negative weights
