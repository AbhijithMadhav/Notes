/*
 * List.cpp
 *
 *  Created on: 24-Sep-2010
 *      Author: kempa
 */
#include <iostream>
#include "List2.h"

/**
 * Moves smallest element to the first node of the list
 *
 */
void List::smallestFirst()
{
	/* 't' is used to traverse
	 * 's' points to the node containing the smallest item.
	 *     Initially initially assumed to be the first one
	 *  'pt' points to the previous node of 't'
	 *  'ps' points to the previous node of 's'
	 */
	lnk t, s, pt, ps;

	/* Find the node with the smallest element */
	for (t = head, s = t, pt = 0, ps = pt; t!= 0; pt = t, t = t->next)
		if (t->item < s->item)
		{
			s = t;
			ps = pt;
		}

	/* Move to the first position */
	if (head != 0 && head->next != 0 && s != head) // (s == 0) <==> list is empty.Nothing needs to be done
	{                          // (head->next == 0) <==> There is only one node. Nothing needs to be done
		                       // (s == head) <==> smallest is at first position. " " "
		if (s->next == 0) // smallest = last.
			ps->next = 0;
		else
			ps->next = s->next;
		s->next = head;
		head = s;
	}
}


/**
 * Counts the number of nodes
 *
 * @return Number of nodes
 */
int List::getNumNodes()
{
	int n = 0;
	if (head != 0)
	{
		n = 1;
		for (lnk t = head; t != 0; t = t->next, n++);
	}
	return n;
}

/**
 * Default constructor
 * @return
 */
List::List()
{
	head = 0;
}

/**
 * Copy constructor
 *
 * @param a
 * @return
 */
List::List(List &a)
{
	if (a.head != 0)
	{
		head = new Node(a.head->item, 0);
		lnk temp = head;
		for (lnk t = a.head->next; t != 0; t = t->next)
		{
			lnk x = new Node(t->item, 0);
			temp = insertAfter(x, temp);
		}
	}


}


/**
 * Determines the last node
 *
 * @return Handle to last node
 */
/*lnk List::last()
{
	lnk l = 0;
	if (head != 0)
		for (l = head; l->next != 0; l = l->next);
	return l;
}*/

/**
 * Determines node by position number.
 *
 * Position number starts with 0
 *
 * @param position Position number of the node
 * @return Handle to node at 'position'. NULL is position is negative
 */
lnk List::getByPosition(int position)
{
	if (position < 0)
		return 0;

	lnk t;
	for(t = head; t != 0 && position > 0; t = t->next, position--);
	return t;
}


/**
 * Insert node x after t
 *
 * Node 'x' is an external node and does not already belong to the list
 *
 * @param x Pointer to node to be inserted
 * @param t Pointer to node after which node x must be inserted
 *
 * @return x
 */
lnk List::insertAfter(lnk x, lnk t)
{
	if (t == 0)
	{
		head = x;
		head->next = 0;
	}
	else
	{
		x->next = t-> next;
		t->next = x;
	}
	return x;
}

/**
 * Relocate node after ps to after pd
 *
 * @param ps pointer to node previous to source node
 * @param pd pointer to node after which the source node must be relocated
 * @return pointer to the relocated source node
 */
/*lnk List::relocate(lnk ps, lnk pd)
{
	lnk s;
	if (ps == 00 && pd == 0) // 1st node must be relocated to the first position
		s = head;
	else if (ps == 0) // 1st node must be relocated to (pd + 1)
	{
		s = head;
		head = head->next;
		s->next = ps->next;
		ps->next = s;
	}
	else if (pd == 0) // (ps + 1) must be relocated to the head of the list
	{
		s = ps->next;
		ps->next = ps->next->next;
		s->next = head->next;
		head = s;
	}
	else if (pd == ps->next) // can't move the source next to itself
		s = 0;

	else
	{
		s = ps->next;
		ps->next = ps->next->next;
		s->next = pd->next;
		ps->next = s;
	}
	return s;
}*/

/**
 * Swap nodes pointed to by t->next and u->next
 *
 * @param t The node previous to the first node to be swapped
 * @param u The node previous to the second node to be swapped
 */
void List::swap(lnk t, lnk u)
{

	if (t == u) // t and u are the same
		return;
	else if (t == 0) // head node must be swapped
	{
		if (u == head)
		{
			lnk headNext = head->next;
			head->next = head->next->next;
			headNext->next = head;
			head = headNext;
		}
		else
		{
		lnk headNext = head->next;
		head->next = u->next->next;
		u->next->next = headNext;
		lnk headT = head;
		head = u->next;
		u->next = headT;
		}
	}
	else if (t->next == u) // u is next to t
	{
		t->next = u->next;
		u->next = u->next->next;
		t->next->next = u;
	}
	else // There is at least node between t and u
	{
		lnk tNextNext = t->next->next, tNext = t->next;
		t->next->next = u->next->next;
		u->next->next = tNextNext;
		t->next = u->next;
		u->next = tNext;
	}
}


/**
 * Moves largest item to the final node of the list.
 *
 */
void List::largestLast()
{
	/* 't' is used to traverse
	 * 'b' points to the node containing the largest item.
	 *     Initially initially assumed to be the first one
	 *  'pt' points to the previous node of 't'
	 *  'pb' points to the previous node of 'b'
	 */
	lnk t, b, pt, pb;

	/* Find the node with the largest element */
	for (t = head, b = t, pt = 0, pb = pt; t!= 0; pt = t, t = t->next)
		if (t->item > b->item)
		{
			b = t;
			pb = pt;
		}

	/* Move to the last position */
	// pt is pointing to the last node
	if (head != 0 && head->next != 0 && b->next != 0) // (head == 0) <==> list is empty.Nothing needs to be done
	{                          // (head->next == 0) <==> There is only one node. Nothing needs to be done
		                       // (b->next = 0) <==> largest is last. Nothing needs to be done
		if (b == head) // head == largest.
			head = head->next;
		else
			pb->next = b->next;
		b->next = 0;
		pt->next= b;
	}
}

/**
 * Create a linear linked list with the values in 'items'
 * @param items array containing values to constitute the linked list
 * @param length length of 'items'
 * @return pointer to 'List object encapsulating the linear list
 */
List::List(int items[], int length)
{
	head = 0;
	if (length > 0)
	{
		head = new Node(items[0], 0);
		lnk t = head;
		for(int i = 1; i < length; i++)
			t = (t -> next = new Node(items[i], 0));
	}
}

/**
 * Display the contents of the linear list
 */
void List::display()
{
	if (head == 0)
		std::cout << "List is empty" << std::endl;
	for (lnk t = head; t!= 0; t = t->next)
		std::cout << t->item << " ";
	std::cout << std::endl;
}

/**
 * Rearrange the list with the odd nodes occurring before the even nodes and the
 * relative order of the even and odd nodes maintained
 */
void List::rearrange()
{
	lnk odd = 0, even = 0, t;
	lnk evenStart = head->next;
	int count;

	for (t = head, count = 1; t->next != 0; count++)
	{
		if (count % 2 == 0)
		{
			even = t;
			t = t->next;
			even->next = t->next;
		}
		else
		{
			odd = t;
			t = t->next;
			odd->next = t->next;
		}
	}
	if (odd->next == 0)
		odd->next = evenStart;
	else
		odd->next->next = evenStart;
}

/**
 * deletes all nodes in list for whom *funcptr returns a non-zero value
 *
 * @param funcptr function pointer to function which takes a link to a node
 */
void List::remove(int (*funcptr)(lnk u))
{
	for (lnk cur = head, p = 0; cur != 0; )
		if ((*funcptr)(cur))
		{
			if (cur == head)
			{
				head = head->next;
				delete cur;
				cur = head;
				p = 0;
			}
			else
			{
				lnk t = cur;
				p->next = cur->next;
				cur = cur->next;
				delete t;
			}
		}
		else
		{
			p = cur;
			cur = cur->next;
		}
}


/**
 * Creates a new list out of all all nodes in given list for whom *funcptr returns a non-zero value
 * Removes those nodes from the original list
 *
 * @param funcptr function pointer to function which takes a link to a node
 */
List* List::removeCreate(int (*funcptr)(lnk u))
{
	List *b = new List();
	lnk t = 0;
	for (lnk cur = head, p = 0; cur != 0; )
	{
		if ((*funcptr)(cur))
		{
			// Remove
			if (cur == head)
			{
				head = head->next;
				t = cur;
				cur = head;
				p = 0;
			}
			else
			{
				t = cur;
				p->next = cur->next;
				cur = cur->next;
			}

			// insert removed node into the new list
			lnk lastB = 0;
			lastB = b->insertAfter(t, lastB);
		}
		else
		{
			p = cur;
			cur = cur->next;
		}
	}
	return b;
}

/**
 * Sorts list using insertion sort
 */
void List::insertionSort()
{
	List *b = new List();
	lnk curB, preB;
	while(head != 0)
	{
		lnk cur = head;
		head = head->next;
		cur->next = 0;
		if (b->head == 0)
			b->head = cur;
		else
		{
			for (curB = b->head, preB = 0; curB != 0; preB = curB, curB = curB->next)
				if (cur->item < curB->item)
					break;
			cur->next = curB;
			if (preB)
				preB->next = cur;
			else
				b->head = cur;
		}
	}
	this->head = b->head;
	delete b;
}
