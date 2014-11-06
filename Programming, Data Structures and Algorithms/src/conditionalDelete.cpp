/*
 * conditionalDelete.cpp
 *
 *  Created on: 28-Sep-2010
 *      Author: kempa
 *
 *  Write a function that takes two arguments—a link to a list and a function
 *  that takes a link as argument—and removes all items on the given list for
 *  which the function returns a nonzero value.
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

	a->remove(&isGreater);
	cout << "List after removal : " << endl;
	a->display();

	return 0;
}
