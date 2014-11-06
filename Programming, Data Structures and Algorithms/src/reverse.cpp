/*
 * reverse.cpp
 *
 *  Created on: 29-Sep-2010
 *      Author: kempa
 *
 *    Implement a version of Program 3.10 that uses a head node.
 */

#include "HList.h"
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
		HList *a = new HList(items, length);

		cout << "Original List" << endl;
		a->display();

		a->reverse();
		cout << "Reversed List" << endl;
		a->display();
}

