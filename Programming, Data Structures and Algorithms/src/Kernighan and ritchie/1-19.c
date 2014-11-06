/*
 * 1-19.c
 *
 *  Created on: Sep 24, 2009
 *      Author: Abhijith
 */

#include<stdio.h>
#define MAXLENGTH 1000

int getline(char line[], int lim);
void reverse(char string[], char rev[]);

int main()
{
	char line[MAXLENGTH], rev[MAXLENGTH];
	int len;
	while ((len = getline(line, MAXLENGTH)) > 0)
	{
		reverse(line, rev);
		printf("%s\n", rev);
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

void reverse(char string[], char reverse[])
{
	/*
	 * 1. Traverse 'string' until null is reached
	 * 2. Travel back until start, populating 'reverse'
	 * 3. Insert a '\0' to terminate 'reverse'
	 */
	int i, j;
	for (i = 0; string[i] != '\0'; ++i)
		;
	for ( j = 0; i > 0; )
		reverse[j++] = string[--i];
	reverse[j] = '\0';
}
