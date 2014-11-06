/*
 * preOrder.h
 *
 *  Created on: 30-May-2011
 *      Author: kempa
 */

#ifndef PREORDER_H_
#define PREORDER_H_
#include "generateBinarySearchTree.h"

#include<vector>
using std::vector;
#include<string>
using std::string;

#include<stack>
using std::stack;

#include<iostream>
using std::cout;
using std::endl;

template<class T>
vector<string> preOrder(node<T> *root)
{
	stack<node<T>*> s;
	s.push(root);
	vector<string> t;
	while (!s.empty())
	{
		node<T> *cur = s.top();
		visit(cur, t);
		s.pop();
		if (cur->r)
			s.push(cur->r);
		if (cur->l)
			s.push(cur->l);
	}
	return t;
}


#endif /* PREORDER_H_ */
