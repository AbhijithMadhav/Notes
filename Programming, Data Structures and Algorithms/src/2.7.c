#include <math.h>
#include <stdio.h>

int main()
{
	double n, term1, term2, Hn;

	printf("%10s%10s%10s\n", "N", "2NHn - N", "NlgN + 10N");

	n = 0;
	do
	{
		++n;
		for ( int i = 1, Hn = 0; i <= n; ++i)
			Hn += 1.0/i;

		term1 = 2 * n * Hn - n;
		term2 = n * log(n)/log(2) + 10 * n;
    printf("%10.0f%10.2f%10.2f\n", n, term1, term2);
	}while(term1 > term2);

	return 0;
}
