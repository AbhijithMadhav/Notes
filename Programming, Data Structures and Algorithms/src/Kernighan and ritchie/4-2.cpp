/* Extend atof to handle scientific notation of the form
123.45e-6
where a floating-point number may be followed by e or E and an optionally signed exponent
*/

#include<stdio.h>
#include<ctype.h>
#include<math.h>
#define NEGATIVE 1

double atof(char s[]);

int main()
{
	char s[] = "1.23E-3";
	printf("%s = %f\n", s, atof(s));
	getchar();
		return 1;
}

double atof(char s[])
{
	double val, power, exponent = 0.0;
	int i, sign, sign_exponent = 0;
	for (i = 0; isspace(s[i]); ++i)
		;
	sign = (s[i] == '-') ? -1 : 1;
	if (s[i] == '+' || s[i] == '-')
		i++;
	for (val = 0.0; isdigit(s[i]); i++)
		val = 10.0 * val + (s[i] - '0');
	if (s[i] == '.')
		i++;
	for (power = 1.0; isdigit(s[i]); i++)
	{
		val = 10.0 * val + (s[i] - '0');
		power *= 10.0;
	}
	if (s[i] == 'e' || s[i] == 'E')
	{
		i++;
		if (s[i] == '+')
			i++;
		else if (s[i] == '-')
		{
			sign_exponent = -1;
			i++;
		}
		for (exponent = 0.0; isdigit(s[i]); i++)
			exponent = 10.0 * exponent + (s[i] - '0');
	}
	return sign * val / (power * pow(10.0, (sign * exponent)));
}