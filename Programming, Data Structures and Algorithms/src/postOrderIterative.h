/*
 * postOrderIterative.h
 *
 *  Created on: 30-May-2011
 *      Author: kempa
 */

#ifndef POSTORDERITERATIVE_H_
#define POSTORDERITERATIVE_H_
#include "node.h"

#include<string>
using std::string;

#include<stack>
using std::stack;

#include<iostream>
using std::cout;
using std::endl;

template<class T>
vector<string> postOrder(node<T> *root)
{
	stack<node<T>*> s;
	node<T> *prev = NULL;
	vector<string> t;

	/*
	 * Why is 'prev' needed?
	 *  In post-order traversal the unvisited parent node is encountered twice
	 * on the way up from the tree. Once after the left subtree has been
	 * visited and the second time when the right subtree has been visited.
	 *
	 * In the first instance the traversal must continue with a visit of the
	 * right subtree of the unvisited parent. In the second instance the
	 * traversal must continue with the visit of the parent itself.
	 *
	 * It is not possible to distinguish this next move when we come across the
	 * parent without knowing which child node was traversed previously. Hence
	 * the algorithm below uses 'prev' to do this job
	 *
	 * http://www.ihas1337code.com/2010/10/binary-tree-post-order-traversal.html
	 *
	 *
	 * How should the elements in the stack be interpreted?
	 *  An element is pushed into the stack when it must be processed in later
	 *  iterations, i.e. it is a parent whose children subtrees are unvisited
	 */
	s.push(root);
	while (!s.empty())
	{
		node<T> *top = s.top();
		if (!prev || prev->l == top || prev->r == top)
		{
			if (top->l)
				s.push(top->l);
			else if (top->r)
				s.push(top->r);

		}
		else if (prev == top->l)
		{
			if (top->r)
				s.push(top->r);
		}
		else
		{
			visit(top, t);
			s.pop();
		}
		prev = top;
	}
	return t;
}


#endif /* POSTORDERITERATIVE_H_ */
