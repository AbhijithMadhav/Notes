/*
 * insertionSort.cpp
 *
 *  Created on: 28-Sep-2010
 *      Author: kempa
 *
 *  3.41 Implement a version of Program 3.11 that does not use head nodes.
 */

#include "List.h"
#include<iostream>
#include<cstdlib>
#include<ctime>

#define LENGTH 10
#define MAX_ITEM_VAL 20

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

    a->insertionSort();

    cout << "List after insertion sort" << endl;
    a->display();

    return 0;
}
