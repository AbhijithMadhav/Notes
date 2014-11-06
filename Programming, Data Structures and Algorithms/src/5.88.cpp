/*
 * main.cpp
 *
 *  Created on: 04-Jun-2011
 *      Author: kempa
 */

/*
 * 5.88 Write a recursive program that computes the internal path length of a
 * binary tree, using Definition 5.6.
 */



#include<iostream>
using std::cout;
using std::endl;

#include<cstdlib>
#include"cpp_node.h"
#include"generateBinarySearchTree.h"
#include"internalPathLength.h"

#include<vector>
using std::vector;


#define MAX 10

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
	cout << "Internal Path length: " << internalPathLength(root, 0) << endl;
	return 0;
}
