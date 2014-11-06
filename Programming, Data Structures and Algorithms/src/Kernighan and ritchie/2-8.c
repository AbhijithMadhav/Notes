/*
 * Exercise 2-8. Write a function rightrot(x,n) that returns the value of the integer x rotated
 * to the right by n positions.
 */

unsigned rightrot(unsigned x, int n)
{
	return((x >> n) | ((x & ~(~0 << n)) << ((sizeof(x) * 8) - n)));
}

int main()
{
	int n = 2;
	unsigned x = 0x3;
	printf("%x\n", rightrot(x, n));
	getch();
	return 0;
}