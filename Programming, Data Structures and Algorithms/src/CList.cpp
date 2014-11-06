/** CList.cpp
 *
 *  Created on: 21-Sep-2010
 *      Author: kempa
 */

#include<iostream>
#include"CList.h"



CList::CList()
{
	handle = 0;
}


lnk CList::insert(int item)
{
	lnk last = 0;
	if (handle == 0)
	{
		handle = new Node(item, 0);
		handle->setNext(handle);
		last = handle;
	}
	else
	{
		last->setNext(new Node(item, handle));
		last = last->getNext();
	}
	return handle;
}

lnk CList::create(int items[], int length)
{
	lnk t;
	for(int i = 0; i < length; ++i)
		t = insert(items[i]);
	return t;

}



void CList::display()
{
	lnk t;
	int index = 0;
	if (handle != 0)
	{
		for (t = handle, index = 0; t->getNext() != handle; t = t->getNext(), index++)
			std::cout << index << " : " << t->getItem() << std::endl;
		std::cout << index << " : " << t->getItem() << std::endl;
	}
	else
		std::cout << "C-List is empty" << std::endl;
}

int CList::count()
{
	int count;
	lnk t;
	if (handle == 0)
		count = 0;
	else
		for (t = handle->getNext(), count = 1; t != handle ; t = t->getNext(), count++);
	return count;
}

/* Return pointer to index'th node. Index starts from 0 */
lnk CList::getNode(int index)
{
	Node *t;
	if (index >= count())
		t = 0;
	else
	{
		int i;
		for (i = 0, t = handle; i < index; ++i)
			t = t->getNext();
	}
	return t;

}



int CList::count(Node *p1, Node *p2)
{
	int count;
	Node *t = p1;
	for (t = p1, count = 0; t->getNext() != p2; t = t->getNext(), count++);
	return count;

}


/**
 * Merges two disjoint circular lists
 *
 * Given a handle to a secondary circular list, merges it with the circular list
 * associated with the invoking object.
 * The second list is inserted after the node pointed to by the handle
 * of the invoking object
 * Nullifies the handle/pointer associated with the second list
 *
 * @param p Handle/Pointer to the secondary circular list
 * @return Handle/Pointer to the merged list
 */
CList *CList::merge(CList *l2)
{
	Node *t, *p = l2->getHandle();

	if (handle == 0)
		handle = p;
	else if (p == 0)
		;
	else
	{
		// Traverse to the last node of the list pointed by p
		for(t = p->getNext(); t->getNext() != p; t = t->getNext());

		// Make the last node of p point to the 'next to first node'(second node) of this list
		t->setNext(handle->getNext());

		// Make the next to first node of this list point to p
		handle->setNext(p);
	}

	l2->setHandle((Node*)0);
	return this;
}

/**
 * getter method. Returns a handle to the circular list associated with the object
 *
 * @return pointer to the circular list
 */
Node *CList::getHandle() const
{
	return handle;
}


/**
 * setter method. Sets the handle
 * @param node sets the handle associated with invoking object to 'node'
 */
void CList::setHandle(Node *handle)
{
	this->handle = handle;
}

