/*
 * list.h
 *
 *  Created on: 01-Oct-2010
 *      Author: kempa
 */

#ifndef UNIFORMMEMORYALLOCATIONFORLISTUSINGARRAY_H_
#define UNIFORMMEMORYALLOCATIONFORLISTUSINGARRAY_H_
typedef int Item;
typedef int lnk;
struct node
{
	Item item;
	lnk next;

	node(){}
	node(int x, lnk t)
	{
		item = x;
		next = t;
	}
};
typedef lnk Node;

void construct(int);
Node newNode(Item);
void deleteNode(Node);
void insert(Node, Node);
Node remove(Node);
Node next(Node);
Item item(Node);

#endif /* UNIFORMMEMORYALLOCATIONFORLISTUSINGARRAY_H_ */
