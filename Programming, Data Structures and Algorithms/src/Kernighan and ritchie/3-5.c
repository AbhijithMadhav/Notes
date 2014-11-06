/* Write the function itob(n,s,b) that converts the integer n into a base b
character representation in the string s. In particular, itob(n,s,16) formats s as a
hexadecimal integer in s.
*/
#include<stdio.h>
#include<math.h>

void itob(int, char[], int);
void reverse(char s[]);


int main()
{
	char s[100];
	itob(-1234, s, 16);
	printf("String rep of hexadecimal is %s\n", s);
	getchar();
	return 0;
}
void itob(int n, char s[], int b)
{
	int i, sign;

	if ((sign = n) < 0)
		n = -n;
	i = 0;
	do
	{
		switch(n%b)
		{
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			s[i++] = abs(n % b) + '0';
			break;
		case 10:
		case 11:
		case 12:
		case 13:
		case 14:
		case 15:
			s[i++] = (n % b) + '7';
			break;
		}
	}
	while (n /= b);

		if (sign < 0)
			s[i++] = '-';
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