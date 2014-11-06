/*
 * conditionalDeleteCreate.cpp
 *
 *  Created on: 28-Sep-2010
 *      Author: kempa
 *
 *  3.39 Solve Exercise 3.38, but make copies of the nodes that pass the test
 *  and return a link to a list containing those nodes, in the order that
 *  they appear in the original list.
 */

#include "List.h"
#include<iostream>
#include<cstdlib>
#include<ctime>

#define LENGTH 10
#define MAX_ITEM_VAL 20

using std::cout;
using std::endl;


int isGreater(lnk t)
{
	if (t != 0 && t->item > 9)
		return 1;
	return 0;
}


int main()
{
	/* Seed the random number generator */
    srand ( time(NULL) );

	int length = rand() % LENGTH, items[LENGTH];

	// Create random elements to be inserted into the c list
	for (int i = 0; i < length ; i++)
		items[i] = rand() % MAX_ITEM_VAL;

	// create a new list. Insert
	List *a = new List(items, length);

	cout << "Original List" << endl;
	a->display();

    List *b = a->removeCreate(&isGreater);
	cout << "List after removal : " << endl;
	a->display();
	cout << "New List : " << endl;
	b->display();

	return 0;
}


