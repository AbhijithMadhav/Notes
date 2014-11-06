/*
 * 1-9.c
 *
 *  Created on: Sep 18, 2009
 *      Author: Abhijith
 */

#include<stdio.h>

/* Copy input to output replacing one or more blanks by a single one */
int main()
{
	int c;
	while ((c = getchar()) != EOF)
	{
		if (c == ' ')
		{
			putchar(c);
			while ( (c = getchar()) == ' ')
				;
		}
		putchar(c);
	}
	return 0;
}
