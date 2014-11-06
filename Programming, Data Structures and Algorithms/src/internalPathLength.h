/*
 * internalPathLength.h
 *
 *  Created on: 04-Jun-2011
 *      Author: kempa
 */

#ifndef INTERNALPATHLENGTH_H_
#define INTERNALPATHLENGTH_H_
#include"cpp_node.h"
#include <iostream>
/*
 * return the internal path length of
 */
template<class T>
int internalPathLength(node<T> *root, int level)
{
	// Internal path length = level of the root +
	//                        internal path length of the left subtree +
	//                        internal path length of the right subtree

	int ipl = level; // level of  the root
	if (root) // if the tree exists
	{
		if (root->l) // if the left subtree exists
			if (root->l->l || root->l->r) // if the left subtree is not a single external node
				ipl += internalPathLength(root->l, level + 1); // + internal path length of the left subtree


		if (root->r) // if the right subtree exists
			if (root->r->l || root->r->r) // if the right subtree is not a single external node
				ipl += internalPathLength(root->r, level + 1); // + internal path length of the right subtree
	}
	return ipl;

}
#endif /* INTERNALPATHLENGTH_H_ */
