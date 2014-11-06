#include <math.h>
#include <stdio.h>

int main()
{
	double n , term1, term2, term3, temp;

	printf("%15s%15s%15s%15s\n", "N", "N^(3/2)", "N/2*(lgN)^2", "2N*(lgN)^2");
	
	n = 0;
	do
	{
		++n;
		term1 = pow(sqrt(n), 3.0);
		term2 = n/2 * pow(log(n)/log(2), 2.0);
		term3 = 2 * n * pow(log(n)/log(2), 2.0);
		printf("%15.0f%15.2f%15.2f%15.2f\n", n, term2, term1, term3);
	}while(term1 >= term3); 
	temp = n;

	getchar();
	do
	{
		++n;
		term1 = pow(sqrt(n), 3.0);
		term2 = n/2 * pow(log(n)/log(2), 2.0);
		term3 = 2 * n * pow(log(n)/log(2), 2.0);
		printf("%15.0f%15.2f%15.2f%15.2f\n", n, term2, term1, term3);
	}while(term1 <= term3); 


	printf("\nN^(3/2) is between N/2*(lgN)^2 and 2N*(lgN)^2 for values of N between %.f and %.f\n", temp, n-1);
	return 0;
}
