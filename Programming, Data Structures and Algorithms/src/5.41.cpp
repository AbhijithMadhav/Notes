/*
 * 5.41.cpp
 *
 *  Created on: 08-May-2011
 *      Author: kempa
 *
 *  5.41 Write a function that uses top-down dynamic programming to solve
 *  Exercise 5.40.
 *  5.43 Draw a plot of N versus the number of recursive calls that your
 *  function from Exercise 5.41 makes to compute PN, for 0 N 1024. (For the
 *  purposes of this calculation, start your program from scratch for each N.)
 */

#include<cmath>
#include<iostream>
#include<cstdlib>
#include<climits>
using std::cout;
using std::endl;
#define MAX 100
#define UNKNOWN INT_MAX
int *p;
int count = 0;

int P(unsigned n)
{
	if (p[n] == UNKNOWN)
	{
		if (n <= 1)
			p[n] = n;
		else
		{
			count++;
			int flr = floor(n / 2.0);
			p[n] = flr + P(flr) + P(ceil(n / 2.0));
		}
	}
	return p[n];
}

int main()
{
	srand(time(NULL));
	/*unsigned n = rand() % MAX;
	p = new int[n+1];
	for(unsigned j = 0; j <= n; j++)
			p[j] = UNKNOWN;*/
	for (unsigned i = 0; i <= 1024; i++)
	{
		p = new int[i + 1];
		for(unsigned j = 0; j <= i; j++)
			p[j] = UNKNOWN;

		count = 0;
		P(i);
		cout << i << " " << count << endl;
		delete p;
	}
	//cout << "n = " << n << ", Pn = " << P(n);
	return 0;
}
