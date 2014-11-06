/*
 * connectedGraph.h
 *
 *  Created on: 12-Jun-2011
 *      Author: kempa
 */

#ifndef CONNECTEDGRAPH_H_
#define CONNECTEDGRAPH_H_

#include"adjacencyList.h"

class connectedGraph
{
	adjacencyList *g;
public:
	connectedGraph(vector<adjacencyList>*);
	connectedGraph create();
	void print();
};
#endif /* CONNECTEDGRAPH_H_ */
