/*
 * 5.22.cpp
 *
 *  Created on: 25-Apr-2011
 *      Author: kempa
 */

/*
 * 5.22 Write a recursive program that computes the length of the ith mark in a
 *  ruler with 2n–1 marks.
 */


#include<iostream>
using std::cout;
using std::endl;

int numZeros(int i)
{
	if ((i >> 1) % 2)
		return 1;
	return (numZeros(i >> 1) + 1);
}

// Height of the i'th mark is equal to the number of 0's in 2i
int main()
{
	for (int i = 1; i < 32 ; i++)
		cout << "Height of " << i << "th mark = " << numZeros(2*i) <<  endl;
	return 0;
}
