
/*
 * 1.8 Do Exercise 1.4, but use the weighted quick-union algorithm with path compression by halving (Program 1.4).
 */
#include <iostream>
using namespace std;
int main()
{
	int a_f = 0, a_u = 0;
	int i, j, N, p, q, id[100], sz[100];
	cin >> N;
	for (i = 0; i < N; i++)
	{
		id[i] = i;
		sz[i] = 1;
	}
	while (cin >> p >> q)
	{
		for (i = p; ++a_f, i != id[i]; ++a_f, i = id[i])
		{
			id[i] = id[id[i]];
			a_f += 3;
		}
		for (j = q; ++a_f, j != id[j]; ++a_f, j = id[j])
		{
			id[j] = id[id[j]];
			a_f += 3;
		}
		if (i == j)
			continue;
		if (sz[i] < sz[j])
		{
			id[i] = j;
			a_u++;
			sz[j] += sz[i];
		} else
		{
			id[j] = i;
			a_u++;
			sz[i] += sz[j];
		}
		cout << " " << p << " " << q << ":" << a_f << endl;
	}
	cout << "Array Access = Access for find + Access for union" << endl;
	cout << a_f + a_u << " = " << a_f << " + " << a_u << endl;
	return 0;
}
