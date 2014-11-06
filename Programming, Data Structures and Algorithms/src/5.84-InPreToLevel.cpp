/*
 * main.cpp
 *
 *  Created on: 29-May-2011
 *      Author: kempa
 */

/* 5.84 Write a program that takes as input the preorder and inorder traversals
 * of a binary tree, and produces as output the level-order traversal of the
 * tree.
 */
#include<vector>
#include<string>
#include<iostream>
#include<algorithm>
using std::string;
using std::vector;
using std::cout;
using std::endl;

#include"inPreToLevel.h"
#include"preOrder.h"
#include"inOrderIterative.h"
#define MAX 100
#include<cstdlib>

int main()
{
	srand(time(NULL));
	int n = rand() % (MAX / 4);
	vector<int> &v = *(new vector<int> (n));
	cout << "Tree    : ";
	for (int i = 0; i < n; i++)
	{
		int val;
		do
		{
			val = rand() % MAX;
		} while (std::find(v.begin(), v.end(), val) != v.end());
		v[i] = val;
		cout << v[i] << " ";
	}
	cout << endl;

	node<int> *root = GenerateBinarySearchTree(v);

	vector<string> in = inOrder(root);
	cout << "In Order : ";
	for (unsigned i = 0; i < in.size(); i++)
		cout << in[i] << " ";
	cout << endl;

	vector<string> pre = preOrder(root);
	cout << "Pre Order : ";
	for (unsigned i = 0; i < pre.size(); i++)
		cout << pre[i] << " ";
	cout << endl;

	cout << "Level Order : ";
	vector<string> level = inPreToLevel(
			*(new list<string> (pre.begin(), pre.end())), in);
	for (unsigned i = 0; i < level.size(); i++)
		cout << level[i] << " ";
	cout << endl;
	return 0;
}
