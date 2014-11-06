/*
 * adaptiveBubbleSort.h
 *
 *  Created on: 16-Jun-2011
 *      Author: kempa
 */

#ifndef ADAPTIVEBUBBLESORT_H_
#define ADAPTIVEBUBBLESORT_H_

#include "compexch.h"
using my::compexch;

namespace my
{

template<class T>
void adaptiveBubbleSort(vector<T> *v, int l, int r)
{
	vector<T> &a = *v;
	for (int i = l, swapped = true; swapped; i++)
	{
		swapped = false;
		for (int j = r; j > i; j--)
			swapped = compexch(a[j-1], a[j]);
	}
}

}
#endif /* ADAPTIVEBUBBLESORT_H_ */
