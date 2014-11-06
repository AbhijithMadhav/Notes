/*
 * 1-15.c
 *
 *  Created on: Sep 23, 2009
 *      Author: Abhijith
 */

#include<stdio.h>
#define MAX 300
#define STEP 20

/* Conversion of Celsius to Fahrenheit using a function */

float fahrenheit_to_celsius(float fahrenheit);

int main()
{
	for( int fahrenheit = 0; fahrenheit <= MAX; fahrenheit = fahrenheit + STEP)
		printf("%5d %5.2f\n", fahrenheit, fahrenheit_to_celsius(fahrenheit));
	return 0;
}

float fahrenheit_to_celsius(float fahrenheit)
{
	return ((5.0 / 9.0)*(fahrenheit - 32));
}
