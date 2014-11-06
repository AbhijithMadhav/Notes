/*
 * 5.17.cpp
 *
 *  Created on: 22-Apr-2011
 *      Author: kempa
 */

#include<list>
#include<iostream>
#include<cstdlib>
#define MAX 100
using std::cout;
using std::endl;
using std::list;

/*
 * 5.17 Write a recursive program that finds the maximum element in a linked
 * list
 *
 * Note:
 * Finding the mid element(as in program 5.6) of the list requires traversal.
 * So, maximum is found using the strategy of comparing the first element
 * against the maximum of the rest of the list as in program 5.16
 */

/*
 * Maximum is determined by comparing the first element in the list against the
 *   maximum element in the rest of the list
 * 'first' is the pointer to the element which forms the first subset of the list
 * The second subset is the rest of the list
 */
int max(list<int> &a, list<int>::iterator first)
{
	list<int>::iterator second = first;
	second++;

	if (second == a.end())
		return *first;


	int x = *first;
	int y = max(a, second);

	if (x > y)
		return x;
	else
		return y;
}

int main()
{
	srand(time(NULL));
	int size = (rand() % MAX) + 1;

	list<int> a;
	cout << "Array contents\n";
	for(int i = 0; i < size; i++)
	{
		a.push_front(rand() % MAX);
		cout << a.front() << " ";
	}
	cout << endl;

	cout << "Max = " << max(a, a.begin()) << endl;
	return 0;
}
