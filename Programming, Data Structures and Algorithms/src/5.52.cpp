/*
 * 5.52.cpp
 *
 *  Created on: 14-May-2011
 *      Author: kempa
 */


/*
 * 5.52 Write a function that solves the knapsack problem using top-down
 *  dynamic programming, but using a recursive solution based on computing
 *  the optimal number of a particular item to include in the knapsack, based
 *   on (recursively) knowing the optimal way to pack the knapsack without that
 *    item.
 *
 */

#include<cstdlib>
#include<iostream>
using std::cout;
using std::endl;
#define MAX 25
#define NMAX 10
int *maxNum;
#define UNKNOWN -1
typedef struct
{
	int size;
} Item;

/*
 * return value is the maximum number of items that can be stashed in the
 * knapsack of capacity 'cap'
 */
int knap(int cap, Item* item, int N)
{
	int space, max = 0, n;
	if (maxNum[cap] != UNKNOWN)
		return maxNum[cap];

	for(int i = 0; i < N; i++)
	{
		if ((space = cap - item[i].size) >= 0)
			if ((n = knap(space, item, N) + 1) > max)
				max = n;
	}
	maxNum[cap] = max;
	return max;
}

int main()
{
	srand(time(NULL));

	int cap = rand() % MAX + 1;
	cap = 17;
	int N = rand() % NMAX + 1;
	N = 5;
	Item *item = new Item[N];
	maxNum = new int[cap + 1];

	for(int i = 0; i < N ; i++)
	{
		item[i].size = rand() % (2 *NMAX) + 1;
		maxNum[i] = UNKNOWN;
	}
	item[0].size = 3;
	item[1].size = 4;
	item[2].size = 7;
	item[3].size = 8;
	item[4].size = 9;

	for(int i = 0; i <=cap ; i++)
		maxNum[i] = UNKNOWN;

	cout << "capacity = " << cap << endl;
	cout << "maximum number of items = " << knap(cap, item, N) << endl;
	return 0;
}
