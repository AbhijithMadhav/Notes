/*
 * GenerateBinarySearchTree.h
 *
 *  Created on: 21-May-2011
 *      Author: kempa
 */

#ifndef GENERATEBINARYSEARCHTREE_H_

#define GENERATEBINARYSEARCHTREE_H_

#include<cstddef>

#include<string>
using std::string;

#include<vector>
using std::vector;

#include"cpp_node.h"


/*
 * generates a binary tree by inserting the each of the items
 * below the existing tree
 */

template<class T>
node<T>* GenerateBinarySearchTree(vector<T> &items)
{
	node<T>* root = NULL;

	if (!items.empty())
	{
		root = new node<T>(items[0]);
		for (unsigned i = 1; i < items.size(); i++)
		{
			node<T> *t = new node<T>(items[i]);
			node<T> *cur = root, *prev = NULL;
			while (cur != NULL)
			{
				prev = cur;
				if (t->item < cur->item)
					cur = cur->l;
				else
					cur = cur->r;
			}
			if (t->item < prev->item)
				prev->l = t;
			else
				prev->r = t;
		}
	}
	return root;
}


#endif /* GENERATEBINARYSEARCHTREE_H_ */
