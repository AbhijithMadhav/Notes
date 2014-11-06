/* 
 * Exercise 2-10. Rewrite the function lower, which converts upper case letters to lower case,
 * with a conditional expression instead of if-else.
 */

/* lower: convert c to lower case; ASCII only */

#include<stdio.h>

int lower(int c)
{
	return((c >= 'A' && c <= 'Z') ? (c + 'a' - 'A') : c);
}

int main()
{
	int c;
	printf("Uppercase: ");
	c = getchar();
	printf("\nLowercase: %c", lower(c));
	getch();
	return 0;
}