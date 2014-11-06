/*
 * freeAll.cpp
 *
 *  Created on: 01-Oct-2010
 *      Author: kempa
 *
 *  3.47 Write a program that frees the nodes in positions that are divisible
 *  by 5 in a linked list (the fifth, tenth, fifteenth, and so forth).
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


	int count = 0; // counts the no. of nodes visited and not the no. of links traversed
	Node head;
	for (head = x; x->next != head; x = x->next)
		if (++count == 4)
		{
			deleteNode(remove(x));
			if (x->next == head)
				break;
			count = 0;
		}

	cout << "List after removal of every 5th node : ";
	display(head);
	//cout << "No. of free nodes after deletion: " << freelistNum() << endl;

	return 0;
}

