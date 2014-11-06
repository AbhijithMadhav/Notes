#include <ctype.h>
#include <stdio.h>

#define TRUE 1
#define FALSE 0

int getch(void);
void ungetch(int);

/* getfloat: get next decimal number from input into *pn */
int getfloat(double *pn)
{
	int c, sign;
	char sign_char;
	double fr = 0.0;
	int d = 1;
	while (isspace(c = getch())) /* skip white space */
		;
	if (!isdigit(c) && c != EOF && c != '+' && c != '-' && c != '.') {
		ungetch(c); /* it is not a number */
		return 0;
	}
	sign = (c == '-') ? -1 : 1;
	if ( c == '+' || c == '-')
	{
		sign_char = c;
		c = getch();
		if (!isdigit(c) && c != '.')
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
	for (*pn = 0.0; isdigit(c); c = getch())
		*pn = 10.0 * *pn + (c - '0');
	if (c == '.')
	{
		c = getch();
		for (fr = 0.0; isdigit(c); c = getch())
		{
			d *= 10;
			fr= 10.0 * fr + (c - '0');
		}
		fr /= d;
	}
	*pn += fr;
	*pn *= sign;
	if (c != EOF)
		ungetch(c);
	return c;
}