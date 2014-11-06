/*
 * 5-15.c
 *
 *  Created on: 13-Feb-2010
 *      Author: kempa
 */

/*
 * Exercise 5-14. Modify the sort program to handle a -r flag, which indicates sorting in reverse
 * (decreasing) order. Be sure that -r works with -n.
 */

/*
 * Exercise 5-15. Add the option -f to fold upper and lower case together, so
 * that case distinctions are not made during sorting; for example, a and A
 * compare equal.
 */

/* 
 * Exercise 5-16. Add the -d (``directory order'') option, which makes comparisons only on
 * letters, numbers and blanks. Make sure it works in conjunction with -f.
 */

/*
 * Exercise 5-17. Add a field-searching capability, so sorting may bee done on fields within lines,
 * each field sorted according to an independent set of options. (The index for this book was
 * sorted with -df for the index category and -n for the page numbers.)
 */

/*
 * Exercise 5-17. Add a field-searching capability, so sorting may bee done on fields within lines,
 * each field sorted according to an independent set of options. (The index for this book was
 * sorted with -df for the index category and -n for the page numbers.)
 */

#include <stdio.h>
#include <string.h>

#include "5-14,15,16,17.h"

char *lineptr[MAXLINES]; /* pointers to text lines */

int primary_sort = 0;

int readlines(char *lineptr[], int nlines);
void writelines(char *lineptr[], int nlines);
void writelines_reverse(char *lineptr[], int nlines);
void writelines_generic(char *lineptr[], int nlines, void(*wl)(char *[], int));
void qsort(void *lineptr[], int left, int right, int(*comp)(void *, void *));
int numcmp(char *, char *);
int foldcmp(char *, char *);
int dircmp(char *, char *);
int isnumeber(char *);

/* sort input lines */
int main(int argc, char *argv[])
{
	int nlines; /* number of input lines read */

	char **temp = argv;

	while (--argc > 0)
	{
		++argv;
		if ((*argv)[0] == '-')
		{
			while (*(++(*argv)) != '\0')
			{
				if (**argv == 'r')
					primary_sort |= REVERSE;
				else if (**argv == 'n')
					primary_sort |= NUMERIC;
				else if (**argv == 'f')
					primary_sort |= FOLD;
				else if (**argv == 'd')
					primary_sort |= DIRECTORY;
				else
				{
					printf("Invalid argument: %s\nUsage: %s [-n] [-r] [-f] [-d]\n",
							*argv - 1, *temp);
					return -1;
				}
			}
		}
		else if ((*argv)[0] == '+')
		{
			if (!isnumber(++(*argv)))
			{
				printf("Invalid argument %s. Has to be a field denoting number.\nUsage: %s [-n] [-r] [-f] [-d] [+number]\n", *argv, *temp);
				return -1;
			}
			for (int i = atoi(*argv) ; i < MAXFIELDS ; ++i)
			{
				primary_sort &= ~cur_sort
				secondary_sort[i] |= cur_sort;
			}
		}
		else
		{
			printf("Invalid argument: %s\nUsage: %s [-n] [-r] [-f] [-d]\n", *argv,
					*temp);
			return -1;
		}

	}

	printf("Enter lines to be sorted\n");
	if ((nlines = readlines(lineptr, MAXLINES)) >= 0)
	{
		// Sorting by primary sort field
		if ((primary_sort & FOLD) && !(primary_sort & NUMERIC)) // implies non-numeric sort
			qsort((void**) lineptr, 0, nlines - 1,
					(int(*)(void*, void*)) ((primary_sort & DIRECTORY) ? dircmp : foldcmp));
		else if ((primary_sort & DIRECTORY) && !(primary_sort & NUMERIC)) // implies non-numeric sort
			qsort((void**) lineptr, 0, nlines - 1,
								(int(*)(void*, void*)) dircmp);
		else
			qsort((void**) lineptr, 0, nlines - 1,
					(int(*)(void*, void*)) ((primary_sort & NUMERIC) ? numcmp : strcmp));

		printf("\nSorted records are\n");
		writelines_generic(lineptr, nlines, (primary_sort & REVERSE) ? writelines_reverse
				: writelines);
		return 0;
	}
	else
	{
		printf("input too big to sort\n");
		return 1;
	}
}
