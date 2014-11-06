/*
 * 5.16.cpp
 *
 *  Created on: 22-Apr-2011
 *      Author: kempa
 *
 *  5.16 Write a recursive program that finds the maximum element in an array,
 *  based on comparing the first element in the array against the maximum
 *  element in the rest of the array (computed recursively).
 */

#include<cstdlib>
#include<iostream>
using std::cout;
using std::endl;
#define MAX 10
int max(int a[], int first, int size)
{
	if (first == size - 1)
		return a[first];
	int y = max(a, first + 1, size);
	if (a[first] > y)
		return a[first];
	else
		return y;
}


int main()
{
	srand(time(NULL));
	int a[MAX];
	int size = rand() % MAX;
	cout << "Array contents\n";
	for(int i = 0; i < size; i++)
	{
		a[i] = rand() % MAX;
		cout << a[i] << " ";
	}
	cout << endl;
	cout << "Max = " << max(a, 0, size-1) << endl;

}
