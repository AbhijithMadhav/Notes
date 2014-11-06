/*
 * main.cpp
 *
 *  Created on: 02-Jun-2011
 *      Author: kempa
 */

/*
 * 5.86 Write a program that counts the leaves in a binary tree.
 */

#include<iostream>
using std::cout;
using std::endl;

#include<cstdlib>
#include"generateBinarySearchTree.h"
#include"countLeaves.h"

#include<vector>
using std::vector;


#define MAX 100

int main()
{
	srand(time(NULL));
	int n = rand() % MAX + 1;
	vector<int> &v = *(new vector<int> (n));
	cout << "Tree    : ";
	for (int i = 0; i < n; i++)
	{
		v[i] = rand() % 100;
		cout << v[i] << " ";
	}
	cout << endl;

	node<int> *root = GenerateBinarySearchTree(v);
	cout << "Number of leaves: " << nleaves(root) << endl;
	return 0;
}
