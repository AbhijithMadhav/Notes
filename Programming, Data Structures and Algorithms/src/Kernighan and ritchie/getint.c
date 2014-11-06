#include <ctype.h>
#include<stdio.h>

#define TRUE 1
#define FALSE 0

int getch(void);
void ungetch(int);

/* getint: get next integer from input into *pn */
int getint(int *pn)
{
	int c, sign;
	char sign_char;
	while (isspace(c = getch())) /* skip white space */
		;
	if (!isdigit(c) && c != EOF && c != '+' && c != '-') {
		ungetch(c); /* it is not a number */
		return 0;
	}
	sign = (c == '-') ? -1 : 1;
	if ( c == '+' || c == '-')
	{
		sign_char = c;
		c = getch();
		if (!isdigit(c))
		{
			ungetch(sign_char);
			if (c != EOF)
			{
				ungetch(c);
				return 0; /* it is not a number */
			}
			else
				return c;
		}
	}
	for (*pn = 0; isdigit(c); c = getch())
		*pn = 10 * *pn + (c - '0');
	*pn *= sign;
	if (c != EOF)
		ungetch(c);
	return c;
}