/*
 * josephus.cpp
 *
 *  Created on: 29-Sep-2010
 *      Author: kempa
 *
 *   3.42 Implement a version of Program 3.9 that uses a head node.
 */

#include <iostream>
#include <cstdlib>
#include "CHList.h"
#include<cstddef>
#define N 1000

using std::cout;
using std::endl;
int main()
{
	/* Seed the random number generator */
    srand ( time(NULL) );

    int n = rand()%N , m = rand() % N;

    int items[N];
	// Create random elements to be inserted into the c list
	for (int i = 0; i < n ; i++)
		items[i] = i + 1;

	// create a new list. Insert
	CHList *a = new CHList(items, n);

	cout << "Number of people, n : " << n << endl;
	cout << "Skip Position, m : " << m << endl;
	a->josephus(m, n);

	return 0;

}
