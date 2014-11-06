/*
 * ReveresListRecursive.cpp
 *
 *  Created on: 18-Apr-2011
 *      Author: kempa
 */

#include<iostream>
#include<cstdlib>
#include"UniformMemoryAllocationForList.h"

using list::link;
using std::cout;
using std::endl;

link first;

void reverse(link c, link p)
{
	if (c->next())
		reverse(c->next(), c);
	c->link = p;
}

int main()
{
	srand(time(NULL));
	int n = rand() % 100;

	construct(n);

	for (int i = 0; i < n; i++)
	{


	}

}
