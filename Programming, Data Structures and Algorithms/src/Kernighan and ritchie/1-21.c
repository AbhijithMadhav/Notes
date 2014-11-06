/*
 * 1-21.c
 *
 *  Created on: Sep 25, 2009
 *      Author: Abhijith
 */

#include<stdio.h>
#define TAB_STOP 8 // 	Tab stop is every eight position

/* Write a program entab that replaces strings of blanks by the minimum number
 * of tabs and blanks to achieve the same spacing
 */

int main()
{
	/*
	 * Read input character by character
	 * while ( ! end of file )
	 *   store characters as a string in a buffer that is big enough to accommodate strings as long as a tab stop
	 *   if ( buffer is filled )
	 *     if ( last character in buffer is a space )
	 *       backtrack consecutive spaces and place a tab in the string
	 *       print the buffer
	 *     else if ( last character is a newline )
	 *       print the buffer
	 * print the buffer to purge contents just before end of file
	 */
	int c, i = 0;
	char tab_buffer[TAB_STOP + 1];
	tab_buffer[0] = '\0';

	while ((c = getchar()) != EOF)
	{
		tab_buffer[i] = c;
		tab_buffer[i + 1] = '\0';
		++i;
		i = i % TAB_STOP;

		if (i == 0)
		{
			if (tab_buffer[TAB_STOP - 1] == ' ')
			{
				int j = TAB_STOP - 1;
				while (j > 0)
				{
					if (tab_buffer[j] == ' ')
						--j;
					else
					{
						tab_buffer[j + 1] = '\t';
						tab_buffer[j + 2] = '\0';
						break;
					}
				}
			}
				printf("%s", tab_buffer);
				tab_buffer[0] = '\0';
		}
		else if (c == '\n')
		{
			printf("%s", tab_buffer);
			tab_buffer[0] = '\0';
		}

	}
	printf("%s", tab_buffer);
	tab_buffer[0] = '\0';
	return 0;
}
