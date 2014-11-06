/*
 * 1-5.c
 *
 *  Created on: Sep 18, 2009
 *      Author: Abhijith
 */

#include<stdio.h>

/* Print a Fahrenheit-0Celsius Table */
int main()
{
	int fahr;
	printf("Fahrenheit Celsius\n");
	for(fahr = 300 ; fahr >= 0 ; fahr -= 20)
	{
		printf("%6d     %5.1f\n", fahr, (5.0/9.0)*(fahr-32));
	}
	return 0;
}
