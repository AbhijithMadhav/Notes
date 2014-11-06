/*
 * 1-18.c
 *
 *  Created on: Sep 24, 2009
 *      Author: Abhijith
 */

#include<stdio.h>
#define MAXLENGTH 1000

/* remove trailing blanks and tabs of the inputted line */

int getline(char line[], int lim);
void remove_trailing_blanks_and_tabs(char line[]);

int main()
{
	char line[MAXLENGTH], len;
	while ((len = getline(line, MAXLENGTH)) > 0)
	{
		remove_trailing_blanks_and_tabs(line);
		printf("%s\n", line);
	}
	return 0;
}

int getline(char string[], int lim)
{
	int c, i;
	for ( i =0; (c = getchar()) != EOF && c != '\n' && c < lim - 1; )
		string[i++] = c;
	if ( c == '\n')
		string[i++] = '\n';
	string[i] = '\0';
	return i;
}

void remove_trailing_blanks_and_tabs(char string[])
{
	/*
	 * 1. Traverse till end of string
	 * 2. Get back until a non-blank and non-tab character is found
	 * 3. Remove blanks and non-tab by inserting a null
	 */
	int i;
	for (i = 0; string[i] != '\0'; ++i)
		;
	while(string[i] == ' ' || string[i] == '\t')
		--i;
	if ( string[i] != '\0')
	string[++i] = '\0';
}

