/* usage: ./a.out <n> <m>
 *       <n> number of people are there in the circle
 *       Every <m>th person is executed
 */

#include<iostream>
#include<stdlib.h>
#define FIRST 0
int main(int argc, char* argv[])
{
	int n, m, x;
	n = atoi(argv[1]);
	m = atoi(argv[2]);

	int *item = new int[n-1];
	int *next = new int[n-1];

	for (int i = 0; i < n; ++i)
	{
		item[i] = i + 1;
		next[i] = (i + 1) % (n);
	}

	/* Every run of the while loop results in the m'th element
	 * being deleted
	 */
	x = n - 1; /* Temporary pointer used to traverse the list */
	while (next[x] != x)
	{
		/* The for loop results in x traversing m-1 links
		 * to get to m-1'th node, i.e just behind the m'th
		 * node which is to be removed.
		 *
		 * Note: if x is initially pointing to the first node, 
		 * the above condition cannot be fulfilled when m is 1
		 */
		for (int count = 1; count < m; ++count)
			x = next[x];
		std::cout<< item[next[x]] << " ";
		next[x] = next[next[x]]; /* Delete */
	}
        std::cout << item[x] << std::endl;

	return 0;
}
