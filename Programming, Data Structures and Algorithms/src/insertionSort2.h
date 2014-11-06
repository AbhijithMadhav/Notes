/*
 * insertionSort2.h
 *
 *  Created on: 15-Jun-2011
 *      Author: kempa
 */

#ifndef INSERTIONSORT2_H_
#define INSERTIONSORT2_H_
#include<vector>
using std::vector;

namespace my
{

/*
 * Implementation of insertion sort with the inner loop coded as a while loop
 * that terminates on one of two conditions, as described in the text.
 * 1. When v >= a[j-1], i.e. the right place to insert v is j
 * 2. When j <= l, i.e. v is the smallest of all elements found. Insert at l
 */
template<typename T>
void insertionSort2(vector<T> *v, int l, int r)
{
	vector<T> &a = *v;
	for (int i = l + 1; i <= r; i++)
	{
		int j = i;
		int t = a[i];
		while (t < a[j - 1] && j > l)
		{
			a[j] = a[j - 1];
			j--;
		}
		a[j] = t;
	}
}

} // namespace my
#endif /* INSERTIONSORT2_H_ */
