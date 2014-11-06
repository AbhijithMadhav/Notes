/*
 * constructTournamentTree.h
 *
 *  Created on: 04-Jun-2011
 *      Author: kempa
 */

#ifndef CONSTRUCTTOURNAMENTTREE_H_
#define CONSTRUCTTOURNAMENTTREE_H_

#include "node.h"
#include<vector>
using std::vector;

/*
 * constructs a tournament tree for the elements in a[]
 * returns a pointer to the root of the tree
 */
template<class T>
node<T>* constructTournamentTree(T a[], int l, int r)
{
	int m = (l + r) / 2;
	node<T>* x = new node<T>(a[m]);
	if (l == r)
		return x;
	x->l = constructTournamentTree(a, l, m);
	x->r = constructTournamentTree(a, m + 1, r);
	if (x->l->item > x->r->item)
		x->item = x->l->item;
	else
		x->item = x->r->item;
	return x;
}

#endif /* CONSTRUCTTOURNAMENTTREE_H_ */
