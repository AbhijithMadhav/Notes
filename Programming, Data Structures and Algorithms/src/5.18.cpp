/*
 * 5.18.cpp
 *
 *  Created on: 24-Apr-2011
 *      Author: kempa
 */
#include<cstdlib>
#include<cmath>
#include<iostream>
using std::cout;
using std::endl;
#define MAX 100
typedef int Item;

Item max(Item a[], int l, int r)
{
	if (l == r)
		return a[l];

	// size = r - l + 1, because r and l are positions starting from 0
	double exponent = ceil(log((double)(r - l + 1))/log(2.0)) - 1;
	int pSize = (int)pow(2.0, exponent);

	// r = l + psize - 1 as r is a position starting from 0
	Item u = max(a, l, l + pSize - 1);
	Item v = max(a, l + pSize, r);

	if (u > v)
		return u;
	else
		return v;
}

int main()
{
	srand(time(NULL));
	int a[MAX];
	int size = 1 + (rand() % MAX);
	cout << "Array contents\n";
	for(int i = 0; i < size; i++)
	{
		a[i] = rand() % MAX;
		cout << a[i] << " ";
	}
	cout << endl;
	cout << "Max = " << max(a, 0, size - 1) << endl;

}
