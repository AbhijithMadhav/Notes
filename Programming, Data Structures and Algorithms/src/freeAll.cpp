/*
 * freeAll.cpp
 *
 *  Created on: 01-Oct-2010
 *      Author: kempa
 *
 *  3.46 Write a program that frees (invokes delete with a pointer to) all the
 *  nodes on a given linked list.
 */

#include "list.h"
#include<iostream>

#define N 100

using std::cout;
using std::endl;
using list::Node;
using list::newNode;
using list::insert;
using list::construct;
using list::deleteNode;
using list::display;
using list::freelistNum;



int main()
{
	Node t, x;

	// a linear free-list is created
	construct(N);
	int i;

	// A circular list is created
	for (i = 2, x = newNode(1); i <= N; i++)
	{
		t = newNode(i);
		insert(x, t);
		x = t;
	}

	cout << "List: ";
	display(x);
	cout << "No. of free nodes: " << freelistNum() << endl;

	// The whole point of the program
	while (x != x->next)
		deleteNode(remove(x));
	deleteNode(remove(x));


	cout << "No. of free nodes after deletion: " << freelistNum() << endl;

	return 0;
}

