/*
 * nonAdaptiveSelectionsort.h
 *
 *  Created on: 15-Jun-2011
 *      Author: kempa
 */

#ifndef NONADAPTIVESELECTIONSORT_H_
#define NONADAPTIVESELECTIONSORT_H_

#include "compexch.h"
using my::compexch;

namespace my {

template<typename T>
void nonAdaptiveSelectionSort(vector<T> *v, int l, int r)
{
	vector<T> &a = *v;
	for(int i = 0; i < r - l; i++) // one round of compexch per element except for the last one
		for(int j = r; j > l; j--)
			compexch(a[j-1], a[j]);
}
}

#endif /* NONADAPTIVESELECTIONSORT_H_ */
