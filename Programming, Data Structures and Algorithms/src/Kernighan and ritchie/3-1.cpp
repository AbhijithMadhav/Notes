/* Our binary search makes two tests inside the loop, when one would suffice (at
 * the price of more tests outside.) Write a version with only one test inside the loop and measure
 * the difference in run-time.
 */
#include<stdio.h>
#include<time.h>

int binsearch(int key, int v[], int size);
int k_r_binsearch(int key, int v[], int size);

int main()
	{
	int v[] = {00, 10, 20, 30, 40, 50, 60, 70, 80, 90};
	int key, found;
	clock_t my_time, k_r_time;
	int i;
	printf("Enter Key\n");
	scanf("%d", &key);

		k_r_time = clock();
	for (i = 0; i < 1000000 ; ++i)
		found = k_r_binsearch(key, v, sizeof(v)/sizeof(int));
	k_r_time = clock() - k_r_time;
	printf("Time taken for k&r search= %d clock ticks\n", k_r_time);

		my_time = clock();
	for (i = 0; i < 1000000 ; ++i)
		found = binsearch(key, v, sizeof(v)/sizeof(int));
	my_time = clock() - my_time;
	printf("Time taken for my search = %d clock ticks\n", my_time);




	

//	printf("Speedup : %f", (k_r_time - my_time)/(double)my_time * 100.00);
	getchar();
	getchar();
	}

int binsearch(int key, int v[], int size)
	{
	int mid;
	int low = 0;
	int high = size - 1;

	while (low < high)
		{
		mid = (low + high) / 2;
		if (key <= v[mid])
			high = mid;
		else
			low = mid + 1;
		}
	return((key == v[low])?low : -1);
	}

int k_r_binsearch(int key, int v[], int size)
	{
	int mid;
	int low = 0;
	int high = size - 1;

	while (low <= high)
		{
		mid = (low + high) / 2;
		if (key < v[mid])
			high = mid - 1;
		else if (key > v[mid])
			low = mid + 1;
		else
			return mid;
		}
	return -1;
	}
