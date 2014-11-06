#include "list.h"
#include <iostream>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	int i, N = atoi(argv[1]), M = atoi(argv[2]);
	list::Node t, x;
	list::construct(N);
	for (i = 2, x = list::newNode(1); i <= N; i++)
	{
		t = list::newNode(i);
		list::insert(x, t);
		x = t;
	}
	while (x != list::next(x))
	{
		for (i = 1; i < M; i++)
			x = list::next(x);
		list::deleteNode(remove(x));
	}
	std::cout << list::item(x) << std::endl;
	return 0;
}
