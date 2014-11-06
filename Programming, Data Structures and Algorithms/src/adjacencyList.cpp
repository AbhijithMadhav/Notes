/*
 * adjacencyList.cpp
 *
 *  Created on: 12-Jun-2011
 *      Author: kempa
 */

#include "adjacencyList.h"

#include <stack>
using std::stack;

#include <vector>
using std::vector;

#include <list>
using std::list;

#include<iostream>
using std::cout;
using std::endl;

#include<sstream>
using std::stringstream;

#include<algorithm>

void visit(adjacencyList *v)
{
	cout << v->label << " ";
	v->visited = true;
	cout.flush();
}

/*
 *
 */
void stackBasedDepthFirstSearch(vector<adjacencyList> v)
{
	stack<adjacencyList> s;
	s.push(v[0]);
	//visit(&(s.top()));
	cout << s.top().label << " ";
	v[0].visited = true;
	cout.flush();

	while (!s.empty())
	{
		if (v[s.top().edgeList.front()].visited == false)
		{
			visit(&(v[s.top().edgeList.front()]));
			int save = s.top().edgeList.front();
			s.top().edgeList.pop_front();
			s.push(v[save]);
		}
		else
		{
			s.top().edgeList.pop_front();
			if (s.top().edgeList.empty())
				s.pop();
		}
	}
}

/*
 * creates an adjacency list
 */
vector<adjacencyList>* create(int nv, int ne)
{
	if (ne < nv - 1 || ne > (nv * (nv - 1) / 2))
	{
		cout << "Edges must be b/w " << nv - 1 << " and " << (nv * (nv - 1) / 2) << endl;
		return NULL;
	}
	else if (nv < 2)
	{
		cout << "There must be at least 2 vertices\n";
		return NULL;
	}

	srand(time(NULL));

	// create an array of vertices
	vector<adjacencyList> &v =
			*(new vector<adjacencyList> (nv));

	for (int i = 0; i < nv; i++)
	{
		// label created vertex
		stringstream ss;
		ss << i;
		v[i].label = ss.str();

		// initially ensure that the graph is connected by seeing that it has
		//  at least one adjacent vertex
		if (v[i].edgeList.empty())
		{

			int x;
			while ((x = rand() % nv) == i)
				;
			v[i].edgeList.push_back(x);
			v[x].edgeList.push_back(i); //this is an undirected graph
			ne--;
		}
	}

	//create the remaining edges
	for (; ne != 0; ne--)
	{
		int x = rand() % nv;
		int y;
		while (((y = rand() % nv) == x) || (std::find(v[x].edgeList.begin(),
				v[x].edgeList.end(), y) != v[x].edgeList.end()))
			;
		v[x].edgeList.push_back(y);
		v[y].edgeList.push_back(x); //this is an undirected graph
	}
	return &v;
}


