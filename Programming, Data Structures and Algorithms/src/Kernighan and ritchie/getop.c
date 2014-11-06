#include <ctype.h>
#include <stdio.h>
#include <string.h>
#include "calc.h"
#define LIM 100
void getnumber(char s[], int i);
int getline(char s[], int lim);

char line[LIM];
int li = 0;

/* getop: get next character or numeric operand
 * Returns:
 *	NUMBER - If number found(positive, negative, integer, fraction)
 *  POW - if operator 'pow' is used
 *	SIN - 
 *	EXP - 
 *  IDENTIFIER - if a single lettered identifier is found(caps, small)
 *  INVALID_OPERATOR - if invalid multilettered operqator is found
 *  Returns anything else as it is encountered
 */
int getop(char s[])
{
	int i;

	if (line[li] == '\0')
	{
		if (getline(line, LIM) == 0)
			return EOF;
		else
			li = 0;
	}

	while ((s[0] = line[li++]) == ' ' || s[0] == '\t')
		;
	s[1] = '\0';
	i = 0;
	if (!isalnum(s[i]) && s[i] != '.')
	{
		switch(s[i])
		{         
		default:
			return s[i];
			break;
		case '-':
			s[++i] = line[li++];
			if (!isdigit(s[i]))
			{
				--li;
				return '-';
			}
			else
			{
				getnumber(s, i + 1);
				return NUMBER;
			}
			break;
		}
	}
	else if (isdigit(s[i]) || (s[i] == '.')) /* collect the number */
	{
		getnumber(s, i + 1);
		return NUMBER;
	}
	else /* alphabets. check for one of recognised operators specified by a english word or for a variable name*/
	{
		while (isalpha(s[++i] = line[li++]))
			;
		--li;
		s[i] = '\0';
		if (strcmp("sin", s) == 0)
			return SIN;
		else if (strcmp("pow", s) == 0)
			return POW;
		else if (strcmp("exp", s) == 0)
			return EXP;
		else if (strlen(s) > 1)
			return INVALID_OPERATOR;
		else
			return IDENTIFIER;
	}
}

/* accepts a positive integer or fraction from standard input 
 * s : array into which number is accepted
 * i : Numbers are stored from position i
 */

void getnumber(char s[], int i)
{
		while (isdigit(s[i++] = line[li++]) || s[i] == '.')
			;
		--li;
		s[--i] = '\0';
}


/* getline: get line into s, return length */
int getline(char s[], int lim)
{
int c, i;
i = 0;
while (--lim > 0 && (c=getchar()) != EOF && c != '\n')
s[i++] = c;
if (c == '\n')
s[i++] = c;
s[i] = '\0';
return i;
}