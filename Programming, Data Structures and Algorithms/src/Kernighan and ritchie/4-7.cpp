/* Exercise 4-7. Write a routine ungets(s) that will push back an entire string onto the input.
Should ungets know about buf and bufp, or should it just use ungetch?
*/

#include <stdio.h>
#include "calc.h"
#define MAX 10

int main()
{
	char s[MAX] = "012345678";
	int i = 0;
//	while (i != 10)
		s[i++] = getch();
	s[i] = '\0';
	ungets("876");
	putchar(getch());
	getchar();
	getchar();
}