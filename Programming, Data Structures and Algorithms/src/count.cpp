/*
 * 3.23.cpp
 *
 *  Created on: 20-Sep-2010
 *      Author: kempa
 */

#include<iostream>
#include<cstdlib>
#include<ctime>
#include<cstddef>
#include"CList.h"

#define SIZE 100

int main()
{
	  /* initialize random seed: */
    srand ( time(NULL) );

	int length = rand() % SIZE, items[SIZE];
	for (int i = 0; i < length ; i++)
		items[i] = rand();
	CList *a = new CList();
	a->create(items, length);
	std::cout << "This program counts the number of elements in a circular linked lists. The elements are are auto-generated before being inserted into a list" << std::endl;
	std::cout << "Circular linked list is" << std::endl;
	a->display();
	std::cout << std::endl;
	std::cout << "Calculated length of circular linked list: " << a->count() << std::endl;
	std::cout << "Actual length: " <<  length << std::endl;
}
