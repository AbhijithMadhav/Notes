/*
 * smallestFirst.cpp
 *
 *  Created on: 27-Sep-2010
 *      Author: kempa
 *
 *       Write a function that moves the smallest item on a given list
 *       to be the first node on the list.
 */

#include<iostream>
#include<cstdlib>
#include<ctime>

#include"List2.h"

#define MAX_LENGTH 10
#define MAX_ELEMENT 10

int main()
{
	using std::cout;
	using std::endl;

	/* Seed the random number generator */
    srand ( time(NULL) );
	int length = rand() % MAX_LENGTH, items[MAX_LENGTH];

	// Create random elements to be inserted into the c list
	for (int i = 0; i < length ; i++)
		items[i] = rand() % MAX_ELEMENT;

	// create a new list.
	List *a = new List(items, length);

	cout << "Random testing: " <<endl;
	cout << "Contents of linear list before moving smallest element to the start" << endl;
	a->display();
	a->smallestFirst();
	cout << "Contents of linear list after moving smallest element to the start" << endl;
	a->display();

	return 0;
}

/* boundary testing conditions */
// smallest element is the last element
// smallest element is the first element
// empty list
// one element
