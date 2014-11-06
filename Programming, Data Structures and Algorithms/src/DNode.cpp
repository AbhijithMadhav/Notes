/*
 * DNode.cpp
 *
 *  Created on: 28-Sep-2010
 *      Author: kempa
 */

#include "DNode.h"

DNode::DNode(int item, dlnk pre, dlnk next) {
	this->item = item;
	this->next = next;
	this->pre = pre;
}
