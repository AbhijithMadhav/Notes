/*
 * 1-13.c
 *
 *  Created on: Sep 22, 2009
 *      Author: Abhijith
 */

#include<stdio.h>
#include<stddef.h>
#define IN 1
#define OUT 0
#define MAX_WORD_LENGTH 10

/* Histogram - Number of occurrences vs length of words in input */

int main()
{
	int num_occurances[MAX_WORD_LENGTH];
	for (int i = 0; i < MAX_WORD_LENGTH; ++i)
		num_occurances[i] = 0;

	/* count the length of words */
	int word_length = 0, c, state = OUT;
	while ((c = getchar()) != EOF)
	{
		if (c == '\n' || c == ' ' || c == '\t')
		{
			state = OUT;
			if (word_length >= 10)  // Club all lengths greater than 10
				word_length = 10;
			++num_occurances[word_length - 1];
			word_length = 0;
		}
		else
		{
			state = IN;
			++word_length;
		}
	}

	/* Find the maximum count of any length for plotting purposes */
	int max = num_occurances[0];
	for (int i = 1; i < (MAX_WORD_LENGTH); ++i)
	{
		if (num_occurances[i - 1] < num_occurances[i])
			max = num_occurances[i];
	}

	/* Create histogram */
	for (int occurances = max; occurances > 0; --occurances)
	{
		printf("%5d|", occurances);
		for (int word_lengths = 1; word_lengths <= MAX_WORD_LENGTH; ++word_lengths)
		{
			printf("   ");
			if (num_occurances[word_lengths - 1] >= occurances)
				putchar('*');
			else
				putchar(' ');
		}
		putchar('\n');
	}

	if (max > 0)
	{
		printf("     ");
		printf("-----------------------------------------\n");
		printf("      ");
		for (int word_lengths = 1; word_lengths < MAX_WORD_LENGTH; ++word_lengths)
			printf("%4d", word_lengths);
		printf(" >%d", MAX_WORD_LENGTH);
	}
	return 0;
}
