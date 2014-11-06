/*
 * JosepusRecursive.cpp
 *
 *  Created on: 17-Apr-2011
 *      Author: kempa
 */

#include<list>
#include<iostream>
#include<cstdlib>

using std::list;
using std::cout;
using std::endl;
typedef list<long>::iterator iterator;

/* A list is chosen instead of a vector(array like data structure) because
 * . random access is not required, which is efficient in a vector than a list
 * . deletion of arbitrary element is efficient in a list compared to a vector
 *
 */
list<long> *a;
int n, m, count = 0;

int josephus(iterator i)
{
	// simulating circular list for a list
	if (i == a->end())
		i = a->begin();

	count++; // Counts number of people skipped
	if (a->size() == 1) // trivial case - if there is only one person left
		return (*i);
	else
	{
		if (count == m)
		{
			count = 0;
			i = a->erase(i);
			return josephus(i);
		}
		else
			return (josephus(++i));
	}
}

int main()
{
	srand(time(NULL));

	n = rand() % 1000;
	m = rand() % n;

	a = new list<long> (n);

	iterator i = a->begin();
	for (long j = 1; j <= n; j++, i++)
		*i = j;
	cout << "Number of people, n : " << n << endl;
	cout << "Skip Position, m : " << m << endl;
	i = a->begin();
	int result = josephus(i);
	cout << "\nLast person standing: " << result << endl;
	return 0;
}
