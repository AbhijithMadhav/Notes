/*
 * CHList.h
 *
 *  Created on: 29-Sep-2010
 *      Author: kempa
 */

#ifndef CHLIST_H_
#define CHLIST_H_
#include "Node.h"

class CHList {
	lnk head;
public:
	CHList();
	CHList(int items[], int length);
	int josephus(int m, int n);
	virtual ~CHList();
};



#endif /* CHLIST_H_ */
