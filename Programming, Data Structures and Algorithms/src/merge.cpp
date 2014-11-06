/*
 * merge.cpp
 *
 *  Created on: 22-Sep-2010
 *      Author: kempa
 *
 *  Write a code fragment that, given pointers x and t to two disjoint
 *  circular lists, inserts the list pointed to by t into the list
 *  pointed to by x, at the point following x.
 */

#define SIZE 100

#include<iostream>
#include<cstdlib>
#include<ctime>
#include"CList.h"

int main()
{
	// Seed the random number generator
    srand ( time(NULL) );

	int length1 = rand() % SIZE, length2 = rand() % SIZE, items1[100], items2[SIZE];

	// Create random elements to be inserted into the c list
	for (int i = 0; i < length1 ; i++)
		items1[i] = rand();
	for (int i = 0; i < length2 ; i++)
		items2[i] = rand();

	// create a new list. Insert
	CList *l1 = new CList(), *l2 = new CList();
	l1->create(items1, length1);
	l2->create(items2, length2);

	std::cout << "List l1 : " ;
	l1->display();
	std::cout << "List l2 : " ;
	l2->display();

	// Merge
	l1->merge(l2);
	std::cout << "l1 after merge : ";
	l1->display();
	std::cout << "l2 after merge : ";
	l2->display();

	return 0;
}
