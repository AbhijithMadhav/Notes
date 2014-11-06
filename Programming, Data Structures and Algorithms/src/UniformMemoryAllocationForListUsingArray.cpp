#include <iostream>
#include "UniformMemoryAllocationForListUsingArray.h"
node *list;
lnk freelist;
/*
 * construct a free list with n free nodes.
 */
void construct(int N)
{
	list = new node[N];
	for (int i = 0; i < N; i++)
		list[i].next = i + 1;
	list[N-1].next = -1;
	freelist = 0;
}

lnk newNode(int item)
{
	lnk x = remove(freelist);
	list[x].item = item;
	list[x].next = x;
	return x;
}

/* inserts x into the memory pool. to be used in conjunction with remove to delete a node from a client list*/
void deleteNode(lnk x)
{
	insert(freelist, x);
}

/* insert t in front of x */
/* used to insert into the freelist. x is invariably freelist */
void insert(lnk x, lnk t)
{
	if (x < 0) // insert t in the first position
	{
		freelist = t;
		list[t].next = -1;
	}
	else
	{
		list[t].next = list[x].next;
		list[x].next = t;
	}
}

/* unlinks the node ahead of x from the list
 * ret*/
/**
 * unlinks a node from the list
 * @param x freelist[x].next is to be unlinked
 * @return pointer to the unlinked node
 */
lnk remove(lnk x)
{
	if (list[x].next < 0)
	{
		freelist = -1;
		return x;
	}
	else
	{
		lnk t = list[x].next;
		list[x].next = list[t].next;
		return t;
	}

}


lnk next(lnk x)
{
	return list[x].next;
}

Item item(lnk x)
{
	return list[x].item;
}


