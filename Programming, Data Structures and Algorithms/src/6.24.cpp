/*
 * main.cpp
 *
 *  Created on: 15-Jun-2011
 *      Author: kempa
 */

/*
 * 6.24 Do experiments to determine how many passes are saved, for random files
 *  of N elements, when you add to bubble sort a test to terminate when the
 *  file is sorted.
 */


#include<vector>
using std::vector;

#include "adaptiveBubbleSort.h"
using my::adaptiveBubbleSort;

#include "sort.h"
using my::sort;


int main()
{
	vector<int> a;
	sort(&a, &adaptiveBubbleSort);
	return 0;
}
