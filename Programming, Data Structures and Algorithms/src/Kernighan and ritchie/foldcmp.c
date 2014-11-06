/*
 * foldcmp.c
 *
 *  Created on: 13-Feb-2010
 *      Author: kempa
 */

#include <ctype.h>
#include <string.h>

#define MAXLEN 1000
int foldcmp(char *s1, char *s2)
{
	int j;
	char temp1[MAXLEN], temp2[MAXLEN];
	for (j = 0; j < strlen(s1); ++j)
		temp1[j] = toupper(s1[j]);
	for (j = 0; j < strlen(s2); ++j)
		temp2[j] = toupper(s2[j]);

	return strcmp(temp1, temp2);
}
