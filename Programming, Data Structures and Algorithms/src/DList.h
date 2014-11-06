/*
 * DList.h
 *
 *  Created on: 28-Sep-2010
 *      Author: kempa
 */

#ifndef DLIST_H_
#define DLIST_H_
#include "DNode.h"

class DList {
	dlnk head;
public:
	DList();
	DList(int items[], int length);
	void swap(dlnk t, dlnk u);
	dlnk getByPosition(int pos);
	void display();
};

#endif /* DLIST_H_ */
