#include <math.h>
#include <stdio.h>

int main()
{
	int i;

	printf("%10s%10s%10s\n", "N", "10NlgN", "2N^2");
	for (i = 1; i < 40; ++i)
		printf("%10d%10.2f%10.2f\n", i, 10 * i * log(i)/log(2), 2 * pow(i, 2));
	return 0;
}
