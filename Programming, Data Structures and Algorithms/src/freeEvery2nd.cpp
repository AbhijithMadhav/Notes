/*
 * freeAll.cpp
 *
 *  Created on: 01-Oct-2010
 *      Author: kempa
 *
 *  3.48 Write a program that frees the nodes in even positions in a linked
 *   list (the second, fourth, sixth, and so forth).
 */

#include "list.h"
#include<iostream>
#include<cstdlib>
#include<ctime>
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

    srand ( time(NULL) );

	int length = rand() % N;

	// a linear free-list is created
	construct(length);
	int i;

	// A circular list is created
	for (i = 2, x = newNode(1); i <= length; i++)
	{
		t = newNode(i);
		insert(x, t);
		x = t;
	}

	cout << "List: ";
	x = x->next; // just so that the first node is displayed
	display(x);


	//int count = 0; // counts the no. of nodes visited and not the no. of links traversed
	Node head;
	for (head = x; x->next != head; x = x->next)
	{
			deleteNode(remove(x));
			if (x->next == head)
				break;
	}


	cout << "List after removal of every other node : ";
	display(head);
	//cout << "No. of free nodes after deletion: " << freelistNum() << endl;

	return 0;
}

