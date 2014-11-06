#include <iostream>
#include "UniformMemoryAllocationForList.h"
namespace list
{

link freelist;

/*
 * construct a free list with n free nodes.
 * the list is a linear list with a dummy head node
 * dummy head node is pointed by free list
 */
void construct(int N)
{
	freelist = new node[N + 1];
	for (int i = 0; i < N; i++)
	{
		//freelist[i].item = i;
		freelist[i].next = &freelist[i + 1];
	}
	freelist[N].item = N;
	freelist[N].next = 0;
}

link newNode(int i)
{
	link x = remove(freelist);
	x->item = i;
	x->next = x;
	return x;
}

/* inserts x into the memory pool. to be used in conjunction with remove to delete a node from a client list*/
void deleteNode(link x)
{
	insert(freelist, x);
}

void insert(link x, link t)
{
	t->next = x->next;
	x->next = t;
}

/* unlinks the node ahead of x from the list
 * ret*/
/**
 * unlinks a node fromt the list
 * @param x x->next is to be unlinked
 * @return pointer to the unlinked node
 */
link remove(link x)
{
	if (x != x->next)
	{
		link t = x->next;
		x->next = t->next;
		return t;
	}
	else // only one link
		return x;
}

link next(link x)
{
	return x->next;
}

Item item(link x)
{
	return x->item;
}

void display(link x)
{
	if (x)
	{
	link t = x;
	while (x->next != t)
	{
		std::cout << x->item << " ";
		x = x->next;
	}
	std::cout << x->item << std::endl;
	}
	else
		std::cout << "Empty" << std::endl;
}

int freelistNum()
{
	link x = freelist->next;
	int count = 0;
	while (x != 0)
	{
		count++;
		x = x->next;
	}
	return count;
}
}
