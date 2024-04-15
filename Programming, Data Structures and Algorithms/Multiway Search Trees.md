2-3-4 trees

- Search trees
- Not binary trees
- Mutliway search trees

Multi-way search trees

- Order of node n – contains n children and n – 1 items

A red-black implementation of a 2-3-4 tree helps retain the search
algorithm of the normal binary search tree

Insertion

If there is insufficient space in a leaf node, split it

Promote a key, the greatest of the left node or the least of the right
node to the parent and fix up links

Insertion with preemptive split

- Can't this be used if the min degree is odd?

Deletion

- No problem if key to be deleted is in the leaf with atleast 2 keys

- If the key to be deleted is an internal node we swap it with its
  predecessor(which is in the leaf) and then delete it

  - If after deleting a node becomes empty we borrow a key from one of
    its immediate sibling

    - If that sibling has only one key then we merge the nodes. The
      corresponding key in the parent of these two nodes moves down into
      the merged node
    - Moving a key from the parent node is akin to deletion in the
      parent node. The procedure is the same as that for the leaf node.
      Can lead to a cascade

- Borrow

- If unsuccessful merge
