/*
 * 1-6.c
 *
 *  Created on: Sep 18, 2009
 *      Author: Abhijith
 */

#include<stdio.h>

/* Program to verify getchar() != EOF is 0 or 1 */

int main()
{
	int c;
	c = (getchar() != EOF);
	printf("%d\n", c);
	return 0;
}
