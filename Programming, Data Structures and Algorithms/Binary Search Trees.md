Binary search tree(BST)

- A binary search tree(BST) is a binary tree which satisfies the
  restriction that the key in any node is larger than the keys in all
  nodes in the node's left subtree and smaller than the keys in all
  nodes in that node's right subtree.

- An in-order traversal of such a tree gives us a sorted list.

- BST's combine the flexibility of insertion in a linked list with the
  efficiency of search in an ordered array.

- The performance of an operation on a BST depends on the shape of the
  tree.

  - In the best case, if the tree is completely balanced, the worst case
    complexity is O(lg N)
  - In the worst case, if the tree is completely biased to one side, the
    worst case complexity is O(N).

Properties of binary search trees(Figure 1)

- If a node in a BST has two children, then its in-order successor has
  no left child and its inorder predecessor has no right child

  - If they respectively did, then those nodes would be the inorder
    successor and and inorder predecessor respectively.

- In a BST T whose keys are distinct, let x be a leaf node and let y be
  its parent. Then, y is either the smallest key in T which is larger
  than x or largest key in T which is smaller than x.

Number of binary search trees that can be formed out of n distinct nodes

- The root of a BST can be formed with any of the n nodes.

- Once a node, say k'th, is picked as the root, it's left subtree is
  also a BST with k – 1 nodes. Similarly, its right subtree is also a
  BST with n – k nodes.

- As each of the each of the left and right subtrees form different
  BST's with the root the total number of

- Total number of BST's = Number of BST's with the 1<sup>st</sup> node
  as root + Number of BST's with 2<sup>nd</sup> node as root + … +
  Number of BST's with the n'th node as root

  - $$C{{(n)} = {\sum\limits_{i = 1}^{n}{C{({i–1})}C{({n - i})}}}}$$

Basic operations – [Implementation](src/BinarySearchTreeST.java)

- Search

  - Given a key, a comparison with the root of the BST tells us if the
    required node is in the left or right subtree of that node. This
    process when continued recursively takes us to a node where the
    required key is present. If not present the traversal takes us to a
    null node which means that the key is not present.

- Insertion

  - Insertion follows the same traversal technique adopted during a
    search. Here if the key is found, the corresponding value is
    updated. If not, we reach a null node which is the new place of the
    key to be inserted.

- Deletion(Figure ???)

  - Deletion follows the same traversal technique to reach the node to
    be deleted.
  - Here the node is replaced with its inorder predecessor, p. p
    previously could not have a right child(it was the inorder
    predecessor). Attach the previously left-subtree subtree of p into
    the place p previously held.

Analysis

- Worst case(Figure ???)

  - If a BST has N nodes, in the worst case it may become completely
    unbalanced and all operations take time proportional to the height
    of the tree which is N.

- Average case
