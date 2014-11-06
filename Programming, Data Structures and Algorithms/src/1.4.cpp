
/*
 * 1.4 Show the contents of the id array after each union operation when you use the quick-find algorithm (Program 1.1) to solve the connectivity problem for the sequence 0-2, 1-4, 2-5, 3-6, 0-4, 6-0, and 1-3. Also give the number of times the program accesses the id array for each input pair
 */

#include <iostream>

static const int N = 1000;

using namespace std;

int main()
{
#ifdef ILLUSTRATE
	/* Counters to measure access to arrays */
	int ax_f = 0;		// Accesses during 'find'
	int ax_u = 0;		// Accesses during 'union'
	cout << "i/p  ";
#endif

	int i, p, q, id[N], n;
	cin >> n;
	for (i = 0; i < n; i++)
	{
#ifdef ILLUSTRATE
		cout << "  " << i << "  ";
#endif
		id[i] = i;
	}

#ifdef ILLUSTRATE
	cout << "   o/p";
	cout << endl;
	cout << "----------------------------------------------" << endl;
#endif

	while (cin >> p >> q)
	{
		int t = id[p];
#ifdef ILLUSTRATE
		cout << p << "-" << q;
		cout << " :";
		ax_f++;
#endif

		/* 'find' operation */
#ifdef ILLUSTRATE
		cout << " Are " << p << " and " << q <<
		    " connected to each other? ";
		ax_f++;
#endif
		if (t == id[q])
		{
#ifdef ILLUSTRATE
			cout << "Yes" << endl;
#endif
			continue;
		}
#ifdef ILLUSTRATE
		cout << "No. Connect all nodes connected to the node to which "
		    << p << " is connected to the node to which " << q <<
		    " is connected" << endl;
		cout << "     ";
#endif

		/* Union operation */
		for (i = 0; i < n; i++)
		{
#ifdef ILLUSTRATE
			ax_u++;
#endif
			if (id[i] == t)
			{
				id[i] = id[q];
#ifdef ILLUSTRATE
				ax_u += 2;
				cout << " |" << id[i] << "| ";
				continue;
#endif
			}
#ifdef ILLUSTRATE
			cout << "  " << id[i] << "  ";
#endif
		}
		cout << " : " << p << "-" << q << endl;
	}
#ifdef ILLUSTRATE
	cout << endl <<
	    "Number of access instructions = Access for find + Access for union"
	    << endl << ax_f + ax_u << " = " << ax_f << " + " << ax_u << endl;
#endif
}
