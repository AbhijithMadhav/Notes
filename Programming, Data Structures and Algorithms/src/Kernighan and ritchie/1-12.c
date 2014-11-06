/*
 * 1-12.c
 *
 *  Created on: Sep 22, 2009
 *      Author: Abhijith
 */

#include<stdio.h>
#define OUT 1
#define IN 0

/* Print input as output with one character per line */
int main()
{
	int c, state = OUT;
	while ( (c = getchar()) != EOF)
	{
		if (c == '\t' || c == ' ' || c == '\n')
		{
			if (state == IN)
				putchar('\n');
			state = OUT;
		}
		else
		{
			putchar(c);
			state = IN;
		}
	}
	return 0;
}
