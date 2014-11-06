/*
 * main.cpp
 *
 *  Created on: 29-May-2011
 *      Author: kempa
 */

#include "generateBinarySearchTree.h"
#include "postOrderIterative.h"

#include<cstdlib>
#include<vector>
using std::vector;
#define MAX 20
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
	cout << "Post Order : ";
	vector<string> t(postOrder(root));
	for (unsigned i = 0; i < t.size(); i++)
		cout << t[i] << " ";
	cout << endl;
	return 0;
}
