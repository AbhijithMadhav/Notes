/*
 * inOrderIterative.h
 *
 *  Created on: 30-May-2011
 *      Author: kempa
 */

#ifndef INORDERITERATIVE_H_
#define INORDERITERATIVE_H_
#include "cpp_node.h"
#include "visit.h"
#include<stack>
using std::stack;

#include<iostream>
using std::cout;
using std::endl;

#include<string>
using std::string;



template<class T>
vector<string> inOrder(node<T> *root)
{
	stack<node<T>*> s;
	node<T>* cur = root;
	vector<string> t;

	/* 1. How should the elements in the stack be interpreted?
	 *  Elements in the stack are nodes with unvisited root and right subtrees
	 *
	 * 2. When is an element pushed into a stack?
	 *  When going to visit it's left subtree
	 *
	 * 3. What is 'cur'?
	 *   'cur' points to the node which is processed in the current iteration.
	 *   The processing is, deciding on the node to be processed in the next
	 *   iteration and/or visiting the node also.
	 *
	 *   'cur' moves along the tree in-order. It will become 'NULL'
	 *   when it tries to move onto an empty right sub-tree.
	 *   Course correction needs to be done. The top of the stack contains the
	 *   immediately upper node which contains an un-traversed root and an
	 *   un-traversed right sub-tree. This is popped and the traversal
	 *   continues
	 */
	while (cur || !s.empty())
	{
		if (cur)
		{
			if (cur->l) // if there is a left sub-tree
			{
				s.push(cur); // save the current node
				cur = cur->l; // go to the left subtree in the next iteration
				// Note: cur cannot become null here
			}
			else // if there is no left sub-tree to visit
			{
				visit(cur, t); // visit the parent
				cur = cur->r; // go to the right subtree in the next iteration
			}
		}
		else
		{// right sub-tree is empty
		 // => the corresponding left sub-tree and parent have been visited
		 // => traversal should go one level up the tree and continue
			node<T> *parent = s.top();
			s.pop();
			visit(parent, t);
			cur = parent->r;
		}
	}
	return t;
}


#endif /* INORDERITERATIVE_H_ */
