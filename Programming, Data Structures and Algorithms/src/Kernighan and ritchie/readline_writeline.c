#include <stddef.h>
#include <string.h>
#include <stdio.h>
#define MAXLEN 1000 /* max length of any input line */

int getline(char *, int);
char *alloc(int);

/* readlines: read input lines */
int readlines(char *lineptr[], int maxlines)
{
	int len, nlines;
	char *p, line[MAXLEN];
	nlines = 0;
	while ((len = getline(line, MAXLEN)) > 0)
		if (nlines >= maxlines || (p = alloc(len)) == NULL)
			return -1;
		else {
			line[len-1] = '\0'; /* delete newline */
			strcpy(p, line);
			lineptr[nlines++] = p;
		}
		return nlines;
}


/* writelines: write output lines */
void writelines(char *lineptr[], int nlines)
{
	int i;
	for (i = 0; i < nlines; i++)
			printf("%s\n", lineptr[i]);
}

/* writelines_reverse: write output lines in the reverse order */
void writelines_reverse(char *lineptr[], int nlines)
{
	int i;
	for (i = nlines - 1; i >= 0 ; --i)
		printf("%s\n", lineptr[i]);
}

void writelines_generic(char *lineptr[], int nlines, void (*wl)(char *[], int))
{
                wl(lineptr, nlines);
}
