
/* 1.5 Do Exercise 1.4, but use the quick-union algorithm (Program 1.2). */

#include <iostream>
using namespace std;
int main()
{

#ifdef ILLUSTRATE
	int a_f = 0, a_u = 0;
#endif
	int i, j, p, q, N, id[100];
	cin >> N;

	for (i = 0; i < N; i++)
		id[i] = i;
	while (cin >> p >> q)
	{
#ifdef ILLUSTRATE
		for (i = p; ++a_f, i != id[i]; i = id[i], ++a_f) ;
		for (j = q; ++a_f, j != id[j]; j = id[j], ++a_f) ;
#else
		for (i = p; i != id[i]; i = id[i]) ;
		for (j = q; j != id[j]; j = id[j]) ;
#endif

		if (i == j)
			continue;
		id[i] = j;
#ifdef ILLUSTRATE
		a_u++;
#endif
		cout << " " << p << " " << q << endl;
	}
#ifdef ILLUSTRATE
	cout << "Array Access = Access for find + Access for union" << endl;
	cout << a_f + a_u << " = " << a_f << " + " << a_u << endl;
#endif
	return 0;
}
