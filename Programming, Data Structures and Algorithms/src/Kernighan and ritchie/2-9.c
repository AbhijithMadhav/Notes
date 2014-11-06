/* bitcount: count 1 bits in x */
int bitcount(unsigned x)
{
	int b;
	for (b = 0; x != 0; x &= (x - 1))
		b++;
	return b;
}

int main()
{
	int x;
	printf("Number: ");
	scanf("%d", &x);
	printf("\nNumber of 1's: %d\n", bitcount(x));
	getch();
	return 0;
}