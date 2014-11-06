/* Exercise 4-12. Adapt the ideas of printd to write a recursive version of itoa; that is, convert
an integer into a string by calling a recursive routine. */

#define MAX 100
#define ABS(x) (x < 0 ? -(x) : x)  // For portability. The sign of a negative operand with % is implementation defined

int main()
{
	void itoa(int n, char s[]);
	char s[MAX];
	itoa(1 << sizeof(int) * 8 - 1, s);
	printf("%s\n", s);
	getchar();
}

void itoa(int n, char s[])
{
	static int i = 0;
	
	if (n / 10)
		itoa(n / 10, s);

	if (n < 0 && i == 0)
		s[i++] = '-';
	s[i++] = abs(n % 10) + '0';
	s[i] = '\0';
}