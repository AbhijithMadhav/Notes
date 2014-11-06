/* Exercise 5-7. Rewrite readlines to store lines in an array supplied by main, rather than
calling alloc to maintain storage. How much faster is the program?
*/

#include <stdio.h>
#include <string.h>
#include <time.h>

#define MAXLINES 5000 /* max #lines to be sorted */
#define MAXLEN 1000

char lineptr[MAXLINES][MAXLEN]; /* pointers to text lines */

int readlines(char *lineptr[], int nlines);
void writelines(char lineptr[][MAXLEN], int nlines);
void qsort(char *lineptr[], int left, int right);

/* sort input lines */
int main()
{
	clock_t start, end;
	int nlines; /* number of input lines read */
	start = clock();
	if ((nlines = readlines(lineptr, MAXLINES)) >= 0) {
		qsort(lineptr, 0, nlines-1);
		writelines(lineptr, nlines);
		return 0;
	} else {
		printf("error: input too big to sort\n");
		return 1;
	}
	
}