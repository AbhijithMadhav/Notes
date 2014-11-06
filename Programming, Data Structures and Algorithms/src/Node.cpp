/*
 * Node.cpp
 *
 *  Created on: 21-Sep-2010
 *      Author: kempa
 */

#include"Node.h"

int Node::getItem() const
{
    return item;
}

lnk Node::getNext() const
{
    return next;
}

void Node::setItem(int item)
{
    this->item = item;
}

void Node::setNext(lnk next)
{
    this->next = next;
}

Node::Node(int item, lnk next)
{
	this->item = item;
	this->next = next;
}
