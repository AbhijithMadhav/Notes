/*
 * 1-22.c
 *
 *  Created on: Sep 25, 2009
 *      Author: Abhijith
 */

/*
 * Exercise 1-22. Write a program to ``fold'' long input lines into two or more shorter lines after
 * the last non-blank character that occurs before the n-th column of input. Make sure your
 * program does something intelligent with very long lines, and if there are no blanks or tabs
 * before the specified column.
 */

#include<stdio.h>

/* Length at which line should be broken up */
#define FOLD_COL 10

# define TRUE 1
# define FALSE 0

/*  In case there are no tabs or blanks before FOLD_COL
 *  the line is broken at FOLD_COL
 */

int main()
{
	/* next character which will be processed */
	int nc;

	/* Array which holds the characters to be outputted.
	 * Filling up of the array indicates that a decision
	 * about breaking the line needs to be made as it's
	 * size is FOLD_COL
	 */
	char buffer[FOLD_COL];
	int bi = -1; // Buffer index
	int BlankOrTabPresent = FALSE;
	int BlankOrTabIndex = -1;

	int print_line(char array[], int length);

	while ((nc = getchar()) != EOF)
	{
		/* if a newline is encountered before the reaching FOLD_COL, print the line */
		if (bi > 0 && buffer[bi] == '\n')
		{
			print_line(buffer, bi);
			bi = -1;
		}
		else if (bi == FOLD_COL - 1)
		{
			/* if character at FOLD_COL or it's next character is ' ' or '\n' or '\t'
			 * break the line at FOLD_COL and print
			 */
			if (buffer[bi] == ' ' || buffer[bi] == '\t' || buffer[bi] == '\n'
					|| nc == ' ' || nc == '\t' || nc == '\n')
			{
				print_line(buffer, bi + 1);
				bi = -1;
			}
			else
			{
				if (BlankOrTabPresent)
				{
					/* if there is a space or tab before FOLD_COL,
					 * break the line there and reset the buffer suitably
					 */
					print_line(buffer, BlankOrTabIndex + 1);

					/* Reset The buffer */
					for (int i = BlankOrTabIndex + 1; i < FOLD_COL; ++i)
						buffer[i - BlankOrTabIndex - 1] = buffer[i];
					bi = FOLD_COL - 1 - BlankOrTabIndex - 1;
				}
				else
				{
					/* If there are no spaces or tabs before FOLD_COL
					 * forcefully break at FOLD_COL
					 */
					print_line(buffer, FOLD_COL);
					bi = -1;
				}
			}
			BlankOrTabPresent = FALSE;
			BlankOrTabIndex = -1;
		}
		buffer[++bi] = nc;
		if (buffer[bi] == ' ' || buffer[bi] == '\t')
		{
			BlankOrTabPresent = TRUE;
			BlankOrTabIndex = bi;
		}
	}
	if (nc == EOF)
		print_line(buffer, bi);
	return 0;
}

int print_line(char array[], int length)
{
	int i;
	for (i = 0; i < length; ++i)
		putchar(array[i]);
	putchar('\n');
	return i + 1;
}
