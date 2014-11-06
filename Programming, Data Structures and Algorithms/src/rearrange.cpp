/*
 * rearrange.cpp
 *
 *  Created on: 27-Sep-2010
 *      Author: kempa
 *
 *      Write a function that rearranges a linked list to put the
 *      nodes in even positions after the nodes in odd positions in
 *      the list, preserving the relative order of both the evens and
 *      the odds.
 */

#include<iostream>
#include<cstdlib>
#include<ctime>

#include"List.h"

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
	cout << "List before rearranging:" << endl;
	a->display();

	a->rearrange();
	cout << "List after rearranging:" << endl;
	a->display();

	return 0;
}

/* boundary testing conditions */
// Empty list
// list with one item
// list with two items
