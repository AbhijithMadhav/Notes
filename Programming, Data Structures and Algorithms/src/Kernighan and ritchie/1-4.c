/*
 * 1-4.c
 *
 *  Created on: Sep 17, 2009
 *      Author: Abhijith
 */

/* Program to convert Celsius to Fahrenheit */

# include<stdio.h>
int main()
{
	float celsius, fahr;
	int step, low, upper;
	low = 0;
	upper = 300;
	step =20;
	celsius = low;
	printf("Celsius Fahrenheit\n");
	while ( celsius <= upper )
	{
		fahr = (9.0/5.0 * celsius) + 32 ;
		printf("%5.0f   %8.2f\n", celsius, fahr);
		celsius += step;
	}
	return 0;
}
