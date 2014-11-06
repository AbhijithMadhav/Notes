/*
 * count.cpp
 *
 *  Created on: 21-Sep-2010
 *      Author: kempa
 *
 *  Write a code fragment that determines the number of nodes
 *   that are between the nodes referenced by two given pointers
 *    x and t to nodes on a circular list.
 */

#include<iostream>
#include<cstdlib>
#include<ctime>
#include<cstddef>
#include"CList.h"

int main()
{
	/* Seed the random number generator */
    srand ( time(NULL) );

	int length = rand() % 100, items[100];

	// Create random elements to be inserted into the c list
	for (int i = 0; i < length ; i++)
		items[i] = rand();

	// create a new list. Insert
	CList *a = new CList();
	a->create(items, length);

	// Obtain any pointers to any two elements inn the c list
	int pos1, pos2;
	pos1 = rand() % length;
	pos2 = rand() % length;

	std::cout << "No. of nodes between position " << pos1 << " and position " << pos2 << ": " << a->count(a->getNode(pos1), a->getNode(pos2)) << std::endl;
	std::cout << "Circular linked list is" << std::endl;
		a->display();
	return 0;
}
