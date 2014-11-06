
/*
 * Exercise 6-1. Our version of getword does not properly handle underscores,
 * string constants, comments, or preprocessor control lines. Write a better
 * version.
 */

struct key
{
	char *word;
	int count;
} keytab[] =
{
	{
	"auto", 0},
	{
	"break", 0},
	{
	"case", 0},
	{
	"char", 0},
	{
	"const", 0},
	{
	"continue", 0},
	{
	"default", 0},
	{
	"define", 0},
	{
	"do", 0},
	{
	"double", 0},
	{
	"else", 0},
	{
	"enum", 0},
	{
	"extern", 0},
	{
	"float", 0},
	{
	"for", 0},
	{
	"goto", 0},
	{
	"if", 0},
	{
	"int", 0},
	{
	"long", 0},
	{
	"register", 0},
	{
	"return", 0},
	{
	"short", 0},
	{
	"signed", 0},
	{
	"sizeof", 0},
	{
	"static", 0},
	{
	"struct", 0},
	{
	"switch", 0},
	{
	"typedef", 0},
	{
	"union", 0},
	{
	"unsigned", 0},
	{
	"void", 0},
	{
	"volatile", 0},
	{
	"while", 0}
};

#define NKEYS (sizeof keytab / sizeof(keytab[0]))
#define MAXWORD 100

#define DQUOTES 0x01
#define SQUOTES 0x02
#define COMMENTS 0x04
#define ESCAPE 0x08

#include <stdio.h>
#include <ctype.h>
#include <string.h>

int getword(char *, int);
int binsearch(char *, struct key *, int);

/* count C keywords */
int main()
{
	int n, state = 0;
	char p = '\0', c;
	char word[MAXWORD];
	while ((c = getword(word, MAXWORD)) != EOF)
	{
		if (state & ESCAPE)
			state &= ~ESCAPE;
		/* Is this the start or end of double quotes */
		else if (word[0] == '"' && !(state & ESCAPE))
		{
			/* Only if not already within singles quotes or
			   comments or if not escaped */
			if (!(state & SQUOTES) && !(state & COMMENTS))
			{
				if (state & DQUOTES)
					state &= ~DQUOTES;
				else
					state |= DQUOTES;
			}
		}
		/* Is this the start/end of single quotes? */
		else if (word[0] == '\'' && !(state & ESCAPE))
		{
			/* Only if not already within double quotes or comments or not escaped */
			if (!(state & DQUOTES) && !(state & COMMENTS))
			{
				if (state & SQUOTES)
					state &= ~SQUOTES;
				else
					state |= SQUOTES;
			}
		}
		/* Will the next character be escaped */
		else if (word[0] == '\\'
			 && ((state & SQUOTES) || (state & DQUOTES))
			 && !(state & ESCAPE))
			state |= ESCAPE;
		/* Is this the start of comments?? */
		else if (word[0] == '*' && p == '/' && !(state & DQUOTES))
			state |= COMMENTS;
		/* Is this the end of comments?? */
		else if (word[0] == '/' && p == '*' && !(state & DQUOTES))
			state &= ~COMMENTS;

		if (!(state) && isalpha(word[0]))
			if ((n = binsearch(word, keytab, NKEYS)) >= 0)
				keytab[n].count++;
		p = c;
	}
	for (n = 0; n < NKEYS; n++)
		if (keytab[n].count > 0)
			printf("%4d %s\n", keytab[n].count, keytab[n].word);
	return 0;
}

/* binsearch: find word in tab[0]...tab[n-1] */
int binsearch(char *word, struct key tab[], int n)
{
	int cond;
	int low, high, mid;
	low = 0;
	high = n - 1;
	while (low <= high)
	{
		mid = (low + high) / 2;
		if ((cond = strcmp(word, tab[mid].word)) < 0)
			high = mid - 1;
		else if (cond > 0)
			low = mid + 1;
		else
			return mid;
	}
	return -1;
}

/* getword: get next word or character from input */
int getword(char *word, int lim)
{
	int getch(void);
	void ungetch(int);

	char *w = word;

	/* Ignore white spaces */
	while (isspace(*w = getch()))
		;

	/* Inspect first character */
	if (!(isalnum(*w) || *w == '_'))
	{
		/* Return non-printable character(\n, EOF etc) or
		   non-alphanumric, non-underscore character of C's basic
		   character set */
		/* Bug: the ending '/' of the comment and the immediate '*' 
		 * next belonging to the dereferncing cause the program to 
		 * assume a start of comment when this file is used as input 
		 * to this program itself */
		/*      *++w = '\0'; */
		++w;
		*w = '\0';
		return word[0];
	}

	for (; --lim > 0 && (isalnum(*w) || *w == '_'); *++w = getch())
		;
	ungetch(*w);
	*w = '\0';
	return word[0];
	/* Return first character of the keyword or identifier */
}

