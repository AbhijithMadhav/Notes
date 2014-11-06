/*
 * 	5.44 Write a function that uses bottom-up dynamic programming to compute
 * 	the value of CN defined by the recurrence
 *
 */
#include<cmath>
#include<iostream>
#include<cstdlib>
using std::cout;
using std::endl;
#define MAX 100

double *c;
double C(unsigned n)
{
	c = new double[n + 1];
	c[0] = 1.0;

	for (unsigned i = 1; i <= n; i++)
	{
		double sum = 0;
		for (unsigned k = 1; k <= i; k++)
			sum += c[k - 1] + c[i - k];
		c[i] = i + (sum / i);
	}
	return c[n];
}

int main()
{
	srand(time(NULL));
	int n = rand() % MAX;
	//cout << "C(" << n << ") = " << C(n) << endl;
	for (int n = 0; n <= 8; n++)
		cout << "C(" << n << ") = " << C(n) << endl;

	return 0;
}
