/*
 * 1-10.c
 *
 *  Created on: Sep 18, 2009
 *      Author: Abhijith
 */

#include<stdio.h>
#include<stdlib.h>
/* Copy input to output. Replace
 * 1. tab by \t
 * 2. backspace by \b
 * 3. backslash by \\
 */

int main()
{
	int c;
	while ( (c = getchar()) != EOF)
	{
		if (c == '\t')
			printf("\\t");
		else if (c == '\b')
			printf("\\b");
		else if (c == '\\')
			printf("\\\\");
		else
			putchar(c);
	}
	return EXIT_SUCCESS;
}
