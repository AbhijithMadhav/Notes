/*
 * 1-14.c
 *
 *  Created on: Sep 23, 2009
 *      Author: Abhijith
 */

#include<stdio.h>
#define MIN_CHAR 32
#define MAX_CHAR 126  // ASCII value of max printable character i.e ~

/* Histogram - Number of occurrences of each character in ascii set */

int main()
{
	int num_occurances[MAX_CHAR + 1];
	for (int i = 0; i <= MAX_CHAR; ++i)
		num_occurances[i] = 0;

	/* count the length of characters */
	int c;
	while ((c = getchar()) != EOF)
		++num_occurances[c];


	/* Find the maximum count of any length for plotting purposes */
	int max = num_occurances[MIN_CHAR];
	for (int i = MIN_CHAR + 1; i <= MAX_CHAR; ++i)
		if (max < num_occurances[i])
			max = num_occurances[i];


	printf("%d\n",max);
	/* Create histogram */
	for (int occurances = max; occurances > 0; --occurances)
	{
		printf("%5d|", occurances);
		for (int character = MIN_CHAR; character <= MAX_CHAR; ++character)
		{
			printf("   ");
			if (num_occurances[character] >= occurances)
				putchar('*');
			else
				putchar(' ');
		}
		putchar('\n');
	}

	if (max > 0)
	{
		printf("      ");
		for (int character = MIN_CHAR; character <= MAX_CHAR; ++character)
			printf("----");
		putchar('\n');
		printf("      ");
		for (int character = MIN_CHAR; character <= MAX_CHAR; ++character)
			printf("%4c", character);
	}
	return 0;
}
