/*
 * 1-3.c
 *
 *  Created on: Sep 17, 2009
 *      Author: Abhijith
 */

#include <stdio.h>
/* print Fahrenheit-Celsius table
 for fahr = 0, 20, ..., 300; floating-point version */
int main() {
	float fahr, celsius;
	float lower, upper, step;
	lower = 0; /* lower limit of temperature scale */
	upper = 300; /* upper limit */
	step = 20; /* step size */
	fahr = lower;

	printf("Fahrenheit Celsius\n");
	while (fahr <= upper) {
		celsius = (5.0 / 9.0) * (fahr - 32.0);
		printf("%6.0f %9.1f\n", fahr, celsius);
		fahr = fahr + step;
}
	return 0;
}
