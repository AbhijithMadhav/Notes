/* Exercise 3-4. In a two's complement number representation, our version of itoa does not
handle the largest negative number, that is, the value of n equal to -(2wordsize-1). Explain why not.
Modify it to print that value correctly, regardless of the machine on which it runs.
*/

/*Write a version of itoa that accepts three arguments instead of two. The third
argument is a minimum field width; the converted number must be padded with blanks on the
left if necessary to make it wide enough.
*/

#include<stdio.h>
#include<string.h>
#include<math.h>

void itoa(int, char[], int);
void reverse(char []);

int main()
{
	char s[100];
	itoa(1 << ((sizeof(int) * 8) - 1), s, 15);
	printf("Numeric string: %s\n", s);
	getchar();
	return 0;
}

void itoa(int n, char s[], int w)
{
	int i, sign;
	unsigned j, pad;
	
	if ((sign = n) < 0)
		n = abs(n);
	i = 0;
	do {
		s[i++] = abs(n % 10) + '0';
	} while (n /= 10);
	if (sign < 0)
		s[i++] = '-';
	s[i] = '\0';
	pad = w - strlen(s);
	if (strlen(s) < w)
		for (j = 0; j < pad; ++j)
			s[i++] = ' ';
	s[i] = '\0';
	reverse(s);
}

void reverse(char s[])
{
	int c, i, j;

	for (i = 0, j = strlen(s) - 1; i < j; i++, j--)
	{
		c = s[i];
		s[i] = s[j];
		s[j] = c;
	}
}