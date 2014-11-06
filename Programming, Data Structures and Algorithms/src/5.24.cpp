/*
 * 5.24.cpp
 *
 *  Created on: 25-Apr-2011
 *      Author: kempa
 */

/*
 * 5.24 Write a program that produces a solution to the towers of Hanoi
 * problem by filling in an array that holds all the moves, as in Program 5.9.
 *
 */

#include<iostream>
#include<cmath>
using std::cout;
using std::endl;

void hanoi(int a[], int numDisks)
{
	int nMoves = (int) pow(2, numDisks) - 1;
	for (int diskNum= 1, j = 1; diskNum<= numDisks; j += j, diskNum++)
		for (int i = 0; j + i <= nMoves; i += j + j)
			if (diskNum% 2)
				a[j + i] = diskNum;
			else
				a[j + i] = -diskNum;
}

int main()
{
	int a[2000];
	int numDisks = 10;
	hanoi(a, numDisks);
	int nMoves = (int) pow(2, numDisks) - 1;

	for (int i = 1; i < nMoves; i++)
		cout << a[i] << " ";
	cout << endl;
	return 0;
}
