/*
 * 1-17.c
 *
 *  Created on: Sep 24, 2009
 *      Author: Abhijith
 */

#include<stdio.h>
#define MAXLENGTH 1000
/* print lines greater than 80 characters */

int getline(char line[], int lim);

int main()
{
	char line[MAXLENGTH], len;
	while ((len = getline(line, MAXLENGTH)) > 0)
	{
		if (len >= 80)
		{
			printf("%s\n", line);
		}
	}
	return 0;
}

int getline(char string[], int lim)
{
	int c, i;
	for ( i =0; (c = getchar()) != EOF && c != '\n' && i < lim - 1; )
		string[i++] = c;
	if ( c == '\n')
		string[i++] = '\n';
	string[i] = '\0';
	return i;
}
