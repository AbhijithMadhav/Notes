/* 
 * Exercise 2-7. Write a function invert(x,p,n) that returns x with the n bits that begin at
 * position p inverted (i.e., 1 changed into 0 and vice versa), leaving the others unchanged.
 */

unsigned invert(unsigned x, int p, int n)
{
	//printf("%o\n", ~(x & (~(~0 << p) | ~(~0 << (p-n)))));
	 return((x & (~0 << p) | ~(~0 << (p-n))) | (~x & ~((~0 << p) | ~(~0 << (p-n)))));
}


int main()
{
	unsigned x = 0174;
	int p = 3, n = 3;
	printf("%o\n", invert(x, p, n));
	getch();
	return 0;
}