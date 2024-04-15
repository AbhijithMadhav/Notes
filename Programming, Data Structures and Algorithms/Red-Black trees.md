Red Black trees

Red nodes must have black children

i.e., Why can’t red nodes be made the ‘leader’(mid element) of a 4 node
in a red-black(2-3-4) tree?

If red nodes are allowed to be the 2nd element of a 4-node, they must be
allowed to have red children which might become the leftmost and/or
rightmost element of that 4-node.

Now that red nodes can have other red nodes as children, it will not be
possible to distinguish the boundary of a 4-node if there are say more
than 2 red nodes strung together in a parent child relationship.

Mandating that red nodes have black children confines the red nodes to
be either the leftmost or rightmost element of a 4-node in a red-black
tree.
