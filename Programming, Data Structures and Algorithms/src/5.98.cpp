/*
 * main.cpp
 *
 *  Created on: 11-Jun-2011
 *      Author: kempa
 */

/*
 * 5.98 Implement a stack-based depth-first search for graphs that are
 *  represented with adjacency lists.
 */

#include "adjacencyList.h"

#include<iostream>
#include<cstddef>
using std::cout;
using std::endl;

#include<cstdlib>

#include<vector>
using std::vector;

// Maximum number of vertices allowed
#define MAX 100

int main()
{
	srand(time(NULL));
	int nv = rand() % MAX + 2; // there must be atleast 2 vertices
	int ne = nv - 1 + rand() % ((nv * (nv - 1) / 2 )); // there must be atleast nv - 1 edges to ensure connectivity, Max of n(n-1)/2 edges to avoid parallel edges


	vector<adjacencyList> *t = create(nv, ne);
	vector<adjacencyList> &v = *t;

	cout << "vertices : " << nv << endl;
	cout << "edges : " << ne << endl;
	cout << endl << "adjacency list :" << endl;
	for (unsigned i = 0; i < v.size(); i++)
	{
		cout << v[i].label << " : ";
		for (list<int>::iterator k = v[i].edgeList.begin(); k
				!= v[i].edgeList.end(); k++)
			cout << *k << " ";
		cout << endl;
	}
	cout.flush();
	cout << "Stack based depth first search : ";
	stackBasedDepthFirstSearch(v);
	return 0;
}
