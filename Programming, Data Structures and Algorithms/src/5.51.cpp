/*
 * 5.51.cpp
 *
 *  Created on: 13-May-2011
 *      Author: kempa
 */
#include<cstdlib>
#include<iostream>
using std::cout;
using std::endl;
#define MAX 25
#define NMAX 10
int *maxValue;
#define UNKNOWN -1
typedef struct
{
	int size;
	int value;
} Item;

int knap(int cap, Item *item, int N)
{
	int space, max, t;
	if (maxValue[cap] != UNKNOWN)
		return maxValue[cap];
	max = 0;
	for (int i = 0; i < N; i++)
		if ((space = cap - item[i].size) >= 0)
			if ((t = knap(space, item, N) + item[i].value) > max)
				max = t;
	maxValue[cap] = max;
	return max;
}

int bottomsUpKnap(int cap, Item *item, int N)
{
	maxValue = new int[cap + 1];
	for(int i = 0; i <= cap; i++)
	{
		maxValue[i] = UNKNOWN;
		knap(i, item, N);
		//cout << maxValue[i] << endl;
	}
	return maxValue[cap];
}



int main()
{
	srand(time(NULL));

	int cap = rand() % MAX + 1;
	cap = 17;
	int N = rand() % NMAX + 1;
	N = 5;
	//Item a[10];
	//int (&i)[10] = a;
	Item *item = new Item[N];
	//Item (&item)[N] = a;
	for(int i = 0; i < N ; i++)
	{
		item[i].size = rand() % (2 *NMAX) + 1;
		item[i].value = rand() % (4 * NMAX) + 1;
	}
	item[0].size = 3; item[0].value = 4;
	item[1].size = 4; item[1].value = 5;
	item[2].size = 7; item[2].value = 10;
	item[3].size = 8; item[3].value = 11;
	item[4].size = 9; item[4].value = 13;

	cout << "capacity = " << cap << endl;
	cout << "maximum value of items = " << bottomsUpKnap(cap, item, N) << endl;
	return 0;
}
