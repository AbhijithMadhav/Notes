#define ABS(X) (((X) < 0) ? -(X) : (X))

#include<string.h>

/* itoa: convert n to characters in s */
void itoa(int n, char *s)
{
	int sign = n; /* record sign */
	char* reverse(char*);
	char *t = s;
	do { /* generate digits in reverse order */
		*s = ABS(n % 10) + '0'; /* get next digit */
		s++;
	} while (n /= 10); /* delete it */
	
	if (sign < 0)
		*s++ = '-';
	*s = '\0';
	reverse(t);
}

void itoaw(char *s, int n, int w)
{
	int sign;
	char *t = s;
	char *reverse(char*);
	sign = n;
	do {
		*t++ = ABS(n % 10) + '0';
	} while (n /= 10);
	if (sign < 0)
		*t++ = '-';
	*t = '\0';
		
	if (t - s < w)
	{
		int j, len = t - s;
		for (j = 0; j < w - len; ++j)
			*t++ = ' ';
	}
	*t = '\0';
	reverse(s);
}