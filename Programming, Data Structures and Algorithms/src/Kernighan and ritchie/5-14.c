/* Exercise 5-14. Modify the sort program to handle a -r flag, which indicates sorting in 
reverse(decreasing) order. Be sure that -r works with -n.
*/

#include <stdio.h>
#include <string.h>

#define MAXLINES 5000 /* max #lines to be sorted */

char *lineptr[MAXLINES]; /* pointers to text lines */

int readlines(char *lineptr[], int nlines);
void writelines(char *lineptr[], int nlines);
void qsort(void *lineptr[], int left, int right,
		   int (*comp)(void *, void *));
void r_qsort(void *lineptr[], int left, int right,
		   int (*comp)(void *, void *));
int numcmp(char *, char *);

int reverse = 0; /* 1 if reverse sort */
/* sort input lines */
int main(int argc, char *argv[])
{
	int nlines; /* number of input lines read */
	int numeric = 0; /* 1 if numeric sort */
	char **temp = argv;

	while (--argc > 0)
	{
		++argv;
		if ((*argv)[0] == '-')
		{
			while (*(++(*argv)) != '\0')
			{
				if (**argv == 'r')
					reverse = 1;
				else if (**argv == 'n')
					numeric = 1;
				else
				{
					printf("Invalid argument: %s\nUsage: %s [-n] [-r]\n", *argv - 1, *temp);
					getchar();
					return -1;
				}
				//(*argv)++;
			}
		}
		else
		{
			printf("Invalid argument: %s\nUsage: %s [-n] [-r]\n", *argv, *temp);
			getchar();
			return -1;
		}

	}

	if ((nlines = readlines(lineptr, MAXLINES)) >= 0) {
		qsort((void**) lineptr, 0, nlines-1,
			(int (*)(void*,void*))(numeric ? numcmp : strcmp));

		int(*write)(void*, void*) = int (*)(void* void*)numcmp;


		writelines(lineptr, nlines);
		getchar();
		return 0;
	} else {
		printf("input too big to sort\n");
		getchar();
		return 1;
	}
}