Union find algorithm

A union-find implementation helps in common graph processing tasks like
in solving the connectivity problem.

A union find implementation provides methods for

- Labelling the vertices of a given edge as belonging to a single
  component of a graph(A disconnected graph has multiple components) -
  union()
- Determining the component to which a particular node belongs – find()

Applications

- Dynamic connectivity problem – Is a given graph connected??

- Filter out redundant/extraneous interconnections

- Minimal Network problem

  Determine the minimal interconnections needed in the given network to
  main full connectivity

- Variable-name equivalence problem

  Determine if two variable names refer to the same memory location

- Membership in mathematical sets

  Determine if two elements belong to the same set

<table>
<tbody>
<tr class="odd">
<td><p>Implementation</p></td>
<td>Order of growth of array accesses for N nodes(Worst case)</td>
<td></td>
</tr>
<tr class="even">
<td>Union</td>
<td>Find</td>
<td></td>
</tr>
<tr class="odd">
<td>Quick find</td>
<td>N</td>
<td>1</td>
</tr>
<tr class="even">
<td>Quick Union</td>
<td>Tree Height</td>
<td>Tree height</td>
</tr>
<tr class="odd">
<td>Weighted Quick Union</td>
<td>lg N</td>
<td>lg N</td>
</tr>
</tbody>
</table>

Invariant maintained in the quick-find implementation

All nodes belonging to the same component have the same id. The id
itself is the name of a node representing that component.

Invariant maintained in the quick-union implementation

All nodes belonging to the same component have as the id a node
belonging to the same component. Following the id's leads us to the root
node which represents the whole component.

Notes on weighted quick-union implementation

Similar to quick-union implementation except while doing a union of two
components the tree with the lesser height is added to the tree with the
greater height

Implementations

- [Union-find](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/UnionFind.java)
- [Quick
  find](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/UnionFindQF.java)
- [Quick
  union](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/UnionFindQU.java)
- [Weighted quick
  union](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/UnionFindWQU.java)
- [Search using weighted quick
  union](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/SearchWQU.java)
