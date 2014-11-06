/* Exercise 5.4 */

/* Link with -largtable2 */
#include<stdio.h>

static int count = 0;
int main(int argc, char *argv[])
{
	int puzzle(long long);
	int i, n = 0, max_count = count;
	for (i = 1; i < 1000000; ++i)
	{
			puzzle(i);
			if (count > max_count)
			{
				max_count = count;
				n = i;
			}
			count = 0;
		}
	printf("Number of recursive calls of puzzle(%d) : %d(Max count)\n", n, max_count);
	return 0;
}

int puzzle(long long N)
{
	count++;
	if (N == 1)
		return 1;
	if (N % 2 == 0)
		return puzzle(N/2);
	else
		return puzzle(3 * N + 1);
}
