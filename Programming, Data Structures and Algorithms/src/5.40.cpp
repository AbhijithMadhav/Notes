/*
 * 5.40.cpp
 *
 *  Created on: 07-May-2011
 *      Author: kempa
 *
 *  Write a function that uses bottom-up dynamic programming to compute the
 *   value of PN defined by the recurrence
 *   Pn = floor(n/2) + P floor(n/2) + P Ceil(n/2)
 *   Draw a plot of N versus PN – N lg N/2 for 0 N 1024.
 */
#include<cmath>
#include<iostream>
#include<cstdlib>
using std::cout;
using std::endl;
#define MAX 100

int bottomsUpRecurrance(int n, int *p) {
	p[0] = 0;
	p[1] = 1;
	for (int i = 2; i <= n; i++) {
		int flr = floor(i / 2.0);
		p[i] = flr + p[flr] + p[(int) ceil(i / 2.0)];
	}
	return p[n];
}

int main() {
	srand(time(NULL));
	int n = rand() % MAX;
	n = 1024;
	int *p = new int[n + 1];
	bottomsUpRecurrance(n, p);
	for (int i = 0; i <= n; i++)
		//cout << "bottomsUpRecurrance(" << i << ") " << " = " << p[i] << " --- "
			//	<< p[i] - i * (log((double) i) / log(2.0) - 1) << endl;
		cout << i << " " << p[i] /*- i * (log((double) i) / log(2.0) - 1)*/ << endl;
	//cout << 0*log(0.0);

	return 0;
}
