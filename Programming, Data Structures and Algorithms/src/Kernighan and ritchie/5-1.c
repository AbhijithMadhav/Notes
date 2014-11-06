
#include<stdio.h>

#define SIZE 10



int main()
{
	int n, array[SIZE], getint(int *), c;
	for (n = 0; n < SIZE && (c = getint(&array[n])) != EOF; n++)
		if (c != 0)
			printf("%d %d\n", c, array[n]);
	return 0;
}