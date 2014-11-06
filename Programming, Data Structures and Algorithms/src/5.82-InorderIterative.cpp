/*
 * main.cpp
 *
 *  Created on: 29-May-2011
 *      Author: kempa
 */
#include<cstdlib>
#include<vector>
#include<iostream>
#include<cstddef>
using std::cout;
using std::endl;
using std::vector;

#include "generateBinarySearchTree.h"
#include "inOrderIterative.h"
#define MAX 20

template<class T>
vector<string> inOrder(node<T> *root);

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
	cout << "Inorder : ";
	vector<string> t(inOrder(root));
	for (unsigned i = 0; i < t.size(); i++)
		cout << t[i] << " ";
	cout << endl;
	return 0;
}
