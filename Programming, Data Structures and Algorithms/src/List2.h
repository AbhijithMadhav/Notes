/*
 * List.h
 *
 *  Created on: 24-Sep-2010
 *      Author: kempa
 *
 *      Interface to a linear linked list with no head on tail dummy nodes
 */

#ifndef LIST_H_
#define LIST_H_

#include "Node.h"

class List
{
	lnk head;
public:
	List();
	List(int items[], int length);
	void display();
	void largestLast();
	void smallestFirst();
	void rearrange();
	lnk getByPosition(int position);
	void swap(lnk t, lnk u);
	lnk insertAfter(lnk x, lnk t);
	List(List &a);
	void remove(int (*funcptr)(lnk u));
	List* removeCreate(int (*funcptr)(lnk u));
	void insertionSort();
	//lnk last();
	int getNumNodes();

	//lnk relocate(lnk x, lnk t);
};

#endif /* LIST_H_ */
