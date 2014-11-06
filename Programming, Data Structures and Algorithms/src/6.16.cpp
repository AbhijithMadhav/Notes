/*
 * main.cpp
 *
 *  Created on: 15-Jun-2011
 *      Author: kempa
 */

/*
 * Give an implementation of insertion sort with the inner loop coded as a while
 *  loop that terminates on one of two conditions, as described in the text.
 */


#include<vector>
using std::vector;

#include "insertionSort2.h"
using my::insertionSort2;

#include "sort.h"
using my::sort;


int main()
{
	vector<int> a;
	sort(&a, &insertionSort2);
	return 0;
}
