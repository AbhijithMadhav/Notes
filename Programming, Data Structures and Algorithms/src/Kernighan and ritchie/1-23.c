/*
 * 1-23.c
 *
 *  Created on: Oct 3, 2009
 *      Author: Abhijith
 */

#include<stdio.h>

#define TRUE 1
#define FALSE 0

/*
 * Exercise 1-23. Write a program to remove all comments
 * from a C program. Don't forget to handle quoted
 * strings and character constants properly. C comments
 * don't nest.
 */
int main()
{
	int c = EOF, pc = EOF, nc = EOF, ppc = EOF;
	int inComment = FALSE;
	int inDQuotes = FALSE;

	while ((nc = getchar()) != EOF)
	{
		if (c == '"')
		{
			if ( !inDQuotes && !inComment)
				inDQuotes = TRUE;
			else if ( inDQuotes && !inComment)
				inDQuotes = FALSE;
		}
		else if (c == '/' && nc == '*' && !inDQuotes)
			inComment = TRUE;
		else if (pc == '/' && ppc == '*' && inComment && !inDQuotes)
			inComment = FALSE;

		if (!inComment && c != EOF)
			putchar(c);
		ppc = pc;
		pc = c;
		c = nc;
	}
	return 0;
}
