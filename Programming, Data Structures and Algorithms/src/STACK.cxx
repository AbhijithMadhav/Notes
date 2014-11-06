/*
 * STACK.cxx
 *
 *  Created on: 25-Mar-2011
 *      Author: kempa
 */

#include<iostream>
using std::cout;
using std::endl;
typedef int Item;

template<class Item>
class STACK
{
private:
	Item *s;
	int N;
public:
	STACK(int maxN)
	{
		s = new Item[maxN];
		N = 0;
	}
	int empty() const
	{
		return N == 0;
	}
	void push(Item item)
	{
		s[N++] = item;
	}
	Item pop()
	{
		return s[--N];
	}
	void print()
	{
		for (int i = 0; i < N; i++)
			cout << s[i] << " ";
		cout << endl;
	}

};
