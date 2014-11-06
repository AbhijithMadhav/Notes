/*
 * 3.27.cpp
 *
 *  Created on: 23-Sep-2010
 *      Author: kempa
 *
 *      When building the list, Program 3.9 sets twice as many Link
 *      values as it needs to because it maintains a circular list
 *      after each node is inserted. modify the program to build the
 *      circular list without doing this extra work.
 */

#include <iostream>
#include <cstdlib>
#include <ctime>
#include "Algorithm.h"
#define MAX_N 50000

int main()
{
	srand(time(0));
	int n = rand()%MAX_N , m = rand() % n;
	clock_t start = clock();
	int temp = josephus(m, n);
	clock_t end = clock();

	std::cout << "number of people, n : " << n << std::endl;
	std::cout << "Skip Position, m : " << m << std::endl;
	std::cout << "Last standing guy/gal : " << temp << std::endl;
	std::cout << "Clock ticks taken using 'josephus' : " \
			<< (double)(end-start) << std::endl;

	start = clock();
	temp = josephus(m, n);
	end = clock();
	std::cout << "Clock ticks taken using 'josephusOptimized': " \
			<< (double)(end-start) << std::endl;
}
