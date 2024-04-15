Trees

Trees are a mathematical abstraction that play a central role in the
design and analysis of algorithms because

- We use trees to describe dynamic properties of algorithms(like the run
  time)
- We build and use explicitly data structures that are concrete
  realizations of trees.

Tree(or free tree)

- A graph with exactly one path between every pair of vertices or

- A connected graph with no circuits or

- A minimally connected graph.

- A graph with exactly$${\mid V \mid}–1$$edges and no cycles.

- A spanning tree is a good example of a tree or a free tree.

- Two trees with the sum of degrees of all their vertices equal to each
  other have the same number of vertices.

  - As the sum of degrees of the vertices of the two trees are equal to
    each other, they must have an equal number of edges.(Each edge
    contributes exactly 2 to the sum of degrees).
  - As they have the same number of edges, they must have the same
    number of vertices, $${\mid E \mid} + 1$$

**Rooted trees(or unordered trees)**

- Trees with a particular node designated as the root. In computer
  science by tree we usually mean rooted trees.

<!-- -->

- Formally a rooted tree(or unordered tree) is a node(called the root)
  connected to a multiset of rooted trees(Such a multiset is called an
  unordered forest)

  - A multiset is a set in which elements can appear more than once.

- Terminologies

  - Leaves or terminal nodes or external nodes

    - Nodes with no children
    - In a concrete representation, external nodes are represented by
      null pointers.

  - Nonterminal nodes or internal nodes

- A DFS tree is a good example of a rooted or an unordered tree.

Ordered tree

- A rooted tree in which the order of the children(such a left child,
  right child) at each node is specified.
- Formally, an ordered tree is a node(called the root) connected to a
  **sequence** of disjoint trees. This sequence is called a **forest**.
-  A rooted tree can have **any** number of children. Because of this a
  linked list implementation is more natural than an arrayed
  implementation. Each node in this implementation is a part of a linked
  list containing its siblings. Each node also has a link to a linked
  list of its children.(Figure ???).

k-ary tree

- An **ordered** tree in which each nodes **must** have a specific
  number of children nodes(external or internal) appearing in a
  **specified** order.

- Formally, a k-ary tree is either an external node or an internal node
  connected to an ordered sequence of k trees that are also k-ary trees.

- Each node can be implemented as a structure with k separate links or
  with an array of k links. The use of arrays to hold the links is
  appropriate because the value of k is fixed.

- A k-ary tree with N internal nodes contains N(k-1)+1 external nodes.

  - Let there be x number of external nodes.
  - Since every node except the root must have a parent there
    are$$\frac{{x + N} - 1}{k}$$parents as each parent has k children.
  - Now the number of parents is the same as the number of internal
    nodes. Thus$$\begin{matrix}
    {N = \frac{{x + N}–1}{k}} \\
    {\Rightarrow{x = N}{{({k–1})} + 1}}
    \end{matrix}$$.

- An k-ary tree of height h contains a **maximum**
  of$$\frac{k^{h + 1}–1}{k–1}$$internal nodes

  - An k-ary tree of height 0 contains only the rooted node and thus
    only one internal node which agrees
    with$$\left( \frac{k^{h + 1}–1}{k–1} \right)_{h = 0} = 1$$
  - Assuming that the above holds good for$${h = 1,}2,3,\ldots,n$$for
    some$$n \geq 0$$, consider a tree of height n + 1. Such a tree
    consists of k trees with$$\frac{k^{h + 1}–1}{k–1}$$and a root node.
    Thus the number of internal leaves
    is$$k{{\frac{k^{n + 1}–1}{k–1} + 1} = \frac{k^{n + 2}–1}{k–1}}$$ and
    the above assertion holds for n + 1.

- The maximum number of external nodes is
  thus$${({k - 1})}{{\frac{k^{h + 1}–1}{k–1} + 1} = k^{h + 1}}$$

- The maximum number of leaves in an k-ary tree of height h is$$k^{h}$$

  - An N-ary tree of height contains only the rooted node and thus only
    one leaf which agrees with$$\left( k^{h} \right)_{h = 0} = 1$$
  - Assuming that the above holds good for$${h = 1,}2,3,\ldots,n$$for
    some$$n \geq 0$$, consider a tree of height n + 1. Such a tree has a
    root and k subtrees with a maximum of$$k^{n}$$leaves. Thus this tree
    contains$${k \times k^{n}} = k^{n + 1}$$leaves and this agrees with
    the above assertion.

Definitions

- Distance between two vertices - The length of the shortest path
  between them
- Eccentricity of a vertex - The length of the path from that vertex, v,
  to the vertex farthest from v in the graph
- Center of a graph - Vertex which has the minimum eccentricity
- Center of tree - one or two
- Radius of the tree - Length of the longest path in a tree
- Path length of a tree - Sum of all path lengths of pendent vertices

References

- Sedgewick – 3<sup>rd</sup> Edition
- Priess
