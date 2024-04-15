AVL Trees

[Implementation](src/AVL.java)

- AVL trees are binary search trees whose left and right subtrees of any
  node differ in height by a maximum of one level.
- AVL trees are self balancing. If at any time the height of any
  subtrees of a node differ by more than one, re-balancing is done to
  restore this property. Re-balancing is achieved by the means of one or
  more rotations
- AVL trees as more rigidly balanced than red-black trees and are hence
  slightly faster then red-black trees for lookups
- AVL trees are not weight balanced, i.e., that is sibling nodes can
  have hugely differing number of descendent's.

Operations

- Searching

  - O(lg N). Just like in unbalanced search trees

- Insertion

  - Search for the position to insert and insert.
  - On the way(unwinding recursion) check if the balance factor of each
    node is -1, 0 or +1. If it isn't re-balancing must be done by
    rotating(single or double rotations).

- Deletion

  - Search for the element to delete.
  - Replace it with its in-order predecessor or in-order successor.
    Re-balance

Tree balancing

<img src="Pictures/100002010000017700000258ACE899FA.png"
style="width:3.9063in;height:6.25in" />
