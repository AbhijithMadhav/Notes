
/*
 * 1.16 Show how to modify Program 1.3 to implement
 * full path compression, where we complete each 
 * union operation by making every node that we 
 * touch point to the root of the new tree.
 */

#include <iostream>
using namespace std;
int main()
{
	int i, j, N, p, q, k, temp, id[100], sz[100];
	cin >> N;
	for (i = 0; i < N; i++)
	{
		id[i] = i;
		sz[i] = 1;
	}
	while (cin >> p >> q)
	{
		for (i = p; i != id[i]; i = id[i]) ;
		for (j = q; j != id[j]; j = id[j]) ;

		if (i == j)
			continue;
		if (sz[i] < sz[j])
		{
			id[i] = j;
			sz[j] += sz[i];
			for (k = p; k != id[k];
			     temp = k, k = id[k], id[temp] = j) ;
			for (k = q; k != id[k];
			     temp = k, k = id[k], id[temp] = j) ;
		} else
		{
			id[j] = i;
			sz[i] += sz[j];
			for (k = p; k != id[k];
			     temp = k, k = id[k], id[temp] = i) ;
			for (k = q; k != id[k];
			     temp = k, k = id[k], id[temp] = i) ;
		}
		cout << " " << p << " " << q << endl;
		for (k = 0; k < N; ++k)
			cout << id[k] << " ";
		cout << endl;
	}
	return 0;
}
