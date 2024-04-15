Minimum spanning tree

Applications of minimum spanning trees

- Network protocols use them to avoid broadcast storms

Unique minimum spanning trees

MST's are **guaranteed** to be unique only when all weights of edges of
the graph are unique. They **may not be** unique when there are two or
more edges with the same weight.

Important properties pertaining to spanning trees

- Adding an edge creates a unique cycle
- Removal of an edge from the tree breaks it into two separate subtrees
- The smallest edge of a cut-set of a graph is a part of the MST of the
  graph.
- An MST of a graph with N vertices has n-1 edges.
- [Brute-force method with
  be](../Engineering%20Mathematics/Cayley%20Formula.pdf)$$O{(N^{N - 2})}$$

<span id="anchor"></span>Prim's algorithm

- Select the smallest crossing-edge successively to form the spanning
  tree. There are two ways of selecting the smallest edge

- Lazy version -
  [Implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/LazyPrimMST.java)

  - The candidates for the smallest edge are all the edges adjacent to
    the construction-in-progress MST.

- Eager version -
  [Implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/PrimMST.java)

  - The candidates for the smallest edge are only the smallest edges
    connecting each non-tree vertex to the spanning tree

Prims algorithm

- Maintain a data structure which holds the shortest distances of all
  vertices to the MST. Initially all entries are 'unknown'.

- Include some random vertex, *s*, into the MST, to start off.

- Repeat until all vertices are included in the MST

  - Let *r* be the most recently added vertex to the MST.
  - The shortest distances of the vertices adjacent to r to the MST
    might decrease if they connect to the MST through r more
    economically than they did through some other vertex of the MST
    before. Update the data structure to reflect these possible changes
    in the shortest distances of vertices adjacent to *r*.
  - Now include the vertex, *v*, at the least distance from the MST to
    the MST.

- Implementation details

  - When the graph is sparse, \|E\| \<\< \|V\|<sup>2</sup>,
  - Sparse graph, so Binary heap, as \|E\| is very less and thus \|E\|
    lg\|V\|, the cost of the decrease-key operations will be small.
  - No need to construct binary heap initially

- Running time

  - 

<span id="anchor-1"></span>Kruskal's algorithm -
[Implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/KruskalMST.java)

- Select the smallest edge which does not form a cycle successively to
  form the spanning tree

- Data structures used

  - A priority queue to initially hold all the edges of the graph.
  - A union-find data structure to determine if the addition of an edge
    would form a cycle

Complexity when implemented using a binary heap and a adjacency list
representation

<table>
<tbody>
<tr class="odd">
<td>Algorithm</td>
<td>Time complexity</td>
<td>Space complexity</td>
</tr>
<tr class="even">
<td><p>Prim's</p>
<p>(lazy version)</p></td>
<td>E lg E + E 2lg E ~ O(E lg E)</td>
<td>E</td>
</tr>
<tr class="odd">
<td><ul>
<li>Key operation is insertion and removal of edges into the PQ</li>
<li>Max of E edges in the PQ in the worst case. In this case lg E
required for an insert operation and 2 lg E for a remove operation</li>
<li>Also E such insert and remove operations are required</li>
</ul></td>
<td></td>
<td></td>
</tr>
<tr class="even">
<td><p>Prim's</p>
<p>(eager version)</p></td>
<td><p>= V lg(|V|) + 2V lg(|V|) + E lg(|V|)</p>
<p>~ O(|E + V| lg |V| ) = O(|E| lg|V|) for sparse graphs(adjacency list
representation).</p>
<p>~ O(V<sup>2</sup> lg V) for dense graphs(matrix
representation).</p></td>
<td><p>V</p></td>
</tr>
<tr class="odd">
<td><ul>
<li>Totally each of the V vertices is adjacent to the
construction-in-progress-MST at some point and is thus inserted into the
PQ once = V lg(V) comparisons</li>
<li>Each of the V vertices is also deleted from the PQ for inclusion in
the MST = 2V lg(V) comparisons</li>
<li>In the worst case, when a new vertex, v, is added to the MST the
distances of all vertices adjacent v to the MST may change. Thus there
are |E| change operations = |E| lg(V)</li>
</ul></td>
<td></td>
<td></td>
</tr>
<tr class="even">
<td>Kruskal's</td>
<td><p>= 2E + 2E lg E + 2E lg V + E</p>
<p>~ O(E lg E) for sparse graphs</p>
<p>~ O(V<sup>2</sup> lg (V)) for dense graphs</p>
<p>For dense graphs a matrix representation's O(V<sup>2</sup>) is
preferable</p></td>
<td>E</td>
</tr>
<tr class="odd">
<td><ul>
<li>Construction the PQ with E edges = 2E</li>
<li>Deletion of E edges = 2E lg E</li>
<li>2E find() operations ~ 2E lg(V)</li>
<li>E union operation = E</li>
</ul></td>
<td></td>
<td></td>
</tr>
</tbody>
</table>

Key operation – Finding the minimum edge
