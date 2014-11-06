/*
 * removeFromTournament.h
 *
 *  Created on: 10-Jun-2011
 *      Author: kempa
 */

#ifndef REMOVEFROMTOURNAMENT_H_
#define REMOVEFROMTOURNAMENT_H_

/*
 * deletes all leaf nodes with value equal to 'item'
 * returns the root pointer of the modified tree
 *
 * A post-order kind of algorithm
 */
template<typename T>
node<T>* removeFromTournament(node<T> *root, T item)
{
	// remove appropriate leaf nodes in the right and left subtrees
	if (root->l)
		root->l = removeFromTournament(root->l, item);
	if (root->r)
		root->r = removeFromTournament(root->r, item);

	/*
	 * After removal of the offending leaf and nodes with the same value as the
	 *  leaf, I could be left with
	 *   1. no subtrees
	 *   2. both subtrees
	 *   3. only one subtree
	 */

	if (!root->l && !root->r) // 1. no subtrees
	{
		if (root->item == item)
		{
			delete root; // delete it
			root = NULL;
		}
	}
	else if (root->l && root->r) // 2. both subtrees
	{
		if (root->item == item) // parent has the same value of the deleted node
		{
			// parent should be the greater of its left and right subchild
			root->item = root->l->item;
			if (root->item < root->r->item)
				root->item = root->r->item;
		}
	}
	else // node with a single subtree
	{
		// The missing subtree not only contained the deleted node. but also it
		//  was a subtree that contained a single leaf
		// Need to delete the root and insert the remaining child as the new root
		if (root->l)
		{
			root->item = root->l->item;
			delete root->l;
			root->l = NULL;
		}
		if (root->r)
		{
			root->item = root->r->item;
			delete root->r;
			root->r = NULL;
		}
	}
	return root;
}

#endif /* REMOVEFROMTOURNAMENT_H_ */
