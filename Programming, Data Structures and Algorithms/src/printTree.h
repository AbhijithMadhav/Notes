/*
 * printTree.h
 *
 *  Created on: 04-Jun-2011
 *      Author: kempa
 */

#ifndef PRINTTREE_H_
#define PRINTTREE_H_
#include<iostream>
using std::cout;
using std::endl;

template<typename T>
void printnode(T x, int h)
{
	for (int i = 0; i < h; i++)
		cout << "  ";
	cout  << x << endl;
}

template<typename T>
void show(node<T> *t, int h)
{
	if (t == 0)
	{
		printnode('*', h);
		return;
	}
	show(t->r, h + 1);
	printnode(t->item, h);
	show(t->l, h + 1);
}

#endif /* PRINTTREE_H_ */
