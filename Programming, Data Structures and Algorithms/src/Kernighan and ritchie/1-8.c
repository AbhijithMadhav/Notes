/*
 * 1-8.c
 *
 *  Created on: Sep 18, 2009
 *      Author: Abhijith
 */

#include<stdio.h>

/* To count newlines, tabs and spaces */


int main()
{
	long nl, nt, ns;
	int c;
	nl = 0;
	nt = 0;
	ns = 0;
	while ((c = getchar()) != EOF)
	{
		if (c == '\n')
		{
			++nl;
		}
		if (c == ' ')
		{
			++ns;
		}
		if (c == '\t')
		{
			++nt;
		}
	}
	printf("\nLines:%ld Tabs:%ld Spaces:%ld\n", nl, nt, ns);

	return 0;
}
