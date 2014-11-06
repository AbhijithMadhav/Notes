/*
 * 5.37.cpp
 *
 *  Created on: 06-May-2011
 *      Author: kempa
 *
 *   5.37 Write a function that computes FibN mod M, using only a constant
 *   amount of space for intermediate calculations.
 */

#include<iostream>
#include<cstdlib>
#include<climits>
#include<cstddef>
using std::cout;
using std::endl;
#define MAX 50

long long fib(int n)
{
	long long p = 0;
	long long q = 1;

	for (int i = 2; i <= n; i++)
	{
		long long t = q;
		q = (p + q );
		p = t;
	}
	if (n <= 0)
		return p;
	else
		return q;
}

int main()
{
	srand(time(NULL));
	int n = rand() % MAX;
	n = 103;
	cout << "Fib(" << n << ") " << " = " << fib(n) << endl;
	return 0;
}
