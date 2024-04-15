B and B+ Trees

External search

- A search in which not all key values are present in the addressable
  memory.
- When the amount of data to be stored is huge, a significant quantity
  will have to be stored in secondary storage. Trying to access this
  data might result in disk I/O leading to inefficient searches.
- In this type of search the cost model of the search is defined by the
  number of page accesses
- B and B+ trees are used to store a indexes of relations of a
  relational database

B Trees

- A B-Tree is a generalization of balanced search trees like the 2-3
  tree. It can in general have M-way nodes with M being typically
  large(But it must be such that a node can fit inside a a disk block. A
  node can now be transferred in one I/O). The M in the M-way node
  refers to the number of branches/links leading out of the node. This
  is also called the fanout of the node.

- A B-Tree of order M is a tree that is either an external k-node(with
  k - 1 keys value pairs) or comprises of internal k-nodes(with k - 1
  key-value pairs and k links to B-trees representing each of the k
  intervals delimited by the k-1 keys), having the following structural
  properties:

  - Every path from the root to an external node must be of the same
    length(perfect balance)
  - k must be between 1 and M at the root, and between (M-1)/2 + 1 and M
    at every other node which means that a root node has between 2 to
    M-1 key value pairs and other nodes need to have between (M – 1)/2
    to M – 1 key value pairs

- Physically the internal node is organized to alternatively contain the
  link and key-value fields with the first and last field containing
  links. Thus in a M-way node we have M links and M – 1 key-value
  fields. The left and right links surrounding each key(of a key-value
  field), say K, point to other nodes(internal or external) which have
  respectively keys lesser-than and great-than-or-equal-to K.

- Due to the huge branching factor(M) or fanout the height of the tree
  is extremely short giving it almost constant search time. Specifically
  a search for the node/block containing a key proceeds like in a
  typical balanced tree. Once the node has been zeroed upon, other
  search techniques, typically binary search, is applied to located the
  exact key.

  The search or insertion in a B-tree of order M with N items requires
  between log<sub>M</sub>N and log<sub>M/2 </sub>N probes – a constant
  number for practical purposes

- Deletion

  - If the element to be deleted is in a leaf

    - If there are extra elements in the leaf

      - delete the element

    - else( there are no extra elements in the leaf)

      - If there are extra elements in any immediate siblings

        - Borrow them through the parent

      - else (there aren't extra elements in any immediate siblings)

        - Merge the elements in this leaf with its left sibling through
          the parent

  - else (element to be deleted is not in a leaf)

    - If there are extra elements in the node containing its successor

      - Replace it with its successor

    - else(No extra elements in the node containing its successor)

      - If there are extra elements in any immediate siblings

        - Borrow them through the parent

      - else (there aren't extra elements in any immediate siblings)

        - Merge the elements in this leaf with its left sibling through
          the parent

B+ trees

- A variation of the B-Tree in which

  - The internal nodes contain only copies of keys and links to B+
    sub-trees.
  - The external nodes contains all the key-value pairs.

- By having the internal nodes contain only keys and links, the space
  occupied by data can be used to store more keys and links potentially
  increasing the branching factor and thus increasing the efficiency of
  the search

- The disadvantage is that there are no early outs when you might have
  found a match in an internal node. But since both data structures have
  huge fan-outs, the vast majority of matches will be on leaf nodes
  anyway, making on average the B+ tree more efficient.

- B+Trees are much easier when it comes to looking at every piece of
  data that the tree indexes, since the terminal nodes form a linked
  list. To do a full scan with a B-Tree you need to do a full tree
  traversal to find all the data.
