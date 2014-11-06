#include<ctype.h>

/* atoi: convert s to integer */
int atoi(char* s)
{
	int n, sign;
	while (isspace(*s)) /* skip white space */
		s++;
	sign = (*s == '-') ? -1 : 1;
	if (*s == '+' || *s == '-') /* skip sign */
		s++;

	n = 0;
	while(isdigit(*s))
			n = 10 * n + (*s++ - '0');
	return sign * n;
}