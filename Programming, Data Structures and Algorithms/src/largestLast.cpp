/*
 * largestLast.cpp
 *
 *  Created on: 24-Sep-2010
 *      Author: kempa
 *
 *   Write a function that moves the largest item on a given list
 *   to be the final node on the list.
 */

#include<iostream>
#include<cstdlib>
#include<ctime>

#include"List.h"

#define MAX_SIZE 10
#define MAX_ELEMENT 10

int main()
{
	using std::cout;
	using std::endl;

	/* Seed the random number generator */
    srand ( time(0) );

	int length = rand() % MAX_SIZE, items[MAX_SIZE];

	// Create random elements to be inserted into the c list
	for (int i = 0; i < length ; i++)
		items[i] = rand() % MAX_ELEMENT;

	// create a new list.
	List *a = new List(items, length);

	cout << "Random testing:" << endl;
	cout << "Contents of linear list before moving largest element to the end" << endl;
	a->display();
	a->largestLast();
	cout << "Contents of linear list after moving largest element to the end" << endl;
	a->display();

	return 0;
}

/* boundary testing conditions */
// largest element is the last element
// largest element is the first element
// empty list
// one element
