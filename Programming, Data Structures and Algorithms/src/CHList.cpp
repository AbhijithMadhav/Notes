/*
 * CHList.cpp
 *
 *  Created on: 29-Sep-2010
 *      Author: kempa
 */

#include "CHList.h"
#include <iostream>

CHList::CHList() {
	head = new Node(0,0);
	head->next = head;
}

CHList::~CHList() {
	delete head;
}

CHList::CHList(int items[], int length)
{
	head = new Node(0,0);
	head->next = head;
	lnk last;
	int i;
	for (last = head, i = 0; i < length; i++, last = last->next )
		last->next = new Node(items[i], head);
}

using std::cout;
using std::endl;

int CHList::josephus(int m, int n)
{
	if (m < 0)
	{
		cout << "Selection interval(m) must be alteast 1" << endl;
		return 0;
	}

	cout << "Order of elimination : ";
	lnk cur = head;
	while(head->next->next != head)
	{
		// i is the count of the no. of nodes traversed.
		// Traverse m - 1 nodes and sit behind the m'th node
		// which is to be deleted
		for ( int i = 0; i < m - 1; i++)
			if (cur->next == head)
				cur = cur->next->next;
			else
				cur = cur->next;

		lnk t;
		if (cur->next == head)
		{
			t = head->next;
			head->next = t->next;
		}
		else
		{
			t = cur->next;
			cur->next= t->next;
		}

		cout << t->item << " ";
		delete t;
	}

	cout << endl << "Last person standing : " << head->next->item << endl;
	return cur->item;
}
