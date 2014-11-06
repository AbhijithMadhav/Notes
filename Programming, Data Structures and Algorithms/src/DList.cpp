/*
 * DList.cpp
 *
 *  Created on: 28-Sep-2010
 *      Author: kempa
 */

#include "DList.h"
#include <iostream>

DList::DList()
{
	head = 0;

}

DList::DList(int items[], int length)
{
	head = 0;
	if (length > 0)
	{
		head = new DNode(items[0], 0, 0);
		dlnk cur = head;
		for (int i = 1; i < length; i++)
			cur = (cur->next = new DNode(items[i], cur, 0));
	}
}

void DList::swap(dlnk t, dlnk u)
{

	if (!t || !u || t == u)
		return;

	/* change links to t and u from their outer neighbours. outer neighbours
	 * are the nodes previous and next to t and u respectively
	 */
	if (t->pre) // t is not head node.
		t->pre->next = u;
	else // t was the head node. Now u is
		head = u;

	if (u->next) // u is not the tail node
		u->next->pre = t;
	/* links of outer neighbours to t and u changed */


	/* change links to t and u from their inner neighbours. inner neighbours
	 * are the nodes next and previous to t and u respectively
	 *
	 * No need to change links if t and u are neighbours as these links
	 * now form the links from t and u to each other and not links from
	 * inner neighbours. They will be changed in the next stage
	 */
	if (t->next != u) // t and u are not next to each other
	{
		u->pre->next = t;
		t->next->pre = u;
	}


	dlnk uNext = u->next;
	dlnk tPre = t->pre;
	/* change outer links of t and u. t->pre & u->next */
	if (t->next != u) // if t and u are not neighbours
	{
		u->next = t->next;
		t->pre = u->pre;
	}
	else // if t and u are neighbours
	{
		u->next = t;
		t->pre = u;
	}

	/* change inner links of t and u. t->next & u->pre*/
	u->pre = tPre;
	t->next = uNext;


}

dlnk DList::getByPosition(int position)
{
	if (position < 0)
		return 0;

	dlnk t;
	for(t = head; t != 0 && position > 0; t = t->next, position--);
	return t;
}

using std::cout;
using std::endl;
void DList::display()
{
	if (head == 0)
		cout << "DList is empty" << endl;
	for (dlnk t = head; t!= 0; t = t->next)
		cout << t->item << " ";
	cout << endl;
}
