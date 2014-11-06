/*
 * conversions.c
 *
 *  Created on: Dec 5, 2009
 *      Author: Abhijith
 */

#include<stdio.h>
#include<limits.h>
#include<locale.h>

/*
 * Exercise 2-10. Rewrite the function lower, which converts upper case letters to lower case,
 * with a conditional expression instead of if-else.
 */

/* lower: convert c to lower case; ASCII only */
/*
int main()
{

	unsigned char a = 127;
	signed char b = 127;
	char c = 127;


	a = a + 5;
	b = b + 5;
	c = c + 5;


	printf("%c %d\n%c %d\n%c %d\n", a, a, b, b, c, c);
	return 0;
}
*/
#include <stdio.h>
#include <locale.h>

int main()
{
	printf("\u20AC");
    printf("Current locale is: %s\n", setlocale (LC_ALL, ".1250"));
    printf("Euro character: %c\n", 0x80);

    return 0;
}
