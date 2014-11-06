
#include<stdio.h>

#define SIZE 10



int main()
{
	int n, c, getfloat(double *);
	double array[SIZE];
	for (n = 0; n < SIZE && (c = getfloat(&array[n])) != EOF; n++)
		if (c != 0)
			printf("%d %g\n", c, array[n]);
	return 0;
}