/*
 * Node.h
 *
 *  Created on: 21-Sep-2010
 *      Author: kempa
 */

#ifndef NODE_H_
#define NODE_H_

class Node
{
public:
	int item;
	Node *next;
	Node(int item, Node *next);
    int getItem() const;
    Node *getNext() const;
    void setItem(int item);
    void setNext(Node *next);

};

typedef Node* lnk;


#endif /* NODE_H_ */
