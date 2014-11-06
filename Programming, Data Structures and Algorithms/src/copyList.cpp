/*
 * copyList.cpp
 *
 *  Created on: 27-Sep-2010
 *      Author: kempa
 *
 *   Write a function that takes a link to a list as
 *   argument and returns a link to a copy of the list
 *   (a new list that contains the same items, in the same order).
 */


#include<iostream>
#include<cstdlib>
#include<ctime>
#include"List.h"

#define LENGTH 10
#define MAX_ITEM_VAL 99

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
	List *a = new List(items, length);

	cout << "Original List" << endl;
	a->display();

	List *b = new List(*a);
	cout << "Copy of the original" << endl;
	b->display();

	return 0;
}
