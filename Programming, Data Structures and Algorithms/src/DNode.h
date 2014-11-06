/*
 * DNode.h
 *
 *  Created on: 28-Sep-2010
 *      Author: kempa
 */

#ifndef DNODE_H_
#define DNODE_H_

/*
 * DNode.h
 *
 *  Created on: 28-Sep-2010
 *      Author: kempa
 */

class DNode {
public:
	int item;
	DNode *next;
	DNode *pre;
	DNode(int item, DNode *pre, DNode *next);
};

typedef DNode* dlnk;
#endif /* DNODE_H_ */
