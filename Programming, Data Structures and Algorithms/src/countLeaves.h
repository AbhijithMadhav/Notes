/*
 * countLeaves.h
 *
 *  Created on: 02-Jun-2011
 *      Author: kempa
 */

#ifndef COUNTLEAVES_H_
#define COUNTLEAVES_H_
#include"cpp_node.h"
template<class T>
int nleaves(node<T> *root)
{
	if (!root->l && !root->r)
		return 1;
	else
	{
		int count = 0;
		if (root->l)
			count += nleaves(root->l);
		if (root->r)
			count += nleaves(root->r);
		return  count;
	}
}


#endif /* COUNTLEAVES_H_ */
