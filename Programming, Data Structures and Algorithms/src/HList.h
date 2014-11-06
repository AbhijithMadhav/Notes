/*
 * HList.h
 *
 *  Created on: 29-Sep-2010
 *      Author: kempa
 */

#ifndef HLIST_H_
#define HLIST_H_
#include "List2.h"
#include "Node.h"
class HList {
	lnk head;
public:
	HList();
	HList(int items[], int length);
	lnk reverse();
	void display();
	virtual ~HList();
};

#endif /* HLIST_H_ */
