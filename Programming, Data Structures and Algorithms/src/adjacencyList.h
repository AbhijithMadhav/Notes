/*
 * adjacencyList.h
 *
 *  Created on: 10-Jun-2011
 *      Author: kempa
 */

#ifndef ADJACENCYLIST_H_
#define ADJACENCYLIST_H_

#include<cstdlib>

#include<list>
using std::list;

#include<string>
using std::string;

#include<vector>
using std::vector;

#include<iostream>
using std::cout;
using std::endl;

class adjacencyList
{
public:
	string label;
	bool visited;
	list<int> edgeList;

	adjacencyList()
	{
		//edgeList = new list<int>();
		visited = false;
	}
	/*vector<adjacencyList>* create(int nv, int ne);
	void stackBasedDepthFirstSearch(vector<adjacencyList> v);
	void visit(adjacencyList *v);
	void print();*/
};

vector<adjacencyList>* create(int nv, int ne);
void stackBasedDepthFirstSearch(vector<adjacencyList> v);
void visit(adjacencyList *v);
#endif /* ADJACENCYLIST_H_ */
