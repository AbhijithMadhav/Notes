/*
 * 1-20.c
 *
 *  Created on: Sep 24, 2009
 *      Author: Abhijith
 */

#include<stdio.h>

/* replace tabs with appropriate spaces */

#define TAB_STOP 8 // A tab stop is every eighth character position in a page

int main()
{
	/*
	 * 1. Keep track of how many spaces are required to get to the next tab stop as and when each character is scanned, i.e. spaces_until_next_tab_stop
	 * 	a. Reset count to tab stop when tab or newline is encountered
	 * 	b. Decrement count when other characters are encountered.
	 *  c. Reset count to tab stp when it becomes 0
	 * 2. When a tab is encountered replace it with spaces just enough to reach the next tab stop
	 *
	 */
	int c;
	int spaces_until_next_tab_stop = TAB_STOP;
	while ((c = getchar()) != EOF)
	{
		if ( c == '\t')
		{
			for ( int i = spaces_until_next_tab_stop; i > 0; --i)
				putchar(' ');
			spaces_until_next_tab_stop = TAB_STOP;
		}
		else
		{
			putchar(c);
			if  ( c == '\n')
				spaces_until_next_tab_stop = TAB_STOP;
			else
			{
				--spaces_until_next_tab_stop;
				if ( spaces_until_next_tab_stop == 0)
					spaces_until_next_tab_stop = TAB_STOP;
			}
		}
	}
    return 0;
}
