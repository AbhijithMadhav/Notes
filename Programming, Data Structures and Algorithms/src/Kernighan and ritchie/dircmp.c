/*
 * dircmp.c
 *
 *  Created on: 13-Feb-2010
 *      Author: kempa
 */

#include <stdio.h>
#include <string.h>
#include <ctype.h>

#include "5-14,15,16,17.h"
#define MAXLEN 1000
extern int primary_sort;

int foldcmp(char*, char*);

int dircmp(char* s1, char* s2)
{
		int j, i;
		char temp1[MAXLEN], temp2[MAXLEN];
		for (j = 0, i = 0; j < strlen(s1); ++j)
			if (isalnum(s1[i]) || isspace(s1[i]) || s1[j] == '\0')
				temp1[i++] = s1[j];
		for (j = 0, i = 0; j < strlen(s2); ++j)
			if (isalnum(s2[i]) || isspace(s2[i]) || s2[j] == '\0')
				temp2[i++] = s2[j];
		return((primary_sort & FOLD) ? foldcmp(temp1, temp2) : strcmp(temp1, temp2));
}
