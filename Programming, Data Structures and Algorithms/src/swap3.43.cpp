/*
 * swap.cpp
 *
 *  Created on: 28-Sep-2010
 *      Author: kempa
 *
 *  3.43 Implement a function that exchanges two given nodes on a doubly
 *  linked list.
 */

#include<iostream>
#include<cstdlib>
#include<ctime>
#include<cstddef>
#include"DList.h"

#define LENGTH 10
#define MAX_ITEM_VAL 999

using std::cout;
using std::endl;


int main()
{
	/* Seed the random number generator */
    srand ( time(NULL) );

	int length = rand() % LENGTH, items[LENGTH];

	// Create random elements to be inserted into the c list
	for (int i = 0; i < length ; i++)
		items[i] = rand() % MAX_ITEM_VAL;

	// create a new list. Insert
	DList *a = new DList(items, length);

	// Obtain any pointers to any two elements inn the c list
	int pos1, pos2;
	pos1 = rand() % length;
	pos2 = rand() % length;

	cout << "Random testing:" << endl;
	cout << "DList before swap : " << endl;
	a->display();
	cout << "Nodes to be swapped : " << a->getByPosition(pos1)->item << " and " << a->getByPosition(pos2)->item << endl;

	if (pos1 < pos2)
		a->swap(a->getByPosition(pos1), a->getByPosition(pos2));
	else
		a->swap(a->getByPosition(pos2), a->getByPosition(pos1));
	cout << "DList after swap : " << endl;
	a->display();

	return 0;
}


