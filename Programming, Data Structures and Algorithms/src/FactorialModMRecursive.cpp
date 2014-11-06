/*
 * FactorialModMRecursive.cpp
 *
 *  Created on: 18-Apr-2011
 *      Author: kempa
 */

/*
 * 5.2 Modify Program 5.1 to compute N! mod M, such that overflow
 *  is no longer an issue. Try running your program for M = 997 and
 *  N = 10^3, 10^4, 10^5, and 10^6, to get an indication of how your
 *  programming system handles deeply nested recursive calls.
 *
 *  5.3 Give the sequences of argument values that result when Program 5.2
 *  is invoked for each of the integers 1 through 9.
 */
#include<cmath>

#include<cstdlib>
#include<iostream>

using std::cout;
using std::endl;
using std::cerr;

int main(int argc, char *argv[])
{
	//long n = atoi(argv[1]);
	int m = 997;

	long fact(long, int);
	//cout << "(" << n << "!)mod " << M << " = ";
	//cout.flush(); // to ensure printing of above to the console, incase a segmentation fault is hit
	for (long i = 1000; i <= 100000; i *= 10)
		cout << fact(i, m) << endl;

	for (int i = 1; i <= 9; i++)
		cout << fact(i, m) << endl;
	return 0;
}

/*
 * for a sufficiently large n, I get a segmentation fault,
 * indicating running out of stack space of the process
 *
 */
long fact(long n, int m)
{
	cerr << "fact(" << n - 1 << ")\n";
	cerr.flush();
	if (n == 1)
		return 1;
	else
	{
		long result = n * fact(n - 1, m);
		if (result > m)
			return ((int) result % m);
		else
			return result;
	}
}
