/*
 * FactorialModMRecursive.cpp
 *
 *  Created on: 18-Apr-2011
 *      Author: kempa
 */

/*
 * 5.2 Modify Program 5.1 to compute N! mod M, such that overflow
 *  is no longer an issue. Try running your program for M = 997 and
 *  N = 103, 104, 105, and 106, to get an indication of how your
 *  programming system handles deeply nested recursive calls.
 */
#include<cmath>
#include<cstdlib>
#include<iostream>

using std::cout;
using std::endl;

int main()
{
	srand(time(NULL));

	long n = rand();
	double lg_fact(long);
	cout << "log(" << n << "!) = ";
	cout.flush(); // to ensure printing of above to the console, incase a segmentation fault is hit
	cout << lg_fact(n) << endl;
	return 0;
}

/*
 * for a sufficiently large n, I get a segmentation fault,
 * indicating running out of stack space of the process
 *
 */
double lg_fact(long n)
{
	if (n == 1)
		return 0;
	return (log((double) n) + lg_fact(n - 1));
}


