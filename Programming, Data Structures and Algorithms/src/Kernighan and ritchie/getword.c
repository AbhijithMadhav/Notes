#include <ctype.h>
#include <stdio.h>


/* getword: get next word or character from input */
int getword(char *word, int lim)
{
	int getch(void);
	void ungetch(int);

	int c;
	char *w = word;

	/* Ignore white spaces */
	while (isspace(c = getch()))
		;

	/* Discard comments */
	if (c == '/')
	{
		if ((c = getch()) == '*')
		{
			int p = c;
			while((c = getch()) != EOF)
			{
				if (c == '/' && p == '*')
					break;
				p = c;
			}
		}
		else
		{
			ungetch(c);
			c = '/';
		}
	}

	/* Ignore Strings */
	if (c == '"')
	{
		int p = c;
		while ((c = getch()) != EOF)
		{
			if ( c == '"' && p != '/')
				break;
			p = c;
		}
	}

	/* Ignore character literals */
	if (c == '\'')
	{
		int p = c;
		while ((c = getch()) != EOF)
		{
			if ( c == '\'' && p != '\\')
				break;
			p = c;
		}
	}

	*w = c;
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