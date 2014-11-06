/* 
Exercise 5-13. Write the program tail, which prints the last n lines of its input. By default, n
is set to 10, let us say, but it can be changed by an optional argument so that
tail -n
prints the last n lines. The program should behave rationally no matter how unreasonable the
input or the value of n. Write the program so it makes the best use of available storage; lines
should be stored as in the sorting program of Section 5.6, not in a two-dimensional array of
fixed size.
*/ 
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

#define TAIL_LENGTH 5
#define NMAX 50
#define MAXLEN 100
int main(int argc, char *argv[])
{
	int n = TAIL_LENGTH, isnumber(char*);
	if (argc > 2)
		printf("Extra arguments after %s ignored\n", *argv[2]);

	if (argc == 1)
		;
	else if (argc >= 2 && (*++argv)[0] == '-' && isnumber((*argv) + 1))
	{
		n = atoi((*argv) + 1);
		if ( n > NMAX) // unreasonable value of n
			n = NMAX;
	}
	else
	{
		printf("Usage: %s [-n]\n", *(argv - 1));
		return -1;
	}

	{
		char **lines, temp[MAXLEN];
		int i, len, getline(char* ,int), count, reused = 0;
		lines = (char**)malloc(sizeof(int)*n);
		for ( i = 0 ; i < n; ++i)
			lines[i] = NULL;
		
		for (i = 0; (len = getline(temp, MAXLEN)) != 0;)
		{
			free(*(lines + i));
			lines[i] = (char *)malloc(len + 1); 
			strcpy(lines[i], temp);
			i = ++i % n;
			if ( i == 0 )
				reused = 1;
		}

		printf("Tail of file is %d lines long and is as below:\n", n);
		if (!reused)
			i = 0;
		for ( count = 0; count < n && lines[i] != NULL; i = ++i % n, ++count)
			printf("%s", lines[i]);
	}
	getchar();
	return 0;
}