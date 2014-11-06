/*
 * swap.cpp
 *
 *  Created on: 27-Sep-2010
 *      Author: kempa
 */


#include<iostream>
#include<cstdlib>
#include<ctime>
#include"List.h"

#define LENGTH 5
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

	// Obtain any pointers to any two elements inn the c list
	int pos1, pos2;
	pos1 = rand() % length;
	pos2 = rand() % length;

	cout << "Random testing:" << endl;
	cout << "List before swap : " << endl;
	a->display();
	cout << "Nodes to be swapped : " << a->getByPosition(pos1)->item << " and " << a->getByPosition(pos2)->item << endl;

	if (pos1 < pos2)
		a->swap(a->getByPosition(pos1 - 1), a->getByPosition(pos2 - 1));
	else
		a->swap(a->getByPosition(pos2 - 1), a->getByPosition(pos1 - 1));
	cout << "List after swap : " << endl;
	a->display();

	return 0;
}
