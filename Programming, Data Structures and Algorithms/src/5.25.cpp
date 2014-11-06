/*
 * 5.25.cpp
 *
 *  Created on: 26-Apr-2011
 *      Author: kempa
 *
 *  5.25 Write a recursive program that fills in an n-by-2n array with 0s and
 *  1s such that the array represents all the n-bit binary numbers, as
 *  depicted in Figure 5.9.
 */

#include<iostream>
#include<cstdlib>
#include<cmath>
using std::cout;
using std::endl;

/*
 * Generate binary numbers spanning n digits in 'a' starting from 'rnum'
 * (row number)
 */
void GenerateBinary(int n, int(&a)[1024][1024], int rnum)
{
	// number of binary numbers generated when n digits are used
	int nbin = (int) pow(2.0, (double) n);

	if (n == 1) // base case
		for (int i = rnum, digit = 0; i < rnum + nbin; i++)
		{
			a[i][n] = digit;
			digit = (digit + 1) % 2; // Flip binary digit
		}
	else
	{
		// Generate binary numbers spanning n - 1 digits
		GenerateBinary(n - 1, a, rnum);
		// nbin/2 binary numbers are generated

		//prepend these nbin/2 numbers with '0' in the n'th digit
		for (int i = rnum; i < rnum + nbin / 2; i++)
			a[i][n] = 0;

		// generate binary numbers spanning n - 1 digits
		GenerateBinary(n - 1, a, rnum + nbin / 2);
		//prepend these numbers with '1' in the n'th digit
		for (int i = rnum + nbin / 2; i < rnum + nbin; i++)
			a[i][n] = 1;
	}
}

int main()
{
	srand(time(NULL));
	int n = 1 + rand() % 6;
	int r = (int) pow(2.0, (double) n);

	int a[1024][1024];
	GenerateBinary(n, a, 0);

	cout << "Number of digits  = " << n << endl;
	for (int i = 0; i < r; i++)
	{
		for (int j = n; j >= 1; j--)
			cout << a[i][j];
		cout << endl;
	}

	return 0;
}
