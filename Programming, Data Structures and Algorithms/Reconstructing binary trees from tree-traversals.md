Reconstructing binary trees from tree traversals

In general, a single tree traversal does not uniquely define the
structure of the tree. For example, for both the following trees, an
inorder traversal yields \[1,2,3,4,5,6\].

4 3

/ \\ / \\

2 5 2 5

/ \\ \\ / / \\

1 3 6 1 4 6

The same ambiguity is present for preorder and postorder traversals. The
preorder traversal for the first tree above is \[4,2,1,3,5,6\]. A
different tree with the same preorder traversal.

4

/ \\

2 1

/ \\

3 6

\\

5

Similarly, we can easily construct another tree whose postorder
traversal \[1,3,2,6,5,4\] matches that of the first tree above.

Unambiguous reconstruction of a tree from a preorder and a inorder
traversal

Can we unambiguously reconstruct a tree with preorder traversal

\[4,2,1,3,5,6\] if we fix the inorder traversal to be

\[1,2,3,4,5,6\]? Here is how we would do it, by example, on the

tree above.

Inorder : \[1,2,3,4,5,6\]

Preorder : \[4,2,1,3,5,6\]

From the preorder traversal, we know that 4 is at the root. The

rest of the preorder traversal breaks up as two segments,

corresponding to the preorder traversals of the left and the

right subtrees. From the position of 4 in the inorder traversal,

we know that \[1,2,3\] is the inorder traversal of the left subtree

and \[5,6\] is the inorder traversal of the right subtree. Since

the left subtree has three nodes, we can split the tail of the

preorder traversal after three values. Thus, we have identified

the root node and the subset of nodes in the left and right

subtrees and recursively broken up the reconstruction problem as

follows:

4

/ \\

Left subtree Right subtree

Inorder : \[1,2,3\] Inorder : \[5,6\]

Preorder: \[2,1,3\] Preorder: \[5,6\]

In simple words, a preorder traversal indicates the root of the tree by
the first element. The elements to the left and right of the root in the
inorder traversal form the subtrees. Applying this recursively we can
form the binray tree.

A postorder traversal indicates the root of the tree by the last
element. The elements to the left and right of the root in the inorder
traversal form the subtrees. Applying this recursively we can form the
binary tree

Unambiguous reconstruction of a binary tree not possible from a preorder
and post-order traversal

Is is possible to reconstruct a binary tree uniquely from its

preorder and postorder traversals? The following example shows

that this cannot be done in general:

1 and 1 both have preorder : \[1,2\]

/ \\ postorder : \[2,1\]

2 2

However, if we impose additional structure on binary trees---for

instance, no node can have a right child without having a left

child---preorder and postorder traversals together uniquely fix

the shape of a tree. Here is how we could do it, by example

Preorder : \[4,2,1,3,5,6\]

Postorder : \[1,3,2,6,5,4\]

4 is clearly the root. From the preorder traversal we know that

2 is the root of the left subtree and from the postorder

traversal we know that 5 is the root of the right subtree. This

information is sufficient to recursively breakup the problem as

follows:

4

/ \\

Preorder : \[2,1,3\] Preorder : \[5,6\]

Postorder: \[1,3,2\] Postorder: \[6,5\]

References

- <http://www.cmi.ac.in/~madhavan/courses/programming06/lecture12-21sep2006.txt>
