/*
 * 5.45.cpp
 *
 *  Created on: 08-May-2011
 *      Author: kempa
 *
 *  5.45 Write a function that uses top-down dynamic programming to solve
 *  Exercise 5.44.
 *
 *  5.47 Draw a plot of N versus the number of recursive calls that your
 *  function from Exercise 5.45 makes to compute CN, for 0 N 1024. (For the
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
double *c;
int count = 0;

double C(unsigned n)
{
	if (c[n] == UNKNOWN)
	{
		if (n == 0)
			c[n] = 1.00;
		else
		{
			count++;
			double sum = 0;
			for (unsigned k = 1; k <= n; k++)
				sum += C(k - 1) + C(n - k);
			c[n] = n + sum/n;
		}
	}
	return c[n];
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
		c = new double[i + 1];
		for(unsigned j = 0; j <= i; j++)
			c[j] = UNKNOWN;

		count = 0;
		C(i);
		cout << i << " " << count << endl;
		delete c;
	}
	//cout << "n = " << n << ", Pn = " << P(n);
	return 0;
}
