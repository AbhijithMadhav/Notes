/* Exercise 2-6. Write a function setbits(x,p,n,y) that 
 * returns x with the n bits that begin at
 * position p set to the rightmost n bits of y, 
 * leaving the other bits unchanged
 */

int setbits(int x, int p, int n, int y)
{
	return((x & ((~0 << p) | ~(~0 << (p-n)))) | ((y & ~(~0 << n)) << (p-n)));
//	return((x & ((~0 << p) | ~(~0 << (p-n)))) | (y & ~((~0 << p) | ~(~0 << (p-n)))));
}
	
int main()
{
	int x, y, p, n;
	x = 0100;
	y = 0777;
	p = 9;
	n = 3;
	printf("%o\n", setbits(x, p, n, y));
	getch();
}