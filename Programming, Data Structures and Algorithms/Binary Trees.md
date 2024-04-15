Binary Trees

- A binary is a 2-ary tree.
- A binary tree is an ordered tree consisting of two types of nodes:
  external nodes with no children and internal nodes with exactly two
  children.
- A binary tree is either an external node or an internal node connected
  to a pair of binary trees, which are called the left subtree and the
  right subtree of the node.

Terminologies

- Leaf or terminal nodes

  Internal nodes which have only external nodes as children are called
  leaf nodes.

- Level of a node

  The level of a node in a tree is one higher than the level of its
  parent(with the root at level 0)

- Height/depth of a tree

  Two different definitions

  - The height of a tree is the maximum of the levels of the tree's
    nodes

    The height of a tree is the level of its leaf node.

- Path length of a tree

  The path length of a tree is the sum of the levels of all the tree's
  nodes

- Internal Path length of a tree(IPL)

  The sum of the path lengths to all terminal nodes from the root

- External path length of a tree(EPL)

  The sum of the path lengths to all dummy nodes representing nulls of a
  tree

Mathematical properties

- A binary tree with N internal nodes has 2N links: N – 1 links to
  internal nodes(all but for the root) and N + 1(the rest) links to the
  external nodes

- The above also implies that a binary tree with N internal nodes has
  N + 1 external nodes

- The external path length of a binary tree with N internal nodes is 2N
  greater than the internal path.

  - EPL = IPL + 2N

  - The construction of a binary tree with N internal nodes can be done
    follows

    - Start with a tree with just a single external node. The internal
      and external path lengths are zero.
    - To obtain N internal nodes replace an external node with an
      internal node with two external nodes as its children N times.
    - Consider an external node at level k. When it is replaced as
      above, the internal path length increases by k and the external
      path length by 2(k + 1) – k = k + 2(one external node of length k
      is removed and 2 of length k + 1 are added). Thus the external
      path increases by 2 more than the internal path length in each
      step.
    - In the N steps required to create a tree the external path length
      becomes 2N more than the internal path length.

- The maximum number of internal nodes of a binary tree of height
  h(w.r.t leaves) is
  $${N = \left( \frac{k^{h + 1}–1}{k–1} \right)_{k = 2}} = {2^{h + 1} - 1}$$.
  Conversely if a binary tree has N internal nodes its height(w.r.t.
  leaves) is atleast$$\lceil{\mathit{\lg}{({N + 1})}–1}\rceil$$

- The maximum number of leaves in a binary tree of height *h*(w.r.t
  leaves) is$$k^{h} = 2^{h}$$. Conversely if a binary tree has *l*
  leaves, then its height(w.r.t. leaves) is atleast$$\mathit{\lg}l$$–
  when it is perfectly balanced.

- The height(w.r.t. External nodes) of a binary tree with N internal
  nodes is atleast lg N(When the tree is balanced) and at most N –
  1(when the tree is biased completely to one side)

- The internal path length of the binary tree with N internal nodes is
  at least$$N\mathit{\lg}\left( \frac{N}{4} \right)$$ and at
  most$$\frac{N{({N - 1})}}{2}$$

  - When the tree is perfectly balanced, there are N+1 external nodes
    and all of them are at height lg N. External path length is thus
    (N + 1) lg N = IPL + 2N$$\begin{matrix}
    {\Rightarrow{\mathit{IPL} = {({N + 1})}}\mathit{\lg}{{N - 2N} > N}\mathit{\lg}{N - 2N}} \\
    {N\mathit{\lg}{{N - 2N} = N}{{({\mathit{\lg}N–\mathit{\lg}4})} = N}\mathit{\lg}\left( \frac{N}{4} \right)}
    \end{matrix}$$
  - When the tree is completely biased to one side IPL =
    $${{{{0 + 1} + 2} + \ldots} + {({n - 1})}} = \frac{{({n - 1})}n}{2}$$

- Number of vertices in a binary tree is odd.

Types of binary trees

- **Full binary tree or strictly binary tree**

  A binary tree in which every node except the leaves has 2
  children(internal nodes). Tree is full

- Perfect binary tree

  - Is a full binary tree in which all leaves are at the same depth from
    the root.

  - It contains$$2^{l}$$nodes at level l.

  - Total number of nodes,$$t_{n}$$, in a perfect binary tree of depth d
    equals the sum of the number of nodes at each level between 0 and d.
    Thus

    $${{t_{n} = {{{2^{0} + 2^{1}} + \ldots} + 2^{d}}} = {\sum\limits_{j = 0}^{d}2^{j}}} = {2^{d + 1} - 1}$$

  - Since all leaves in this tree are at level d, the tree
    contains$$2^{d}$$leaves and,$$2^{d}–1$$non-leaf nodes.

  - The significance of a perfect binary tree is that it is a binary
    tree with maximum number of nodes for a given depth. Put another
    way, the distance from the root to any leaf(at depth d) is
    relatively small(lg d)

- <span id="anchor"></span>**Complete binary tree**

  A binary tree in which every level except possibly the last is
  completely filled and all nodes are as far left as possible

  - Binary – The tree is binary, which means that each node has atmost 2
    children
  - Complete - The tree is complete, which means that nodes are added
    from top to bottom, left to right, without leaving any spaces.

  The height of a complete binary tree
  is$$\left\lfloor {\mathit{\lg}N} \right\rfloor$$

- Balanced binary tree

  A binary tree in which the height of the left and right subtree of
  every nodes differs by atmost one.

**Binary Tree traversal**

- **In-order or symmetric order** – [Iterative implementation
  ](Eclipse%20C++%20Workspace/5.82-InorderIterative/inOrderIterative.h)

  - Traverse the left subtree in inorder.

  - Visit the root.

  - Traverse the right subtree in inorder.

    Use of stacks can be avoided by using threaded binary trees in which
    leaves have pointers to their inorder successors

- **Pre-order** – [Iterative
  i](Eclipse%20C++%20Workspace/PreOrder/preOrder.h)[mplementation](Eclipse%20C++%20Workspace/PreOrder/preOrder.h)

  - Visit the root.
  - Traverse the left subtree in pre-order.
  - Traverse the right subtree in pre-order.

- Post-order –
  [It](Eclipse%20C++%20Workspace/5.83-PostOrderIterative/postOrderIterative.h)[erative
  implementation](Eclipse%20C++%20Workspace/5.83-PostOrderIterative/postOrderIterative.h)

  - Traverse the left subtree in postorder.
  - Traverse the right subtree in postorder.
  - Visit the root.

- Level order(BFS) from in-order and preorder traversals –
  [Implementation](Eclipse%20C++%20Workspace/5.84-InPreToLevel/inPreToLevel.h)

- [Reconstructing binary trees from
  tree-traversals](Reconstructing%20binary%20trees%20from%20tree-traversals.odt)

Recursive binary tree algorithms

- [Count leaves in a binary
  tree](../../../../../G:/kempa/Dropbox/Notes/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/5.86%20-%20Count%20leaves%20in%20a%20binary%20tree/countLeaves.h)
- [Internal path
  lengt](../../../../../G:/kempa/Dropbox/Notes/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/5.88%20-%20Internal%20path%20length%20of%20a%20binary%20tree/internalPathLength.h)[h](../../../../../G:/kempa/Dropbox/Notes/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/5.88%20-%20Internal%20path%20length%20of%20a%20binary%20tree/internalPathLength.h)[
  of a binary
  tree](../../../../../G:/kempa/Dropbox/Notes/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/5.88%20-%20Internal%20path%20length%20of%20a%20binary%20tree/internalPathLength.h)
- [Remove all leaves with a given key from a tournament
  tree](../../../../../G:/kempa/Dropbox/Notes/Programming,%20Data%20Structures%20and%20Algorithms/Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/5.91%20-%20Delete%20leaves%20of%20a%20tournament%20that%20match%20a%20given%20value/removeFromTournament.h)
