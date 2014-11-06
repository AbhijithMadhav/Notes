/*
 * CList.h
 *
 *  Created on: 21-Sep-2010
 *      Author: kempa
 */

#ifndef CLIST_H_
#define CLIST_H_

#include"Node.h"

class CList
{
	lnk handle;
public:
	CList();
	int count();
	lnk insert(int item);
	lnk create(int items[], int length);
	void display();
	lnk getNode(int index);
	int count(lnk p1, lnk p2);
	CList* merge(CList *l2);
    lnk getHandle() const;
    void setHandle(lnk node);
};
#endif /* CLIST_H_ */
