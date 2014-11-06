/*
 * sort.h
 *
 *  Created on: 15-Jun-2011
 *      Author: kempa
 */

#ifndef SORT_H_
#define SORT_H_

#include<iostream>
using std::cout;
using std::endl;

#include<vector>
using std::vector;

#include<cstdlib>

#include<sys/time.h>
#include<time.h>

#define MAX 100
namespace my
{
template<class T>
void sort(vector<T> *v, void(*sortFunc)(vector<T>*, int, int))
{
	srand(time(NULL));
	int n = rand() % MAX;
	v->reserve(n);
	for (int i = 0; i < n; i++)
		v->push_back(rand() % (MAX * 10));

	cout << "Before sort" << endl;
	print(v);

	struct timeval then, now;
	gettimeofday(&then, NULL);
	(*sortFunc)(v, 0, n - 1);
	gettimeofday(&now, NULL);
	cout << "After sort" << endl;
	print(v);
	cout << "Time taken = " << now.tv_sec - then.tv_sec + 1e-6 * (now.tv_usec
			- then.tv_usec) <<  " seconds" << endl;

}

template<class T>
void print(vector<T> *v)
{
	for (unsigned i = 0; i < v->size(); i++)
		cout << v->at(i) << " ";
	cout << endl;
}
}

#endif /* SORT_H_ */
