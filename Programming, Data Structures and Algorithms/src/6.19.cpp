/*
 * main.cpp
 *
 *  Created on: 15-Jun-2011
 *      Author: kempa
 */

/*
 * 6.19 Give a nonadaptive implementation of selection sort based on finding the
 * minimum element with code like the first for loop in Program 6.3.
 */


#include<vector>
using std::vector;

#include "nonAdaptiveSelectionSort.h"
using my::nonAdaptiveSelectionSort;

#include "sort.h"
using my::sort;


int main()
{
	vector<int> a;
	sort(&a, &nonAdaptiveSelectionSort);
	return 0;
}
