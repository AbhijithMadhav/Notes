/*
 * HList.cpp
 *
 *  Created on: 29-Sep-2010
 *      Author: kempa
 */

#include "HList.h"
#include <iostream>
HList::HList()
{
	head = new Node(0,0);
}

HList::~HList()
{
	delete head;
}

HList::HList(int items[], int length)
{
	int i;
	lnk last;
	head = new Node(0,0);
	for(last = head, i = 0; i < length; i++)
		last = (last->next = new Node(items[i], 0));
}

lnk HList::reverse()
{

	// Contrary to expectation prev is not set to head to enable the
	//   last node 'to-become' first node to point to null instead of head
	lnk prev = 0;
	lnk cur = head->next;
	while (cur!= 0)
	{
		lnk t = cur;
		cur = cur->next;
		t->next = prev;
		prev = t;
	}
	head->next = prev; // extra in HList
	return head;

}

void HList::display()
{
	if (head->next == 0)
		std::cout << "List is empty" << std::endl;
	for (lnk t = head->next; t!= 0; t = t->next)
		std::cout << t->item << " ";
	std::cout << std::endl;
}


